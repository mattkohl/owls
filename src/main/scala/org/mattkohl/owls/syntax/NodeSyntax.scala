package org.mattkohl.owls.syntax

import org.apache.jena.graph.Node
import org.apache.jena.rdf.model.{Literal, Property, RDFNode, Resource, ResourceFactory => RF}

trait NodeSyntax {

  implicit class NodeOps(node: Node) {
    def asResource: Resource = RF.createResource(node.getURI)
    def asProperty: Property = RF.createProperty(node.getURI)
    def asLiteral: Literal = RF.createTypedLiteral(node.getLiteralLexicalForm, node.getLiteralDatatype)
    def asRDFNode: RDFNode = node match {
      case n if n.isLiteral => asLiteral
      case _ => asResource
    }
  }

}
