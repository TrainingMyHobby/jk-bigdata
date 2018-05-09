package jk.bd.app.dto

import org.joda.time.DateTime
import jk.bd.app.util.AppUtil

class IngestCtxtInfo() {

  private var ingestConfig: UserConfig = _
  private var ingestDateTime: DateTime = null
  private val ingestDateFormat = AppUtil.buildIngestDateTimeFormat(ingestDateTime)

  // *****************************************************
  // START Get & Set Methods for class members
  // *****************************************************

  def setUserConfig(ingestUserConfig: UserConfig): Unit = this.ingestConfig = ingestUserConfig

  def getUserConfig() = ingestConfig

  def setIngestDateTime(ingestDateTime: DateTime): Unit = this.ingestDateTime = ingestDateTime

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

  def buildTableIngestDestPath(dbName: String, tableName: String) = getDestLndBasePath() + "/" + dbName + "/" + tableName

  def buildTableIngestDestPathWithDate(dbName: String, tableName: String) = buildTableIngestDestPath(dbName, tableName) + "/" + ingestDateFormat

}