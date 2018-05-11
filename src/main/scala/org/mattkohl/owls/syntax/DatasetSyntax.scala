package org.mattkohl.owls.syntax

import org.apache.jena.query.{QueryExecutionFactory => QEF, Dataset, QuerySolution, ResultSetFactory => RSF}
import org.apache.jena.rdf.model._
import org.apache.jena.sparql.core.Quad
import org.mattkohl.owls.syntax.node._

import scala.collection.JavaConverters._

trait DatasetSyntax {

  implicit class DatasetOps(dataset: Dataset) {
    val quads: Set[(Resource, Resource, Property, RDFNode)] =
      dataset.asDatasetGraph.find.asScala.toSet map { quad: Quad =>
        (quad.getGraph.asResource, quad.getSubject.asResource, quad.getPredicate.asProperty, quad.getObject.asRDFNode)
      }

    def query(sparql: String): List[QuerySolution] =
      RSF.copyResults(QEF.create(sparql, dataset).execSelect).asScala.toList
  }

}
