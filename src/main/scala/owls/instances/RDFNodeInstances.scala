package owls.instances

import cats.Show
import cats.syntax.show._
import owls.instances.resource._
import owls.instances.literal._

import org.apache.jena.rdf.model.RDFNode

trait RDFNodeInstances {
  implicit val rdfNodeShow: Show[RDFNode] = Show.show[RDFNode]{
    case node if node.isLiteral => node.asLiteral.show
    case node if node.isResource => node.asResource.show
  }
}
