package org.mattkohl.owls.model

import ModelImplicits._
import cats.syntax.semigroup._
import org.apache.jena.rdf.model.{ModelFactory, Resource, ResourceFactory => RF, Property}
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ModelSuite extends FunSuite {

  val s: Resource = RF.createResource("http://example.org/subject")
  val p: Property = RF.createProperty("http://example.org/predicate")

  test("semigroup combine") {

    val m1 = ModelFactory.createDefaultModel().add(s, p, "object1")
    val m2 = ModelFactory.createDefaultModel().add(s, p, "object2")
    val result = m1 |+| m2
    assert(result.size == m1.size + m2.size)

  }
}
