package owls.instances


import cats.Show
import cats.syntax.show._
import owls.instances.resource._
import owls.instances.property._
import owls.instances.rdfNode._
import owls._
import owls.syntax.node._
import org.apache.jena.sparql.core.Quad

trait QuadInstances {
  implicit val quadShow: Show[Quad] = Show.show[Quad]{quad =>
    val g: Resource = quad.getGraph.asResource
    val s: Resource = quad.getSubject.asResource
    val p: Property = quad.getPredicate.asProperty
    val o: RDFNode = quad.getObject.asRDFNode
    s"${g.show} ${s.show} ${p.show} ${o.show}"
  }
}
