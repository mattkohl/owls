package owls.experimental.core

import org.apache.jena.datatypes.xsd.XSDDatatype

trait RDFNode

case class Resource(iri: String) extends RDFNode
case class Property(iri: String) extends RDFNode
case class Literal(value: String, datatype: XSDDatatype)