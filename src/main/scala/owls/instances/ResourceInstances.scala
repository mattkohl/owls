package owls.instances

import cats.Show
import owls._

trait ResourceInstances {
  implicit val resourceShow: Show[Resource] = Show.show[Resource]{
    case resource if resource.isAnon => s"_:$resource"
    case resource => s"<$resource>"
  }
}
