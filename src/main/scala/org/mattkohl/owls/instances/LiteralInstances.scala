package org.mattkohl.owls.instances

import cats.Show
import org.apache.jena.rdf.model.Literal

trait LiteralInstances {
  implicit val literalShow: Show[Literal] = Show.show[Literal]{literal => s"\"$literal\"^^<${literal.getDatatypeURI}>"}
}
