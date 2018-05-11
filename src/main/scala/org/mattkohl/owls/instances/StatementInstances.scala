package org.mattkohl.owls.instances

import cats.Show
import cats.syntax.show._
import org.mattkohl.owls.instances.resource._
import org.mattkohl.owls.instances.property._
import org.mattkohl.owls.instances.rdfNode._
import org.apache.jena.rdf.model.{Resource, Property, RDFNode, Statement}

trait StatementInstances {
  implicit val statementShow: Show[Statement] = Show.show[Statement]{statement =>
    val s: Resource = statement.getSubject
    val p: Property = statement.getPredicate
    val o: RDFNode = statement.getObject
    s"${s.show} ${p.show} ${o.show}"
  }
}
