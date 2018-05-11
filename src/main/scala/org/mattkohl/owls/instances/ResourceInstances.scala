package org.mattkohl.owls.instances

import cats.Show
import org.apache.jena.rdf.model.Resource

trait ResourceInstances {
  implicit val resourceShow: Show[Resource] = Show.show[Resource](resource => s"<$resource>")
}
