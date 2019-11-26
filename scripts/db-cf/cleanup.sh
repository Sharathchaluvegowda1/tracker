#!/bin/bash

cf delete tracker -f -r
cf delete-service tracker-database -f
