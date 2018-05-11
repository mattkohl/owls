package org.mattkohl.owls.instances

import cats.syntax.semigroup._
import org.apache.jena.query.DatasetFactory
import org.apache.jena.rdf.model.{ModelFactory, Property, Resource, ResourceFactory => RF}
import org.junit.runner.RunWith
import org.mattkohl.owls.instances.dataset._
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DatasetSuite extends FunSuite {

  val s: Resource = RF.createResource("http://example.org/subject")
  val p: Property = RF.createProperty("http://example.org/predicate")

  test("semigroup combine") {

    val m1 = ModelFactory.createDefaultModel().add(s, p, "object1")
    val m2 = ModelFactory.createDefaultModel().add(s, p, "object2")
    val d1 = DatasetFactory.create()
    val d2 = DatasetFactory.create()
    d1.addNamedModel("foo", m1)
    d2.addNamedModel("bar", m2)
    val result = d1 |+| d2
    println(result.asDatasetGraph())

  }
}
