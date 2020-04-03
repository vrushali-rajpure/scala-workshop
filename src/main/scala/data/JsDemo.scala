package data

import play.api.libs.json._

object JsDemo {
  def transform(json: JsValue): JsValue = json match {
    case JsNull           => JsString("I am null")
    case JsBoolean(value) => JsBoolean(!value)
    case JsNumber(value)  => JsNumber(value * value)
    case JsString(value)  => json
    case JsArray(values)  => JsArray(values.map(transform))
    case JsObject(values) => JsObject(
      values.map {
        case t@("m" | "n", v) => t
        case (k, v)           => (k, transform(v))
      }
    )
  }
}
