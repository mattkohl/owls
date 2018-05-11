package org.mattkohl.owls.syntax

import org.mattkohl.owls.syntax.model._
import org.junit.runner.RunWith
import org.mattkohl.owls.ModelBase
import org.scalatest.junit.JUnitRunner
import scala.collection.JavaConverters._

@RunWith(classOf[JUnitRunner])
class ModelSuite extends ModelBase {

  test ("triples extension method") {
    val result = m1.triples
    assert(result == Set((s, p, o1)))
  }

  test ("triples extension method again") {
    val result = m1.triples union m2.triples
    assert(result == Set((s, p, o1), (s, p, o2)))
  }

  test ("query extension method") {
    val sparql = "SELECT * { ?s ?p ?o }"
    val result = m1 query sparql
    assert(result.nonEmpty)
    assert(result.head.varNames.asScala.toSet == Set("s", "p", "o"))
  }

}
