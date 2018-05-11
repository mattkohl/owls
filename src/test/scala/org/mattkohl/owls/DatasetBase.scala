package org.mattkohl.owls

import org.apache.jena.query.{Dataset, DatasetFactory}
import org.apache.jena.rdf.model.{Resource, ResourceFactory => RF}

class DatasetBase extends ModelBase {

  val d1: Dataset = DatasetFactory.create
  val d2: Dataset = DatasetFactory.create
  val g1: Resource = RF.createResource("foo")
  val g2: Resource = RF.createResource("bar")
  d1 addNamedModel (g1.getURI, m1)
  d2 addNamedModel (g2.getURI, m2)

}
