#!/bin/sh
#!/bin/bash

APP1_NAME="mss-cloud-config-server"
APP1_JAVA_PROCESS=$(pgrep -f $APP1_NAME)

if [ -z "$APP1_JAVA_PROCESS" ]; then
  echo "No running instance of $APP1_NAME found."
else
  echo "Stopping $APP1_NAME..."
  kill $APP1_JAVA_PROCESS
fi
sleep 2
APP2_NAME="mss-application"
APP2_JAVA_PROCESS=$(pgrep -f $APP2_NAME)

if [ -z "$APP2_JAVA_PROCESS" ]; then
  echo "No running instance of $APP2_NAME found."
else
  echo "Stopping $APP2_NAME..."
  kill $APP2_JAVA_PROCESS
fi
sleep 2
APP3_NAME="mss-cloud-gateway-server"
APP3_JAVA_PROCESS=$(pgrep -f $APP3_NAME)

if [ -z "$APP3_JAVA_PROCESS" ]; then
  echo "No running instance of $APP3_NAME found."
else
  echo "Stopping $APP3_NAME..."
  kill $APP3_JAVA_PROCESS
fi
sleep 2
APP4_NAME="mss-stub-server"
APP4_JAVA_PROCESS=$(pgrep -f $APP4_NAME)

if [ -z "$APP4_JAVA_PROCESS" ]; then
  echo "No running instance of $APP4_NAME found."
else
  echo "Stopping $APP4_NAME..."
  kill $APP4_JAVA_PROCESS
fi

exit 0