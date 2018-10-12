package owls

import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.{ModelFactory => MF, ResourceFactory => RF}


object ModelBase {

  val s: Resource = RF createResource "http://example.org/subject"
  val p: Property = RF createProperty "http://example.org/predicate"
  val o1: Literal = RF createPlainLiteral "object1"
  val o2: Literal = RF createPlainLiteral "object2"
  val three: Literal = RF createTypedLiteral ("3", XSDDatatype.XSDinteger)
  val m1: Model = MF.createDefaultModel add (s, p, o1)
  val m2: Model = MF.createDefaultModel add (s, p, o2)
  val m3: Model = MF.createDefaultModel add (s, p, three)

}
