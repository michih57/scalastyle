// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.scalastyle

import java.io.File

import org.junit.Assert.assertEquals
import org.junit.Test
import org.scalatestplus.junit.AssertionsForJUnit

class SourceFileParserTest extends AssertionsForJUnit {

  @Test
  def parseEmptyFile(): Unit = {
    val configPath = "src/test/resources/config/scalastyle_config.xml"
    val config = ScalastyleConfiguration.readFromXml(configPath)
    val checks = config.checks.filter(_.enabled)
    val sourcePath = new File("src/test/resources/testfiles/EmptyClass.scala")
    val sourceFile =
      new DirectoryFileSpec(sourcePath.getAbsolutePath(), encoding = None, sourcePath.getAbsoluteFile())
    val msgs = new CheckerUtils().verifyFile(config, checks, sourceFile)
    assertEquals(Nil, msgs)
  }
}
