package owls.instances

import cats.Show
import org.apache.jena.rdf.model.Resource

trait ResourceInstances {
  implicit val resourceShow: Show[Resource] = Show.show[Resource]{
    case resource if resource.isAnon => s"_:$resource"
    case resource => s"<$resource>"
  }
}
