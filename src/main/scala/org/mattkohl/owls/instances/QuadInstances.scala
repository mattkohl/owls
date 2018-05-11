package org.mattkohl.owls.instances

import cats.Show
import cats.syntax.show._
import org.apache.jena.rdf.model.{Property, RDFNode, Resource}
import org.apache.jena.sparql.core.Quad
import org.mattkohl.owls.instances.property._
import org.mattkohl.owls.instances.rdfNode._
import org.mattkohl.owls.instances.resource._
import org.mattkohl.owls.syntax.node._

trait QuadInstances {
  implicit val quadShow: Show[Quad] = Show.show[Quad]{quad =>
    val g: Resource = quad.getGraph.asResource
    val s: Resource = quad.getSubject.asResource
    val p: Property = quad.getPredicate.asProperty
    val o: RDFNode = quad.getObject.asRDFNode
    s"${g.show} ${s.show} ${p.show} ${o.show}"
  }
}
