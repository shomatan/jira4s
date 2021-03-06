package tech.ignission.jira4s.v3.formatters

import spray.json._
import tech.ignission.jira4s.v3.ApiErrors
import tech.ignission.jira4s.v3.datas._

object SprayJsonFormats extends DefaultJsonProtocol {

  // Foundation types
  // class IdFormat[A]() extends RootJsonFormat[Id[A]] {
  //   override def read(json: JsValue): Id[A] =
  //     json match {
  //       case JsNumber(idVal) => Id(idVal.toDouble)
  //       case JsString(idVal) => Id(idVal.toDouble)
  //       case _ =>
  //         throw DeserializationException(s"Expected a js number got ${json.prettyPrint}")
  //     }

  //   override def write(obj: Id[A]): JsValue = JsNumber(obj.value)
  // }

  // class KeyFormat[A]() extends RootJsonFormat[Key[A]] {
  //   override def read(json: JsValue): Key[A] =
  //     json match {
  //       case JsString(keyVal) => Key(keyVal)
  //       case _ =>
  //         throw DeserializationException(s"Expected a js string got ${json.prettyPrint}")
  //     }

  //   override def write(obj: Key[A]): JsValue = JsString(obj.value)
  // }

  // class IdOrKeyFormat[A]() extends RootJsonFormat[IdOrKeyParam[A]] {
  //   override def read(json: JsValue): IdOrKeyParam[A] =
  //     json match {
  //       case JsNumber(idVal) => IdParam[A](Id[A](idVal.toInt))
  //       case JsString(keyVal) => KeyParam[A](Key[A](keyVal))
  //       case _ =>
  //         deserializationError(s"Expected a string or a number for IdOrKeyParam got ${json.prettyPrint}")
  //     }

  //   override def write(idOrKey: IdOrKeyParam[A]): JsValue = JsString(idOrKey.toString)
  // }

  implicit object CalendarDateFormat extends RootJsonFormat[CalendarDate] {
    def write(c: CalendarDate) =
      JsString("")

    def read(value: JsValue) =
      value match {
        case JsString(_) => CalendarDate()
        case _ => deserializationError("String expected")
      }
  }

  // implicit val projectIdFormat = new IdFormat[Project]
  // implicit val projectKeyFormat = new KeyFormat[Project]

  // Component
  implicit object ComponentIdFormat extends RootJsonFormat[Id[Component]] {
    override def read(json: JsValue): Id[Component] =
      json match {
        case JsString(value) =>
          Id[Component](value.toDouble)
        case input =>
          deserializationError(s"Expected a number of string component id. Input: $input")
      }
    override def write(obj: Id[Component]): JsValue =
      JsString(obj.value.toString)
  }
  implicit val componentFormat: JsonFormat[Component] = jsonFormat2(Component)

  // Version
  implicit object VersionIdFormat extends RootJsonFormat[Id[Version]] {
    override def read(json: JsValue): Id[Version] =
      json match {
        case JsString(value) =>
          Id[Version](value.toDouble)
        case input =>
          deserializationError(s"Expected a number of string version id. Input: $input")
      }
    override def write(obj: Id[Version]): JsValue =
      JsString(obj.value.toString)
  }
  implicit val versionFormat: JsonFormat[Version] = jsonFormat6(Version)

  // User
  implicit val userFormat: JsonFormat[User] = jsonFormat4(User)

  // Errors
  implicit val apiErrorsFormat: JsonFormat[ApiErrors] = jsonFormat2(ApiErrors)

}
