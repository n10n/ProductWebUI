package livelygig.client.Handlers

import diode.{ActionHandler, ModelRW}
import livelygig.client.RootModels.UserRootModel
import livelygig.client.components.PrologParser
import livelygig.client.models.{Node, UserModel}
import livelygig.client.services.LGCircuit
import org.scalajs.dom.window
import concurrent._
import ExecutionContext.Implicits._
import scala.scalajs.js.JSON

/**
  * Created by shubham.k on 1/25/2016.
  */
case class LoginUser(userModel: UserModel)
case class LogoutUser()

class UserHandler[M](modelRW: ModelRW[M, UserModel]) extends ActionHandler(modelRW) {
  override def handle = {
    case LoginUser(userModel) =>
      val json = Seq[String]( "node(text(\"RocketHub\"), display(color(\"#5C9BCC\"), image(\"\")), progeny(leaf(text(\"Testimonial\"), display(color(\"#CC5C64\"), image(\"\"))), leaf(text(\"Ask\"), display(color(\"#5CCC8C\"), image(\"\"))), leaf(text(\"WhatIsSplicious\"), display(color(\"#5C64CC\"), image(\"\")))))",
        "leaf(text(\"PopularLabels\"), display(color(\"#5C9BCC\"), image(\"\")))",
        "leaf(text(\"Splicious\"), display(color(\"#CC5C64\"), image(\"\")))",
        "leaf(text(\"Synereo\"), display(color(\"#C45CCC\"), image(\"\")))",
        "leaf(text(\"VancouverDecentral\"), display(color(\"#E9CEB9\"), image(\"\")))",
        "leaf(text(\"Crowdsale2Pt0\"), display(color(\"#CC5C64\"), image(\"\")))")
      /*for(test<-json){
        val test2 = PrologParser.StringToLabel(test)
        println(test2)
      }*/
      LGCircuit.dispatch(CreateLabels(json))
      /*val something = json.map(obj => PrologParser.StringToLabel(obj))


      try {
        println(upickle.default.read[Seq[Node]](JSON.stringify(something(0))))
      } catch {
        case e: Exception =>println(e.getStackTrace)
      }
      println(JSON.stringify(something(0)))*/
      var modelFromStore = userModel
      val temp = window.sessionStorage.getItem("userEmail")
      if (temp!=null) {
        modelFromStore = UserModel(email = window.sessionStorage.getItem("userEmail"),
          name = window.sessionStorage.getItem("userName"),
        imgSrc = window.sessionStorage.getItem("userImgSrc"), isLoggedIn = true)
      }
      updated(modelFromStore)
    case LogoutUser() =>
      window.sessionStorage.clear()
      updated(UserModel(email = "", name = "",imgSrc = "", isLoggedIn = false))
  }
}
