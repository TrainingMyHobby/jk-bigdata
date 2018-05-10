package jk.bd.app.ingest

import jk.bd.app.dto.ATableIngestInfo
import jk.bd.app.dto.IngestCtxtInfo
import jk.bd.app.util.IngestUtil

class Src2LndIngestService {

  def execute(ingestCtxtInfo: IngestCtxtInfo): Unit = {

    val srcDbName = ingestCtxtInfo.getSrcDBName()
    val destDbName = ingestCtxtInfo.getSrcDBName()

    val srcTableNames = ingestCtxtInfo.getSrcTableNamesCSV().split(",")
    val destTableNames = ingestCtxtInfo.getDestTableNamesCSV().split(",")

    val oneTimeIngestOnly = ingestCtxtInfo.isOneTimeIngestOnly()

    srcTableNames.zipWithIndex foreach {
      case (srcTblName, indexNo) => {
        val destTblName = destTableNames(indexNo)

        val aTblIngestInfo = new ATableIngestInfo(srcDbName, destDbName, srcTblName, destTblName, ingestCtxtInfo.ingestDateTime)
        aTblIngestInfo.setOneTimeIngestOnly(oneTimeIngestOnly)

        executeATableIngest(aTblIngestInfo, ingestCtxtInfo)
      }
    }
  }

  private def executeATableIngest(aTblIngestInfo: ATableIngestInfo, ingestCtxtInfo: IngestCtxtInfo): Unit = {

    val ingestCmd = ingestCtxtInfo.getIngestCommand(aTblIngestInfo.destDbName, aTblIngestInfo.destTableName)

    IngestUtil.replaceIngestCmdVariableWithValues(ingestCmd, aTblIngestInfo, ingestCtxtInfo)
  }

  private def determineAndPopulateATableIngestBusinessDate(aTblIngestInfo: ATableIngestInfo, ingestCtxtInfo: IngestCtxtInfo): Unit = {

  }

}