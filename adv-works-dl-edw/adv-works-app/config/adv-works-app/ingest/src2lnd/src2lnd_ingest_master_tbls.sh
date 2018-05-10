#!/bin/sh

CURRENT_DIR_PATH="$(pwd -P)"

. "${CURRENT_DIR_PATH}/../../application.conf"

"$CURRENT_DIR_PATH/src2lnd_ingest_common.sh" "$CURRENT_DIR_PATH/src2lnd-master-tables-conf.properties" "$CURRENT_DIR_PATH/src2lnd-master-tables-conf.properties"

