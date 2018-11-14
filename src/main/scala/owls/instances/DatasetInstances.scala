package owls.instances

import owls._
import cats.{Monoid, Show}
import cats.syntax.show._
import owls.instances.quad._
import org.apache.jena.query.{DatasetFactory => DF}
import org.apache.jena.sparql.util.compose.DatasetLib.union

import scala.collection.JavaConverters._

trait DatasetInstances {
  implicit val datasetMonoid: Monoid[Dataset] = new DatasetMonoid
  implicit val datasetShow: Show[Dataset] = Show.show[Dataset]{ dataset =>
    dataset.asDatasetGraph().find().asScala.toList map (_.show) mkString " .\n"
  }
}

class DatasetMonoid extends Monoid[Dataset] {
  def combine(d1: Dataset, d2: Dataset): Dataset = union(d1, d2)
  def empty: Dataset = DF.create
}