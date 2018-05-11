package org.mattkohl.owls.instances

import cats.syntax.semigroup._
import org.apache.jena.query.{Dataset, DatasetFactory}
import org.apache.jena.rdf.model.{Model, ModelFactory, Property, Resource, ResourceFactory => RF}
import org.junit.runner.RunWith
import org.mattkohl.owls.instances.dataset._
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DatasetSuite extends FunSuite {

  val s: Resource = RF createResource "http://example.org/subject"
  val p: Property = RF createProperty "http://example.org/predicate"
  val m1: Model = ModelFactory.createDefaultModel add (s, p, "object1")
  val m2: Model = ModelFactory.createDefaultModel add (s, p, "object2")
  val d1: Dataset = DatasetFactory.create
  val d2: Dataset = DatasetFactory.create
  d1 addNamedModel ("foo", m1)
  d2 addNamedModel ("bar", m2)

  test("semigroup combine") {
    val result = d1 |+| d2
    assert(result containsNamedModel "foo")
    assert(result containsNamedModel "bar")
  }
}
