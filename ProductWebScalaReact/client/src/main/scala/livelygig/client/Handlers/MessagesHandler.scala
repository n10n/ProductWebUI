package livelygig.client.handlers

import diode.data.PotState.PotPending
import diode.{Effect, ActionHandler, ModelRW}
import diode.data.{Empty, PotAction, Ready, Pot}
import livelygig.client.models.MessagesModel
import livelygig.client.rootmodels.{MessagesRootModel}
import livelygig.client.services.CoreApi
import livelygig.client.dtos.{EvalSubscribeResponseContent, ConnectionProfileResponse, ApiResponse}
//import rx.ops.Timer
import scala.concurrent.ExecutionContext.Implicits.global

import scala.scalajs.js.JSON

/**
  * Created by shubham.k on 1/25/2016.
  */
// Actions
case class RefreshMessages(value: Pot[MessagesRootModel] = Empty) extends PotAction[MessagesRootModel, RefreshMessages]{
  override def next(value: Pot[MessagesRootModel]) = RefreshMessages(value)
}

object MessagesModelHandler{
  def GetMessagesModel(response: String): MessagesRootModel = {
    /*try {
      upickle.default.read[Seq[ApiResponse[EvalSubscribeResponseContent]]](response)
    } catch {
      case e: Exception =>
        println(e)
    }*/
    val messagesFromBackend = upickle.default.read[Seq[ApiResponse[EvalSubscribeResponseContent]]](response)
    //      println(model(0).content.pageOfPosts(0))
    //      println(upickle.default.read[PageOfPosts](model(0).content.pageOfPosts(0)))
    var model = Seq[MessagesModel]()
    for(projectFromBackend <- messagesFromBackend){
      //      println(upickle.default.read[PageOfPosts](projectFromBackend.content.pageOfPosts(0)))
      try {
        if (!projectFromBackend.content.pageOfPosts.isEmpty)
          upickle.default.read[MessagesModel](projectFromBackend.content.pageOfPosts(0))
      } catch {
        case e: Exception =>
          println(e)
      }
      if (!projectFromBackend.content.pageOfPosts.isEmpty)
        model:+= upickle.default.read[MessagesModel](projectFromBackend.content.pageOfPosts(0))
    }
    //    println(model)
    MessagesRootModel(model)
  }

}

class MessagesHandler[M](modelRW: ModelRW[M, Pot[MessagesRootModel]]) extends ActionHandler(modelRW) {
  override def handle = {
    case action : RefreshMessages =>
      val updateF = action.effect(CoreApi.getMessages())(messages=>MessagesModelHandler.GetMessagesModel(messages))
      action.handleWith(this, updateF)(PotAction.handler())
  }
}