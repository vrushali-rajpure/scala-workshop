
sealed trait Json
case class JsString(string: String) extends Json
case class JsNumber(value: Double) extends Json

sealed abstract class JsBoolean(val value: Boolean) extends Json
case object JsTrue extends JsBoolean(true)
case object JsFalse extends JsBoolean(false)

case class JsArray(values: List[Json]) extends Json
case class JsObject(values: Map[String, Json]) extends Json

case object JsNull extends Json

