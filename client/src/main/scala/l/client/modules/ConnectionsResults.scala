package l.client.modules

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{BackendScope, Callback, ReactComponentB}
import l.client.handlers.RefreshConnections
import l.client.rootmodels.ConnectionsRootModel
import diode.react.ReactPot._
import diode.react._
import diode.data.Pot
import l.client.components.Icon
import l.client.css.{HeaderCSS, DashBoardCSS}
import l.client.modals.{NewMessage, NewRecommendation}
import l.client.models.ConnectionsModel
import scalacss.ScalaCssReact._

object ConnectionsResults {

  case class Props(proxy: ModelProxy[Pot[ConnectionsRootModel]])

  case class State(selectedItem: Option[ConnectionsModel] = None)

  class Backend($: BackendScope[Props, State]) {
    def mounted(props: Props) =
      Callback.ifTrue(props.proxy().isEmpty, props.proxy.dispatch(RefreshConnections()))
  }

  // create the React component for Dashboard
  val component = ReactComponentB[Props]("Connection")
    .initialState(State())
    .backend(new Backend(_))
    .renderPS(($, P, S) => {
      <.div(^.id := "rsltScrollContainer", DashBoardCSS.Style.rsltContainer, DashBoardCSS.Style.verticalImg)(
        <.div(DashBoardCSS.Style.gigActionsContainer, ^.className := "row")(
          <.div(^.className := "col-md-6 col-sm-6 col-xs-12")(
            <.input(^.`type` := "checkbox", DashBoardCSS.Style.rsltCheckboxStyle, DashBoardCSS.Style.verticalAlignMiddle),
            <.div(DashBoardCSS.Style.rsltGigActionsDropdown, ^.className := "dropdown", DashBoardCSS.Style.verticalAlignMiddle)(
              <.button(DashBoardCSS.Style.gigMatchButton, ^.className := "btn dropdown-toggle", "data-toggle".reactAttr := "dropdown")("Select Bulk Action ")(
                <.span(^.className := "caret", DashBoardCSS.Style.rsltCaretStyle)
              ),
              <.ul(^.className := "dropdown-menu")(
                <.li()(<.a()("Hide")),
                <.li()(<.a()("Favorite")),
                <.li()(<.a()("Unhide")),
                <.li()(<.a()("Unfavorite"))
              )
            ), //dropdown class
            <.div(DashBoardCSS.Style.rsltCountHolderDiv, DashBoardCSS.Style.marginResults)("2,352 Results")
          ),
          <.div(^.className := "col-md-6 col-sm-6 col-xs-12")(

            <.div(^.display := "inline-block")(
              <.div(DashBoardCSS.Style.rsltGigActionsDropdown, ^.className := "dropdown")(
                <.button(DashBoardCSS.Style.gigMatchButton, ^.className := "btn dropdown-toggle", "data-toggle".reactAttr := "dropdown")("By Date ")(
                  <.span(^.className := "caret", DashBoardCSS.Style.rsltCaretStyle)
                ),
                <.ul(^.className := "dropdown-menu")(
                  <.li()(<.a()("By Date")),
                  <.li()(<.a()("By Experience")),
                  <.li()(<.a()("By Reputation")),
                  <.li()(<.a()("By Rate")),
                  <.li()(<.a()("By Projects Completed"))
                )
              ),
              <.div(DashBoardCSS.Style.rsltGigActionsDropdown, ^.className := "dropdown")(
                <.button(DashBoardCSS.Style.gigMatchButton, DashBoardCSS.Style.padding0px, ^.className := "btn dropdown-toggle", "data-toggle".reactAttr := "dropdown")("Newest ")(
                  <.span(Icon.longArrowDown))
              )
            ),
            <.div(^.className := "pull-right")(
              <.button(DashBoardCSS.Style.btn, "data-toggle".reactAttr := "tooltip", "title".reactAttr := "View Summary")( <.span(^.className:="icon-List1")),
              <.button(DashBoardCSS.Style.btn, "data-toggle".reactAttr := "tooltip", "title".reactAttr := "View Brief")( <.span(^.className:="icon-List2")),
              <.button(DashBoardCSS.Style.btn, "data-toggle".reactAttr := "tooltip", "title".reactAttr := "View Full Posts")( <.span(^.className:="icon-List3"))
            )
          )
        ), //col-12
         <.div(^.className := "container-fluid", ^.id := "resultsConnectionsContainer", DashBoardCSS.Style.verticalImg)(
          P.proxy().render(connectionsRootModel =>
            ConnectionList(connectionsRootModel.connectionsResponse)
          ),
          //                    P.proxy().renderPending(_ > 5, _ => "Loading..."),
          P.proxy().renderFailed(ex => <.div(<.span(Icon.warning), " Error loading")),
          if (P.proxy().isEmpty) {
            if (!P.proxy().isFailed) {
              <.div("Loading")
              <.img(^.src := "./assets/images/processing.gif")
            } else {
              <.div()
            }
          } else {
            <.div(/*"data loaded"*/)
          }
        )


      ) //mainContainer
    })
    .componentDidMount(scope => scope.backend.mounted(scope.props))
    .build

  /** Returns a function compatible with router location system while using our own props */
  def apply(proxy: ModelProxy[Pot[ConnectionsRootModel]]) = component(Props(proxy))
}

object ConnectionList {

  case class ConnectionListProps(connections: Seq[ConnectionsModel])

  val ConnectionList = ReactComponentB[ConnectionListProps]("ConnectionList")
    .render_P(p => {
      def renderConnections(connection: ConnectionsModel) = {
        <.li(^.className := "media  profile-description", DashBoardCSS.Style.rsltpaddingTop10p)(
          <.input(^.`type` := "checkbox", DashBoardCSS.Style.rsltCheckboxStyle),
          <.span(^.className := "checkbox-lbl"),
          if (!connection.name.isEmpty) {
            <.div(DashBoardCSS.Style.profileNameHolder)(connection.name)
          } else {
            <.span()
          },
          <.div(^.marginLeft := "30px")(
            <.div(^.className := "media-left", ^.float.left)(
              if (connection.imgSrc.isEmpty) {
                <.img(DashBoardCSS.Style.profileImg, ^.src := "./assets/images/default_avatar.jpg", ^.borderRadius := "25px", ^.title := "Connection Source: " + connection.connection.source + " Target: " + connection.connection.target + " Label: " + connection.connection.label)
              } else {
                <.img(DashBoardCSS.Style.profileImg, ^.src := connection.imgSrc, ^.borderRadius := "25px", ^.title := "Connection Source: " + connection.connection.source + " Target: " + connection.connection.target + " Label: " + connection.connection.label)
              }
            ),
            <.div()(
              <.div(DashBoardCSS.Style.rsltProfileDetailsHolder)("Software Developer"),
              <.div(DashBoardCSS.Style.rsltProfileDetailsHolder)("Pune, India"),
              <.div(DashBoardCSS.Style.rsltProfileDetailsHolder)("Connected since 2014-01-02"),
              <.div(DashBoardCSS.Style.rsltProfileDetailsHolder)("Profiles: ",
                <.a()("title".reactAttr := "Videographer")("Videographer"),
                " | ",
                <.a()("title".reactAttr := "Web Developer")("Web Developer"),
                " | ",
                <.a()("title".reactAttr := "Janal, LLC")("Janal, LLC")
              ),
              <.div(DashBoardCSS.Style.rsltProfileDetailsHolder)("In My Groups: ",
                <.a()("title".reactAttr := "Film Industry")("Film Industry"),
                ", ",
                <.a()("title".reactAttr := "Full Stack Developers")("Full Stack Developers")
              )
            )
          ),
          <.br(),
          <.div(^.className := "media-body")(
            <.div(^.className := "col-md-12 col-sm-12 ")(
              <.button(^.tpe := "button", ^.className := "btn profile-action-buttons pull-right", HeaderCSS.Style.rsltContainerIconBtn,  ^.title := "Hide", Icon.remove),
              <.button(^.tpe := "button", ^.className := "btn profile-action-buttons pull-right", HeaderCSS.Style.rsltContainerIconBtn,  ^.title := "Favorite", Icon.star),
              <.button(^.tpe := "button", ^.className := "btn profile-action-buttons pull-right", HeaderCSS.Style.rsltContainerIconBtn,  ^.title := "Introduce", Icon.userTimes),
              NewRecommendation(NewRecommendation.Props("", Seq(HeaderCSS.Style.rsltContainerIconBtn), Icon.thumbsOUp, "Recommend")),
              NewMessage(NewMessage.Props("", Seq(HeaderCSS.Style.rsltContainerIconBtn), Icon.envelope, "Message"))
            )
          )
        )
      }
      <.div(^.className := "rsltSectionContainer", ^.className := "col-md-12 col-sm-12 col-xs-12", ^.paddingLeft := "0px", ^.paddingRight := "0px")(
        <.ul(^.className := "media-list")(p.connections map renderConnections)
      )
    })
    .build

  def apply(connections: Seq[ConnectionsModel]) =
    ConnectionList(ConnectionListProps(connections))
}