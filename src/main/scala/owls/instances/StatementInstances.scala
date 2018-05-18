package owls.instances

import cats.Show
import cats.syntax.show._
import owls.instances.resource._
import owls.instances.property._
import owls.instances.rdfNode._
import org.apache.jena.rdf.model.{Property, RDFNode, Resource, Statement}

trait StatementInstances {
  implicit val statementShow: Show[Statement] = Show.show[Statement]{statement =>
    val s: Resource = statement.getSubject
    val p: Property = statement.getPredicate
    val o: RDFNode = statement.getObject
    s"${s.show} ${p.show} ${o.show}"
  }
}
