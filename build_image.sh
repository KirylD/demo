#!/bin/bash

echo "##### Build jar artifact #####"
./gradlew.bat clean build -x test

echo "##### Build docker image #####"
docker image build -t demo .


