package jk.bd.app.util

import org.slf4j.LoggerFactory

import jk.bd.app.common.IngestConstants
import jk.bd.app.dto.ATableIngestInfo
import jk.bd.app.dto.IngestCtxtInfo

object IngestUtil {

  private val LOGGER = LoggerFactory.getLogger(this.getClass)

  val INGEST_VAR_NAMES = Seq(IngestConstants.SRC_DB_NAME, IngestConstants.SRC_TABLE_NAMES_CSV, IngestConstants.DEST_DB_NAME, IngestConstants.DEST_TABLE_NAMES_CSV,
    IngestConstants.DEST_BASE_PATH, IngestConstants.INGEST_CMD, IngestConstants.INGEST_CMD_SUFFIX)

  def replaceIngestCmdVariableWithValues(ingestCmd: String, aTblIngestInfo: ATableIngestInfo, ingestCtxtInfo: IngestCtxtInfo): String = {

    var ingestCmdUpdated = ingestCmd
    ingestCmdUpdated = fillDbAndTableNames(ingestCmdUpdated, aTblIngestInfo, ingestCtxtInfo)
    ingestCmdUpdated = fillIngestDateValues(ingestCmdUpdated, aTblIngestInfo, ingestCtxtInfo)

    INGEST_VAR_NAMES.foreach(varName => {

      ingestCmdUpdated = fillVariableValue(varName, ingestCmdUpdated, aTblIngestInfo, ingestCtxtInfo)
    })

    LOGGER.debug(s"Exit Ingest Command $ingestCmdUpdated")
    ingestCmdUpdated
  }

  private def fillDbAndTableNames(ingestCmdUpdated: String, aTblIngestInfo: ATableIngestInfo, ingestCtxtInfo: IngestCtxtInfo): String = {

    var ingestCmdUpdatedVal = ingestCmdUpdated.replaceAll(IngestConstants.SRC_DB_NAME, aTblIngestInfo.srcDbName)
    ingestCmdUpdatedVal = ingestCmdUpdatedVal.replaceAll(IngestConstants.DEST_DB_NAME, aTblIngestInfo.destDbName)

    ingestCmdUpdatedVal = ingestCmdUpdatedVal.replaceAll(IngestConstants.SRC_TABLE_NAME, aTblIngestInfo.srcTableName)
    ingestCmdUpdatedVal = ingestCmdUpdatedVal.replaceAll(IngestConstants.DEST_TABLE_NAME, aTblIngestInfo.destTableName)

    ingestCmdUpdatedVal
  }

  private def fillIngestDateValues(ingestCmdUpdated: String, aTblIngestInfo: ATableIngestInfo, ingestCtxtInfo: IngestCtxtInfo): String = {

    var ingestCmdUpdatedVal = ingestCmdUpdated.replaceAll(IngestConstants.INGEST_DATE_YYYY, aTblIngestInfo.ingestDateTime.getYear() + "")

    val monthVal = aTblIngestInfo.ingestDateTime.getMonthOfYear()
    var monthValStr = monthVal + ""
    if (monthVal < 10) monthValStr = "0" + monthValStr
    ingestCmdUpdatedVal = ingestCmdUpdatedVal.replaceAll(IngestConstants.INGEST_DATE_MONTH, monthValStr)

    val dayVal = ingestCtxtInfo.ingestDateTime.getDayOfMonth()
    var dayValStr = dayVal + ""
    if (monthVal < 10) dayValStr = "0" + dayValStr
    ingestCmdUpdatedVal = ingestCmdUpdatedVal.replaceAll(IngestConstants.INGEST_DATE_DD, dayValStr)

    ingestCmdUpdatedVal = ingestCmdUpdatedVal.replaceAll(IngestConstants.INGEST_DATE_HH, aTblIngestInfo.ingestDateTime.getHourOfDay() + "")
    ingestCmdUpdatedVal = ingestCmdUpdatedVal.replaceAll(IngestConstants.INGEST_DATE_MM, aTblIngestInfo.ingestDateTime.getMinuteOfHour() + "")
    ingestCmdUpdatedVal = ingestCmdUpdatedVal.replaceAll(IngestConstants.INGEST_DATE_SS, aTblIngestInfo.ingestDateTime.getSecondOfMinute() + "")

    ingestCmdUpdatedVal
  }

  private def fillVariableValue(varName: String, ingestCmdUpdated: String, aTblIngestInfo: ATableIngestInfo, ingestCtxtInfo: IngestCtxtInfo): String = {

    var ingestCmdUpdatedVal = ingestCmdUpdated.replaceAll(varName, ingestCtxtInfo.ingestConfig.getConfig(varName))

    ingestCmdUpdatedVal
  }

}