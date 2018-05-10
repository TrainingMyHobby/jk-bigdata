package jk.bd.app.dto

import org.joda.time.DateTime

case class ATableIngestInfo(srcDbName: String, destDbName: String, srcTableName: String, destTableName: String, ingestDateTime: DateTime) {

  var ingestCommand: String = _

  var businessDateYYYY: Int = 0
  var businessDateMONTH: Int = 0
  var businessDateDAY: Int = 0

  var processName: String = _
  var subProcessName: String = _

  var oneTimeIngestOnly: Boolean = false

  def setOneTimeIngestOnly(oneTimeIngestOnly: Boolean): Unit = this.oneTimeIngestOnly = oneTimeIngestOnly

  def isOneTimeIngestOnly() = this.oneTimeIngestOnly

}