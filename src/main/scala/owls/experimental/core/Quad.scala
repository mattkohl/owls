package owls.experimental.core

case class Quad(graph: Resource, subject: Resource, predicate: Property, `object`: RDFNode)

object Quad {
  def apply(graph: Resource, statement: Statement): Quad = new Quad(graph, statement.subject, statement.predicate, statement.`object`)
}
