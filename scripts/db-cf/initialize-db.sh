#!/bin/bash

######################################################################
# Create database service instance
#
#   Arguments
#   - $1: Cloud Foundry Cloud Controller endpoint
#   - $2: Organization
#   - $3: Space
#   - $4: User Name (password will be prompted for interactively)
#   - $5: MySQL Service (i.e. p.mysql for PCF, cleardb for PWS)
#   - $6: MySQL Service plan (i.e. db-small for PCF, spark for PWS)
######################################################################

cf login -a api.run.pivotal.io -o $2 -s $3 -u $4

cf create-service $5 $6 tracker-database
