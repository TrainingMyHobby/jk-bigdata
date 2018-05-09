package jk.bd.app.util

import org.joda.time.DateTime
import java.time.format.DateTimeFormatter

object AppUtil {

  private val df_YYYYMMDDHHMMSS = "yyyy-MM-dd-HH:mm:ss";

  def buildIngestDateTimeFormat(ingestDateTime: DateTime): String = {

    if (ingestDateTime != null) {
      return ingestDateTime.toString(df_YYYYMMDDHHMMSS)
    }

    null
  }
}