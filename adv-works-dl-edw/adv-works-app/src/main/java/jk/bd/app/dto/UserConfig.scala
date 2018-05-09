package jk.bd.app.dto

import java.util.Properties
import java.io.File
import java.io.FileReader

case class UserConfig(userConfigFile: String) {

  val conf = new Properties()
  conf.load(new FileReader(new File(userConfigFile)))

  def getConfig(key: String) = conf.getProperty(key)

  def getConfig(key: String, defaultVal: String) = conf.getProperty(key, defaultVal)

}