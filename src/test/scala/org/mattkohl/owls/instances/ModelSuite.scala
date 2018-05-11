package org.mattkohl.owls.instances

import model._
import cats.syntax.semigroup._
import cats.syntax.show._
import org.junit.runner.RunWith
import org.mattkohl.owls.ModelBase
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ModelSuite extends ModelBase {

  test("semigroup combine") {
    val result = m1 |+| m2
    assert(result.size == m1.size + m2.size)
  }

  test("show pretty prints the statements") {
    val expected =
      """<http://example.org/subject> <http://example.org/predicate> "3"^^<http://www.w3.org/2001/XMLSchema#integer> .
        |<http://example.org/subject> <http://example.org/predicate> "object1" .
        |<http://example.org/subject> <http://example.org/predicate> "object2"""".stripMargin

    assert((m1 |+| m2 |+| m3).show == expected)
  }
}
