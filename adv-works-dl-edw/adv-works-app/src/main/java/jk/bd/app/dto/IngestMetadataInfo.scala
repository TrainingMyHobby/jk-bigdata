package jk.bd.app.dto

import org.joda.time.DateTime

class IngestMetadataInfo extends java.io.Serializable {

  var tblIngestInfo: TableIngestInfo = _

  var startedAt: DateTime = _
  var endedAt: DateTime = _

  def setStartedAt(startedAt: DateTime): Unit = this.startedAt = startedAt

  def getStartedAt() = this.startedAt

  def setEndedAt(endedAt: DateTime): Unit = this.endedAt = endedAt

  def getEndedAt() = this.endedAt

  def setTableIngestInfo(tblIngestInfo: TableIngestInfo): Unit = this.tblIngestInfo = tblIngestInfo

  def getTableIngestInfo() = this.tblIngestInfo

}