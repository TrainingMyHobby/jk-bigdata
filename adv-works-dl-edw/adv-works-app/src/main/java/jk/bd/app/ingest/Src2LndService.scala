package jk.bd.app.ingest

import jk.bd.app.dto.IngestCtxtInfo

class Src2LndIngestService {

  case class ATableIngestInfo(srcDbName: String, destDbName: String, srcTblName: String, destTableName: String) {

  }

  def execute(ingestCtxtInfo: IngestCtxtInfo): Unit = {

    val srcDbName = ingestCtxtInfo.getSrcDBName()
    val destDbName = ingestCtxtInfo.getSrcDBName()

    val srcTableNames = ingestCtxtInfo.getSrcTableNamesCSV().split(",")
    val destTableNames = ingestCtxtInfo.getDestTableNamesCSV().split(",")

    srcTableNames.zipWithIndex foreach {
      case (srcTblName, indexNo) => {
        val destTblName = destTableNames(indexNo)

        val aTblIngestInfo = new ATableIngestInfo(srcDbName, destDbName, srcTblName, destTblName)
        executeATableIngest(aTblIngestInfo)
      }
    }
  }

  private def executeATableIngest(aTblIngestInfo: ATableIngestInfo): Unit = {

    
  }

}