package org.mattkohl.owls.instances

import cats.Monoid
import org.apache.jena.query.{Dataset, DatasetFactory}
import org.apache.jena.sparql.util.compose.DatasetLib.union

trait DatasetInstances {
  implicit val monoid: Monoid[Dataset] = new DatasetMonoid
}

class DatasetMonoid extends Monoid[Dataset] {
  def combine(d1: Dataset, d2: Dataset): Dataset = union(d1, d2)
  def empty: Dataset = DatasetFactory.create()
}