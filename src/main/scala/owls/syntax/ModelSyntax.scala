package owls.syntax

import org.apache.jena.query.{QueryExecutionFactory => QEF, QuerySolution, ResultSetFactory => RSF}
import org.apache.jena.rdf.model.{Model, Statement, Resource, Property, RDFNode, ModelFactory => MF}

import scala.collection.JavaConverters._

trait ModelSyntax {

  implicit class ModelOps(model: Model) {
    val statements: Set[Statement] = model.listStatements.asScala.toSet

    val triples: Set[(Resource, Property, RDFNode)] =
      statements map { statement: Statement =>
        (statement.getSubject, statement.getPredicate, statement.getObject)
      }

    def query(sparql: String): List[QuerySolution] =
      RSF.copyResults(QEF.create(sparql, model).execSelect).asScala.toList

    def map(func: Statement => Statement): Model =
      statements.foldLeft(MF.createDefaultModel){ (result, statement) =>
        result.add(func(statement))
      }

  }

}
