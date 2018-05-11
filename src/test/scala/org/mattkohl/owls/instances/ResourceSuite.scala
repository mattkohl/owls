package org.mattkohl.owls.instances

import cats.syntax.show._
import org.apache.jena.rdf.model.{Resource, ResourceFactory => RF}
import org.junit.runner.RunWith
import org.mattkohl.owls.instances.resource._
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ResourceSuite extends FunSuite {

  val uri = "http://example.org/subject"
  val s: Resource = RF createResource uri
  val as: Resource = RF createResource None.orNull

  test("resource show")(assert(s.show == s"<$uri>"))
  test("anon resource show")(assert(as.show == s"_:$as"))

}
