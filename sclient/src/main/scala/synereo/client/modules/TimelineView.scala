package synereo.client.modules

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import synereo.client.SYNEREOMain
import SYNEREOMain.Loc
import synereo.client.components.Icon
import synereo.client.css.{SynereoCommanStylesCSS, SDashboardCSS, UserTimelineViewCSS}

import scalacss.ScalaCssReact._


/**
  * Created by Mandar on 3/28/2016.
  */
object TimelineView {

  val component = ReactComponentB[RouterCtl[Loc]]("Dashboard").
    render_P { ctr =>
      <.div(^.className := "container-fluid")(
        <.div(^.className := "row")(
          <.div(^.className := "col-md-12")(
            <.div(^.className := "container")(
              <.div(^.className := "row", UserTimelineViewCSS.Style.coverHolderDiv)(
                <.img(^.src := "./assets/images/cover-background.jpg", UserTimelineViewCSS.Style.coverBackgroundImg),
                <.div(UserTimelineViewCSS.Style.coverDescriptionContainer)(
                  <.div(^.className := "row")(
                    <.div(^.className := "col-md-2 text-center")(
                      <.img(^.src := "./assets/images/default_avatar.jpg", UserTimelineViewCSS.Style.userAvatar),
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
                      <.button(^.className := "btn",UserTimelineViewCSS.Style.followBtn)("FOLLOWING")
                    )
                  )
                )
              ),
              <.div(^.className := "row")(
                <.div(^.className := "col-lg-6 col-md-6 col-sm-12 col-xs-12", SynereoCommanStylesCSS.Style.paddingRightZero)(
                  <.div(^.className := "row", SDashboardCSS.Style.userPost)(
                    <.img(^.src := "./assets/images/default_avatar.jpg", ^.alt := "user avatar", SDashboardCSS.Style.userAvatar),
                    <.input(SDashboardCSS.Style.UserInput, ^.placeholder := "contribute your thoughts..."),
                    <.span()(Icon.camera)
                  ),
                  <.div(^.className := "row", SDashboardCSS.Style.userPost)(
                    <.img(^.src := "./assets/images/default_avatar.jpg", ^.alt := "user avatar", SDashboardCSS.Style.userAvatar),
                    <.div(SDashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", SDashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(SDashboardCSS.Style.postActions)(
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
                  <.div(^.className := "row", SDashboardCSS.Style.userPost)(
                    <.img(^.src := "./assets/images/default_avatar.jpg", ^.alt := "user avatar", SDashboardCSS.Style.userAvatar),
                    <.div(SDashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", SDashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(SDashboardCSS.Style.postActions)(
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
                  <.div(^.className := "row", SDashboardCSS.Style.userPostRight)(
                    <.img(^.src := "./assets/images/default_avatar.jpg", ^.alt := "user avatar", SDashboardCSS.Style.userAvatar),
                    <.div(SDashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", SDashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(SDashboardCSS.Style.postActions)(
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
                  <.div(^.className := "row", SDashboardCSS.Style.userPostRight)(
                    <.img(^.src := "./assets/images/default_avatar.jpg", ^.alt := "user avatar", SDashboardCSS.Style.userAvatar),
                    <.div(SDashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", SDashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(SDashboardCSS.Style.postActions)(
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
                  <.div(^.className := "row", SDashboardCSS.Style.userPostRight)(
                    <.img(^.src := "./assets/images/default_avatar.jpg", ^.alt := "user avatar", SDashboardCSS.Style.userAvatar),
                    <.div(SDashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", SDashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(SDashboardCSS.Style.postActions)(
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
                  <.div(^.className := "row", SDashboardCSS.Style.userPostRight)(
                    <.img(^.src := "./assets/images/default_avatar.jpg", ^.alt := "user avatar", SDashboardCSS.Style.userAvatar),
                    <.div(SDashboardCSS.Style.userNameDescription)(
                      <.span("James Gosling"),
                      <.span(Icon.chevronRight),
                      <.span(^.color := "blue")("Ux love,party at new york"), <.br(),
                      <.span("just now")
                    ),
                    <.span()(Icon.ellipsisV),
                    <.div(^.className := "col-md-12")(
                      <.h3("Headed to  sxsw", SDashboardCSS.Style.cardHeading),
                      <.div("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do " +
                        "eiusmod\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\nquis nostrud exercitation ullamco laboris nisi ut aliquip "),
                      <.br(),
                      <.span(^.color := "blue")(Icon.ellipsisH)
                    ),
                    <.div(^.className := "col-md-12")(
                      <.div(SDashboardCSS.Style.postActions)(
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
    }.build

  def apply(router: RouterCtl[Loc]) = component(router)


}