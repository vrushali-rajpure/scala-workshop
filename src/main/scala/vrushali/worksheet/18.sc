// JSON ADT

sealed trait Json

case class JSString( string : String) extends Json
case class JSNumber( value : Double) extends Json

sealed abstract class JSBoolean(val value : Boolean) extends Json
case object JSTrue extends JSBoolean(true)
case object JSFalse extends JSBoolean(false)

case class JSArray(values : List[Json]) extends Json
case class JSObject(values : Map[String,Json]) extends Json

class JSNull extends Json