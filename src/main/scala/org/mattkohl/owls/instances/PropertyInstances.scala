package org.mattkohl.owls.instances

import cats.Show
import org.apache.jena.rdf.model.Property

trait PropertyInstances {
  implicit val propertyShow: Show[Property] = Show.show[Property](resource => s"<$resource>")
}
