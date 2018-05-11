package org.mattkohl.owls.instances

import cats.{Monoid, Show}
import cats.syntax.show._
import org.mattkohl.owls.instances.quad._
import org.apache.jena.query.{Dataset, DatasetFactory}
import org.apache.jena.sparql.util.compose.DatasetLib.union
import scala.collection.JavaConverters._

trait DatasetInstances {
  implicit val datasetMonoid: Monoid[Dataset] = new DatasetMonoid
  implicit val datasetShow: Show[Dataset] = Show.show[Dataset]{dataset =>
    dataset.asDatasetGraph().find().asScala.toList map {quad => quad.show} mkString " .\n"
  }
}

class DatasetMonoid extends Monoid[Dataset] {
  def combine(d1: Dataset, d2: Dataset): Dataset = union(d1, d2)
  def empty: Dataset = DatasetFactory.create
}