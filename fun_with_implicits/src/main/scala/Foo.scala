package com.github.jamesbroadhead.fun_with_implicits

import java.io.{File, FileNotFoundException}
import scala.language.implicitConversions

object IsDirectory {
  def unapply(file: File): Option[File] = {
    if (file.isDirectory) Some(file) else None
  }
}

object IsFile {
  def unapply(file: File): Option[File] = {
    if (file.isFile) Some(file) else None
  }
}

class FileMapper() {

  implicit def arrayToList(array: Array[File]): List[File] = array.toList

  def recurseDirectory(dir: File): List[File] = {
    dir match {
      case IsDirectory(directory) => directory.listFiles flatMap recurseDirectory
      case IsFile(file) => List(file)
    }
  }
}
