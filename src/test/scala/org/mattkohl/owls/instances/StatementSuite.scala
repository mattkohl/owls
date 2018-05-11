package org.mattkohl.owls.instances

import cats.syntax.show._
import org.apache.jena.rdf.model.{Literal, Property, Resource, ResourceFactory => RF}
import org.junit.runner.RunWith
import org.mattkohl.owls.instances.statement._
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StatementSuite extends FunSuite {

  val ss = "http://example.org/subject"
  val ps = "http://example.org/predicate"
  val os = "object1"

  val s: Resource = RF.createResource(ss)
  val p: Property = RF.createProperty(ps)
  val o: Literal = RF.createPlainLiteral(os)

  test("statement show") {
    val statement = RF.createStatement(s, p, o)
    assert(statement.show == s"$ss $ps $os")
  }
}
