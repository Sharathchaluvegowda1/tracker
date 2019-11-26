#!/bin/bash

######################################################################
# Verify Tracker codebase and deployment
#
#   Arguments
#   - $1: MySQL Service (i.e. p.mysql for PCF, cleardb for PWS)
#   - $2: MySQL Service plan (i.e. db-small for PCF, spark for PWS)
######################################################################

function process-checkpoints() {
    for checkpoint in `cat ./checkpoint.list`
        do
            verify-checkpoint ${checkpoint}
        done
}

function verify-checkpoint() {
    git reset --hard $1

    echo "Building `git tag -l --points-at HEAD`..."
    ./gradlew clean build >> ./build.log

    retVal=$?
    if [ $retVal -ne 0 ]; then
        echo "Build failed for `git tag -l --points-at HEAD`"
        echo "Check build.log file for more information"
        exit $retVal
    fi

    ./gradlew clean >> ./build.log
    echo "Build complete for `git tag -l --points-at HEAD`"
}

cd ~/workspace/tracker

process-checkpoints

cf target

retVal=$?
if [ $retVal -ne 0 ]; then
    echo "Not logged into Cloud Foundry."
    exit $retVal
fi

./gradlew clean build

cf create-service $1 $2 tracker-database
cf push

retVal=$?
if [ $retVal -ne 0 ]; then
    echo "CF push failed"
    exit $retVal
fi

cf delete tracker -r -f
cf delete-service tracker-database -f

