package owls.instances

import cats.{Monoid, Show}
import cats.syntax.show._

import owls.instances.statement._
import owls._
import org.apache.jena.rdf.model.{ModelFactory => MF}

import scala.collection.JavaConverters._

trait ModelInstances {
  implicit val modelMonoid: Monoid[Model] = new ModelMonoid
  implicit val modelShow: Show[Model] = Show.show[Model]{ model =>
    model.listStatements.asScala.toList map (_.show) mkString " .\n"
  }
}

class ModelMonoid extends Monoid[Model] {
  def combine(m1: Model, m2: Model): Model = MF.createDefaultModel.add(m1).add(m2)
  def empty: Model = MF.createDefaultModel
}