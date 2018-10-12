package owls

import org.apache.jena.query.{DatasetFactory => DF}
import org.apache.jena.rdf.model.{ResourceFactory => RF}

object DatasetBase {

  import ModelBase._

  val d1: Dataset = DF.create
  val d2: Dataset = DF.create
  val g1: Resource = RF.createResource("foo")
  val g2: Resource = RF.createResource("bar")
  d1 addNamedModel (g1.getURI, m1)
  d2 addNamedModel (g2.getURI, m2)

}
