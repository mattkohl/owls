package org.mattkohl.owls

import org.apache.jena.query.{Dataset, DatasetFactory}

class DatasetBase extends ModelBase {

  val d1: Dataset = DatasetFactory.create
  val d2: Dataset = DatasetFactory.create
  d1 addNamedModel ("foo", m1)
  d2 addNamedModel ("bar", m2)

}
