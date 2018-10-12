package owls.syntax

import org.apache.jena.datatypes.xsd.XSDDatatype
import owls._
import owls.syntax.model._
import owls.ModelBase
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.apache.jena.rdf.model.{ResourceFactory => RF}

import scala.collection.JavaConverters._
import scala.util.{Failure, Success, Try}

@RunWith(classOf[JUnitRunner])
class ModelSuite extends FunSuite {

  import ModelBase._

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

  test("map extension method") {
    def addOne(s1: Statement): Statement = {
      val obj: RDFNode = s1.getObject
      Try(obj.asLiteral.getInt) match {
        case Success(i) => s1.changeLiteralObject(i+1)
        case Failure(_) => s1
      }
    }

    val result = m3.map(addOne)
    assert(result.triples.head._3.asLiteral() == RF.createTypedLiteral("4", XSDDatatype.XSDint))

  }

}
