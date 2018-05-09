package jk.bd.app.ingest

import jk.bd.app.common.ObjectFactory
import jk.bd.app.dto.UserConfig
import jk.bd.app.dto.IngestCtxtInfo
import org.joda.time.DateTime

object Src2LndCLI {

  def main(args: Array[String]) {

    // initialize all the objects
    ObjectFactory.initialize()

    val ingestDateTime = new DateTime()
    val ingestUserConfigFile = args(0)
    val ingestUserConfig = new UserConfig(ingestUserConfigFile)

    val ingestCtxtInfo = new IngestCtxtInfo()
    ingestCtxtInfo.setUserConfig(ingestUserConfig)
    ingestCtxtInfo.setIngestDateTime(ingestDateTime)

    ObjectFactory.getSrc2LndIngestService().execute(ingestCtxtInfo)
  }

}