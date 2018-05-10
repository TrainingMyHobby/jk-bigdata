#!/bin/sh

CURRENT_DIR_PATH="$(pwd -P)"

$JAVA_CMD_HOME/java -cp $ADV_WORKS_APP_LIBS_PATH/*:$ADV_WORKS_APP_CONFIG_PATH jk.bd.app.ingest.Src2LndCLI %1