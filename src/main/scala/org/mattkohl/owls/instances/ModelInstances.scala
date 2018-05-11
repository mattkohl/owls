package org.mattkohl.owls.instances

import cats.Monoid
import org.apache.jena.rdf.model.{Model, ModelFactory}

trait ModelInstances {
  implicit val monoid: Monoid[Model] = new ModelMonoid
}

class ModelMonoid extends Monoid[Model] {
  def combine(m1: Model, m2: Model): Model = ModelFactory.createDefaultModel().add(m1).add(m2)
  def empty: Model = ModelFactory.createDefaultModel
}