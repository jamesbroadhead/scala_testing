package com.github.jamesbroadhead.fun_with_implicits

import java.io.File
import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.{FunSuite, MustMatchers}
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar

@RunWith(classOf[JUnitRunner])
class FileMapperSpec extends FunSuite
  with MustMatchers
  with MockitoSugar {
    val fileMapper = new FileMapper()

    def mkdir() = {
      val emptyDir = mock[File]
      when(emptyDir.isDirectory())
        .thenReturn(true)
      when(emptyDir.isFile())
        .thenReturn(false)
      when(emptyDir.listFiles)
        .thenReturn(new Array[File](0))
      emptyDir
    }

    test("recurseDirectory succeeds on empty directory") {
      val emptyDir = mkdir()
      assert(fileMapper.recurseDirectory(emptyDir) == List())
    }
}
