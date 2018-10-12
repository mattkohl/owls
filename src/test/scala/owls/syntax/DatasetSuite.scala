package owls.syntax

import owls.syntax.dataset._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import owls.{DatasetBase, ModelBase}
import scala.collection.JavaConverters._

@RunWith(classOf[JUnitRunner])
class DatasetSuite extends FunSuite {

  import DatasetBase._
  import ModelBase._

  test ("quads extension method") {
    val result = d1.quads
    assert(result == Set((g1, s, p, o1)))
  }

  test ("quads extension method again") {
    val result = d1.quads union d2.quads
    assert(result == Set((g1, s, p, o1), (g2, s, p, o2)))
  }

  test ("query extension method") {
    val sparql = "SELECT * { GRAPH ?g { ?s ?p ?o } }"
    val result = d1 query sparql
    assert(result.nonEmpty)
    assert(result.head.varNames.asScala.toSet == Set("g", "s", "p", "o"))
  }


}
