package owls.instances

import model._
import cats.syntax.semigroup._
import cats.syntax.show._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import owls.ModelBase

@RunWith(classOf[JUnitRunner])
class ModelSuite extends FunSuite {

  import ModelBase._

  test("semigroup combine") {
    val result = m1 |+| m2
    assert(result.size == m1.size + m2.size)
  }

  test("show pretty prints the statements") {
    val expected1 = """<http://example.org/subject> <http://example.org/predicate> "3"^^<http://www.w3.org/2001/XMLSchema#integer> ."""
    val expected2 = """<http://example.org/subject> <http://example.org/predicate> "object1" ."""
    val expected3 = """<http://example.org/subject> <http://example.org/predicate> "object2""""

    assert((m1 |+| m2 |+| m3).show contains expected1)
    assert((m1 |+| m2 |+| m3).show contains expected2)
    assert((m1 |+| m2 |+| m3).show contains expected3)
  }
}
