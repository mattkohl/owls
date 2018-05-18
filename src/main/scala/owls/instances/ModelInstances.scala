package owls.instances

import cats.{Monoid, Show}
import cats.syntax.show._
import owls.instances.statement._

import org.apache.jena.rdf.model.{Model, ModelFactory, Statement}

import scala.collection.JavaConverters._

trait ModelInstances {
  implicit val modelMonoid: Monoid[Model] = new ModelMonoid
  implicit val modelShow: Show[Model] = Show.show[Model]{model =>
    model.listStatements.asScala.toList map {statement: Statement => statement.show} mkString " .\n"
  }
}

class ModelMonoid extends Monoid[Model] {
  def combine(m1: Model, m2: Model): Model = ModelFactory.createDefaultModel.add(m1).add(m2)
  def empty: Model = ModelFactory.createDefaultModel
}