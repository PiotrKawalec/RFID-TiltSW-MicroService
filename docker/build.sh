#! /bin/bash -e

rm -fr build
mkdir build
cp ../build/libs/rfid-tilt-0.0.1-SNAPSHOT.jar build
docker build -t rfid-tilt_ms .