package synereo.client.modules


import japgolly.scalajs.react.extra.router.RouterCtl
import synereo.client.SYNEREOMain
import SYNEREOMain.Loc
import synereo.client.css.{UserTimelineViewCSS}
import org.querki.jquery._
import synereo.client.css.{DashboardCSS, SynereoCommanStylesCSS}
import japgolly.scalajs.react.{Callback, ReactComponentB}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import synereo.client.components.{Icon, MIcon}
import scala.scalajs.js
import scalacss.ScalaCssReact._

/**
  * Created by Mandar on 3/28/2016.
  */
object TimelineView {
  val searchContainer: js.Object = "#searchContainer"

  case class Props()

  case class State()

  class Backend(t: BackendScope[Props, State]) {

    def render(props: Props) = {
      <.div()(
        <.div(^.className := "row")(
          <.div(^.className := "col-md-12")(
            <.div(^.className := "container")(
              <.div(^.className := "row", UserTimelineViewCSS.Style.coverHolderDiv)(
                <.img(^.src := "./assets/synereo-images/cover-background.jpg", UserTimelineViewCSS.Style.coverBackgroundImg),
                <.div(UserTimelineViewCSS.Style.coverDescriptionContainer)(
                  <.div(^.className := "row")(
                    <.div(^.className := "col-md-2 text-center")(
                      <.img(^.src := "./assets/synereo-images/default_avatar.jpg", UserTimelineViewCSS.Style.userAvatar),
                      <.div(^.className := "text-center", UserTimelineViewCSS.Style.userName)("Anderson Hooper")
                    ),
                    <.div(^.className := "col-md-7")(
                      <.h1("Neuroscience Developments", UserTimelineViewCSS.Style.coverTitle),
                      <.h5(UserTimelineViewCSS.Style.userName)(
                        <.span("325followers"),
                        "-",
                        <.span("701posts"),
                        "-",
                        <.span("public")
                      )
                    ),
                    <.div(^.className := "col-md-3 text-center")(
                      <.button(^.className := "btn", UserTimelineViewCSS.Style.followBtn)("FOLLOWING")
                    )
                  )
                )
              ),
              <.div(^.className := "row")(
                <.div(^.className := "col-lg-6 col-md-6 col-sm-12 col-xs-12", SynereoCommanStylesCSS.Style.paddingRightZero)(
                  <.div(^.className := "row", DashboardCSS.Style.userPost)(
                    <.img(^.src := "./assets/synereo-images/default_avatar.jpg", ^.alt := "user avatar", DashboardCSS.Style.userAvatarDashboardForm),
                    <.input(DashboardCSS.Style.UserInput, ^.placeholder := "contribute your thoughts..."),
                    <.span()(Icon.camera)
                  ),
                  <.div(^.className := "row", DashboardCSS.Style.userPost)(
                    <.img(^.src := "./assets/synereo-images/default_avatar.jpg", ^.alt := "user avatar", DashboardCSS.Style.userAvatarDashboardForm),
                    <.div(DashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", DashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(DashboardCSS.Style.postActions)(
                        <.span(Icon.thList),
                        <.span(Icon.adjust),
                        <.span(Icon.anchor),
                        <.span(Icon.apple),
                        <.span(^.className := "pull-right")(
                          <.span(Icon.thList),
                          <.span(Icon.adjust)
                        )

                      )

                    )
                  ),
                  <.div(^.className := "row", DashboardCSS.Style.userPost)(
                    <.img(^.src := "./assets/synereo-images/default_avatar.jpg", ^.alt := "user avatar", DashboardCSS.Style.userAvatarDashboardForm),
                    <.div(DashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", DashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(DashboardCSS.Style.postActions)(
                        <.span(Icon.thList),
                        <.span(Icon.adjust),
                        <.span(Icon.anchor),
                        <.span(Icon.apple),
                        <.span(^.className := "pull-right")(
                          <.span(Icon.thList),
                          <.span(Icon.adjust)
                        )

                      )

                    )
                  )
                ),
                <.div(^.className := "col-lg-6 col-md-6 col-sm-12 col-xs-12", SynereoCommanStylesCSS.Style.paddingLeftZero)(
                  <.div(^.className := "row", DashboardCSS.Style.userPostRight)(
                    <.img(^.src := "./assets/synereo-images/default_avatar.jpg", ^.alt := "user avatar", DashboardCSS.Style.userAvatarDashboardForm),
                    <.div(DashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", DashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(DashboardCSS.Style.postActions)(
                        <.span(Icon.thList),
                        <.span(Icon.adjust),
                        <.span(Icon.anchor),
                        <.span(Icon.apple),
                        <.span(^.className := "pull-right")(
                          <.span(Icon.thList),
                          <.span(Icon.adjust)
                        )

                      )

                    )
                  ),
                  <.div(^.className := "row", DashboardCSS.Style.userPostRight)(
                    <.img(^.src := "./assets/synereo-images/default_avatar.jpg", ^.alt := "user avatar", DashboardCSS.Style.userAvatarDashboardForm),
                    <.div(DashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", DashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(DashboardCSS.Style.postActions)(
                        <.span(Icon.thList),
                        <.span(Icon.adjust),
                        <.span(Icon.anchor),
                        <.span(Icon.apple),
                        <.span(^.className := "pull-right")(
                          <.span(Icon.thList),
                          <.span(Icon.adjust)
                        )

                      )

                    )
                  ),
                  <.div(^.className := "row", DashboardCSS.Style.userPostRight)(
                    <.img(^.src := "./assets/synereo-images/default_avatar.jpg", ^.alt := "user avatar", DashboardCSS.Style.userAvatarDashboardForm),
                    <.div(DashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", DashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(DashboardCSS.Style.postActions)(
                        <.span(Icon.thList),
                        <.span(Icon.adjust),
                        <.span(Icon.anchor),
                        <.span(Icon.apple),
                        <.span(^.className := "pull-right")(
                          <.span(Icon.thList),
                          <.span(Icon.adjust)
                        )

                      )

                    )
                  ),
                  <.div(^.className := "row", DashboardCSS.Style.userPostRight)(
                    <.img(^.src := "./assets/synereo-images/default_avatar.jpg", ^.alt := "user avatar", DashboardCSS.Style.userAvatarDashboardForm),
                    <.div(DashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", DashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(DashboardCSS.Style.postActions)(
                        <.span(Icon.thList),
                        <.span(Icon.adjust),
                        <.span(Icon.anchor),
                        <.span(Icon.apple),
                        <.span(^.className := "pull-right")(
                          <.span(Icon.thList),
                          <.span(Icon.adjust)
                        )

                      )

                    )
                  )
                )
              )

            )
          )
        )
      )

    }
  }


  val component = ReactComponentB[Props]("Timelineview")
    .initialState_P(p => State())
    .renderBackend[Backend]
    .build

  def apply(props: Props) = component(props)

}