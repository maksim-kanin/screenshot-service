#!/bin/bash
CONFIG_PATH=./src/main/resources POSTGRES_USER=$1 POSTGRES_PASSWORD=$2 docker-compose up -d
