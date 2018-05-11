package org.mattkohl.owls.instances

import cats.syntax.semigroup._
import cats.syntax.show._
import org.junit.runner.RunWith
import org.mattkohl.owls.DatasetBase
import org.mattkohl.owls.instances.dataset._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DatasetSuite extends DatasetBase {

  test("semigroup combine") {
    val result = d1 |+| d2
    assert(result containsNamedModel "foo")
    assert(result containsNamedModel "bar")
  }

  test("show pretty prints the quads") {
    val expected = """<foo> <http://example.org/subject> <http://example.org/predicate> "object1" .
                     |<bar> <http://example.org/subject> <http://example.org/predicate> "object2"""".stripMargin
    assert((d1 |+| d2).show == expected)
  }
}
