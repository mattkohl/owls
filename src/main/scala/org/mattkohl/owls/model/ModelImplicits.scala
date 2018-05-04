package org.mattkohl.owls.model

import cats.Monoid
import org.apache.jena.rdf.model.{Model, ModelFactory}


object ModelImplicits {

  implicit val monoid: Monoid[Model] = new Monoid[Model] {
    def combine(m1: Model, m2: Model): Model = ModelFactory.createDefaultModel().add(m1).add(m2)
    def empty: Model = ModelFactory.createDefaultModel
  }

}
