#!/bin/sh
#!/bin/bash

APP1_PATH="mss-cloud-config-server/target/mss-cloud-config-server.jar"
APP2_PATH="mss-application/target/mss-application.jar"
APP3_PATH="mss-cloud-gateway-server/target/mss-cloud-gateway-server.jar"
APP4_PATH="mss-stub-server/target/mss-stub-server.jar"

java -jar $APP1_PATH &
sleep 10
java -jar $APP2_PATH &
sleep 10
java -jar $APP3_PATH &
sleep 10
java -jar $APP4_PATH &
