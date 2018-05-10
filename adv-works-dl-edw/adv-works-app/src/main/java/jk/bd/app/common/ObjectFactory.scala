package jk.bd.app.common

import jk.bd.app.ingest.Src2LndIngestService

object ObjectFactory {

  private var src2lndIngestService: Src2LndIngestService = new Src2LndIngestService()

  def getSrc2LndIngestService() = src2lndIngestService

}