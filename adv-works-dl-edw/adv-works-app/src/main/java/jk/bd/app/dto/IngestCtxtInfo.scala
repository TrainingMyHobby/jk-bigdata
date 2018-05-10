package jk.bd.app.dto

import org.joda.time.DateTime
import jk.bd.app.util.AppUtil

case class IngestCtxtInfo(ingestConfig: UserConfig, ingestDateTime: DateTime) {

  private val ingestDateFormat = AppUtil.buildIngestDateTimeFormat(ingestDateTime)

  // *****************************************************
  // START Get & Set Methods for class members
  // *****************************************************

  def getUserConfig() = ingestConfig

  def getIngestDateTime() = ingestDateTime

  // *****************************************************
  // END Get & Set Methods for class members
  // *****************************************************

  def getSrcDBName() = ingestConfig.getConfig("SRC_DB_NAME")

  def getSrcTableNamesCSV() = ingestConfig.getConfig("SRC_TABLE_NAMES_CSV")

  def getDestDBName() = ingestConfig.getConfig("DEST_DB_NAME")

  def getDestTableNamesCSV() = ingestConfig.getConfig("DEST_TABLE_NAMES_CSV")

  def getIngestCommand(dbName: String, tableName: String) = ingestConfig.getConfig("INGEST_CMD")

  def getIngestCommandSuffix(dbName: String, tableName: String) = ingestConfig.getConfig("INGEST_CMD_SUFFIX", "")

  def getDestLndBasePath() = ingestConfig.getConfig("DEST_BASE_PATH")

  def isOneTimeIngestOnly(): Boolean = "true".equalsIgnoreCase(ingestConfig.getConfig("ONE_TIME_INGEST_ONLY"))

  def buildTableIngestDestPath(dbName: String, tableName: String) = getDestLndBasePath() + "/" + dbName + "/" + tableName

  def buildTableIngestDestPathWithDate(dbName: String, tableName: String) = buildTableIngestDestPath(dbName, tableName) + "/" + ingestDateFormat

}