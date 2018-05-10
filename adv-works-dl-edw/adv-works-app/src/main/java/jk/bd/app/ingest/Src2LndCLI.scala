package jk.bd.app.ingest

import jk.bd.app.common.ObjectFactory
import jk.bd.app.dto.UserConfig
import jk.bd.app.dto.IngestCtxtInfo
import org.joda.time.DateTime

object Src2LndCLI {

  def main(args: Array[String]) {

    val ingestDateTime = new DateTime()
    val ingestUserConfigFile = args(0)
    val ingestUserConfig = new UserConfig(ingestUserConfigFile)

    val ingestCtxtInfo = new IngestCtxtInfo(ingestUserConfig, ingestDateTime)

    ObjectFactory.getSrc2LndIngestService().execute(ingestCtxtInfo)
  }

}