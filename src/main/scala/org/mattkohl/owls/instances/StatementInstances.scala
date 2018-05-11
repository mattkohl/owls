package org.mattkohl.owls.instances

import cats.Show
import org.apache.jena.rdf.model.Statement

trait StatementInstances {
  implicit val statementShow: Show[Statement] = Show.show[Statement](s => s"${s.getSubject} ${s.getPredicate} ${s.getObject}")
}
