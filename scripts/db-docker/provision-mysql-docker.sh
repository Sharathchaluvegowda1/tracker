#!/bin/bash

docker-compose up -d

sleep 10
docker-compose run tracker-database-create
