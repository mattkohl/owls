package owls.instances

import cats.Show

import owls._
import org.apache.jena.datatypes.xsd.XSDDatatype

trait LiteralInstances {
  implicit val literalShow: Show[Literal] = Show.show[Literal] {
    case literal if literal.getDatatype == XSDDatatype.XSDstring => s""""${literal.getLexicalForm}""""
    case literal => s""""${literal.getLexicalForm}"^^<${literal.getDatatypeURI}>"""
  }
}
