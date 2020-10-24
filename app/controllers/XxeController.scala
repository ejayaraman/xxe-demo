package controllers

import javax.inject._
import javax.xml.parsers.SAXParserFactory
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class XxeController @Inject()(cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc) {

  def ok: Action[String] = Action.async(parse.tolerantText) { request =>
    Future(Ok)
  }


  def post(id: String): Action[String] = Action.async(parse.tolerantText) { request =>
    val factory = SAXParserFactory.newInstance()
//        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)

    val saxParser = factory.newSAXParser()

    val xml = scala.xml.XML.withSAXParser(saxParser).loadString(request.body)
    Future(Ok(xml))
  }

  def put(id: String): Action[String] = Action.async(parse.tolerantText) { request =>

    val factory = SAXParserFactory.newInstance()
      //  factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)

    val saxParser = factory.newSAXParser()

    val xml = scala.xml.XML.withSAXParser(saxParser).loadString(request.body)
    Future(BadRequest(xml))
  }
}
