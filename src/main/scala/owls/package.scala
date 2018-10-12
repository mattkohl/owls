import org.apache.jena.query
import org.apache.jena.rdf.model
import org.apache.jena.graph
import org.apache.jena.sparql.core

package object owls {

  type Node = graph.Node

  type Quad = core.Quad

  type Literal = model.Literal
  type Model = model.Model
  type Property = model.Property
  type RDFNode = model.RDFNode
  type Resource = model.Resource
  type Statement = model.Statement

  type QuerySolution = query.QuerySolution
  type ResultSet = query.ResultSet
  type Dataset = query.Dataset

}
