package owls.instances

import cats.syntax.show._
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.{Literal, Property, Resource, ResourceFactory => RF}
import org.junit.runner.RunWith
import owls.instances.statement._
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StatementSuite extends FunSuite {

  val ss = "http://example.org/subject"
  val ps = "http://example.org/predicate"
  val os = "object1"

  val s: Resource = RF createResource ss
  val p: Property = RF createProperty ps
  val oString: Literal = RF createPlainLiteral os
  val oInt: Literal = RF createTypedLiteral ("1", XSDDatatype.XSDinteger)

  test("statement show with string object") {
    val statement = RF createStatement (s, p, oString)
    assert(statement.show == s"""<$ss> <$ps> "$os"""")
  }

  test("statement show with integer object") {
    val statement = RF createStatement (s, p, oInt)
    val expected = s"""<$ss> <$ps> "1"^^<http://www.w3.org/2001/XMLSchema#integer>"""
    assert(statement.show == expected)
  }

}
