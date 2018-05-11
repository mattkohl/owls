package org.mattkohl.owls.instances

import model._
import cats.syntax.semigroup._
import cats.syntax.show._
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.{Literal, Model, ModelFactory, Property, Resource, ResourceFactory => RF}
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ModelSuite extends FunSuite {

  val s: Resource = RF createResource "http://example.org/subject"
  val p: Property = RF createProperty "http://example.org/predicate"
  val three: Literal = RF createTypedLiteral ("3", XSDDatatype.XSDinteger)
  val m1: Model = ModelFactory.createDefaultModel add (s, p, "object1")
  val m2: Model = ModelFactory.createDefaultModel add (s, p, "object2")
  val m3: Model = ModelFactory.createDefaultModel add (s, p, three)

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
