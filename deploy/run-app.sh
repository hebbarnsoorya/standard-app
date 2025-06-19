#!/bin/bash

JAR_NAME="my-app.jar"
EXTRA_CONFIG_FILE="standard-app.properties"

# Check if jar exists
if [[ ! -f "$JAR_NAME" ]]; then
  echo "ERROR: $JAR_NAME not found!"
  exit 1
fi

# Warn if external file doesn't exist
if [[ -f "$EXTRA_CONFIG_FILE" ]]; then
  echo "Using external config override: $EXTRA_CONFIG_FILE"
else
  echo "WARNING: $EXTRA_CONFIG_FILE not found – proceeding with defaults only"
fi

java -jar "$JAR_NAME" --spring.config.additional-location="file:./$EXTRA_CONFIG_FILE"
