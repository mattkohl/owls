package owls.syntax

import org.apache.jena.query.{QueryExecutionFactory => QEF, QuerySolution, ResultSetFactory => RSF}
import org.apache.jena.rdf.model._

import scala.collection.JavaConverters._

trait ModelSyntax {

  implicit class ModelOps(model: Model) {
    val triples: Set[(Resource, Property, RDFNode)] =
      model.listStatements.asScala.toSet map { statement: Statement =>
        (statement.getSubject, statement.getPredicate, statement.getObject)
      }

    def query(sparql: String): List[QuerySolution] =
      RSF.copyResults(QEF.create(sparql, model).execSelect).asScala.toList
  }

}