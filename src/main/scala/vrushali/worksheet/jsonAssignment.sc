
import play.api.libs.json._

object :: {
  def unapply(arg: String): Option[(String, String)] = arg.split(":") match {
    case Array(pre, post) => Some(pre, post)
    case _ => None
  }
}

def transform(json: JsValue): JsValue = json match {
  case JsNull => JsNull
  case value: JsBoolean => JsBoolean(value.value) // type check in case statement
  case JsNumber(value) => JsNumber(value * value)
  //  case JsString(value) => value.split(":") match {
  //    case Array(pre, post) => JsString(s"Hello $pre to $post")
  //    case value => JsString(value(0))
  //  }
  //
  //  case JsString(value) => value match {
  //    case pre :: post => JsString(s"Hello $pre from $post")
  //    case _ => JsString(value)
  //  }

  case JsString("urn" :: rest) => JsString(s"Hello $rest")
  case JsString(value) => json
  case JsArray(values) => JsArray(values.map(transform))
  case JsObject(underlying) => JsObject(
    underlying.map { t =>
      t match {
        case ("m" | "n", v) => t
        case (k, v) => (k, transform(v))
      }
    }
  )
}

val json: JsValue = Json.obj(
  "a" -> 10,
  "b" -> true,
  "d" -> "urn:world",
  "d1" -> "world",
  "c" -> JsNull,
  "e" -> Json.obj(
    "f" -> 20,
    "g" -> false,
    "h" -> "hello",
    "i" -> List("urn:pune", "this", "is", ""),
    "i2" -> List(9, 7)
  ),
  "j" -> List(
    Json.obj("k" -> "urn:tw", "l" -> "munich"),
    Json.obj("k" -> "autoscout", "l" -> "urn:germany")
  ),
  "m" -> 90,
  "n" -> "urn:ignore"
)

// urn:blah => hello blah

val result11111 = transform(json)
println("--REsult---")
Json.prettyPrint(result11111)

val s: String = "rr:rr";
val arr = s.split("@")
arr.apply(0)