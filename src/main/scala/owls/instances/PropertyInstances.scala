package owls.instances

import cats.Show
import owls._

trait PropertyInstances {
  implicit val propertyShow: Show[Property] = Show.show[Property](resource => s"<$resource>")
}
