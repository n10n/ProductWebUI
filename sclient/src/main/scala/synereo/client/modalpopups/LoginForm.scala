package synereo.client.modalpopups

import diode.{ModelRO}
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import shared.models.UserModel
import synereo.client.css.{LoginCSS, SignupCSS}
import scala.language.reflectiveCalls
import scala.scalajs.js
import scalacss.ScalaCssReact._
import japgolly.scalajs.react._
import org.querki.jquery._
import org.scalajs.dom._
import synereo.client.components._
import synereo.client.components.Bootstrap._
import synereo.client.services.{RootModel, SYNEREOCircuit}
import synereo.client.sessionitems.SessionItems

/**
  * Created by mandar.k on 4/19/2016.
  */
//scalastyle:off
object LoginForm {
  @inline private def bss = GlobalStyles.bootstrapStyles

  val editApiDetailBtn: js.Object = "#editApiDetailBtn"
  val Name: js.Object = "#Name"

  case class Props(submitHandler: (UserModel, Boolean, Boolean, Boolean, Boolean) => Callback, isUserVerified: Boolean = false)

  case class State(userModel: UserModel, login: Boolean = false,
                   showConfirmAccountCreation: Boolean = false,
                   showNewUserForm: Boolean = false,
                   showNewInviteForm: Boolean = false,
                   portNumber: String =  if(dom.window.location.port == "443"){""} else {s":${dom.window.location.port}"} ,//"9876",
                   apiURL: String = "",
                   lang: js.Dynamic = SYNEREOCircuit.zoom(_.i18n.language).value
                  )


  class LoginFormBackend(t: BackendScope[Props, State]) {

    def submitForm(e: ReactEventI) = {
      e.preventDefault()
      val state = t.state.runNow()
      window.sessionStorage.setItem(SessionItems.ApiDetails.API_URL, state.apiURL)
      val LoginBtn: js.Object = "#LoginBtn"
      if ($(LoginBtn).hasClass("disabled"))
        t.modState(s => s.copy(login = false))
      else
        t.modState(s => s.copy(login = true))
    }

    def addNewUserForm(): Callback = {
      t.modState(s => s.copy(login = false, showNewUserForm = true))
      //      t.modState(s => s.copy(showNewUserForm = true))
    }

    def addNewInviteForm(): Callback = {
      t.modState(s => s.copy(login = false, showNewInviteForm = true))
      //      t.modState(s => s.copy(showNewUserForm = true))
    }

    def hide = {
      jQuery(t.getDOMNode()).modal("hide")
    }

    def updateEmail(e: ReactEventI) = {
      //      println(e.target.value)
      val value = e.target.value
      t.modState(s => s.copy(userModel = s.userModel.copy(email = value)))
    }

    def showVerifyEmailModal(): Callback = {
      t.modState(s => s.copy(showConfirmAccountCreation = true))
    }

    def updatePassword(e: ReactEventI) = {
      val value = e.target.value
      t.modState(s => s.copy(userModel = s.userModel.copy(password = value)))
    }

    def updateAPIURL(e: ReactEventI) = {
      val value = e.target.value
            println(s"value:$value")
      t.modState(s => s.copy(apiURL = value))
    }

    def closeAPITextbox(e: ReactEventI) = {
      $(editApiDetailBtn).show()
      if (window.sessionStorage.getItem(SessionItems.ApiDetails.API_URL) != null)
        t.modState(s => s.copy(apiURL = window.sessionStorage.getItem(SessionItems.ApiDetails.API_URL)))
      else
        t.modState(s => s.copy(apiURL = s"https://${dom.window.location.hostname}${t.state.runNow().portNumber}"))
    }
    def updateLang(reader: ModelRO[js.Dynamic]) = {
      t.modState(s => s.copy(lang = reader.value)).runNow()
    }

    def mounted(): Callback = Callback {
      $(Name).focus()
      if (window.sessionStorage.getItem(SessionItems.ApiDetails.API_URL) != null) {
       // println(s"in if ${window.sessionStorage.getItem(SessionItems.ApiDetails.API_URL)}")
        t.modState(s => s.copy(apiURL = window.sessionStorage.getItem(SessionItems.ApiDetails.API_URL))).runNow()
      }
      else {
      //  println(s"in else ${if(dom.window.location.port==443) "" else dom.window.location.port }")
        t.modState(s => s.copy(apiURL = s"https://${dom.window.location.hostname}${t.state.runNow().portNumber}")).runNow()
      }
      SYNEREOCircuit.subscribe(SYNEREOCircuit.zoom(_.i18n.language))(e => updateLang(e))
    }

    def formClosed(state: LoginForm.State, props: LoginForm.Props): Callback = {
      // call parent handler with the new item and whether form was OK or cancelled
      //      println(s"state.showNewAgentForm: ${state.showNewUserForm}")
     // println(s"in else ${if(dom.window.location.port==443) "" else dom.window.location.port }")
      props.submitHandler(state.userModel, state.login, state.showConfirmAccountCreation, state.showNewUserForm, state.showNewInviteForm)
    }
  }


  private val component = ReactComponentB[Props]("LoginForm")
    .initialState_P(p => State(new UserModel("", "", "")))
    .backend(new LoginFormBackend(_))
    .renderPS((t, props, state) => {
      val headerText = state.lang.selectDynamic("LOGIN").toString
      Modal(
        Modal.Props(
          // header contains a cancel button (X)
          header = hide => <.span(<.button(^.tpe := "button", ^.className := "hide", bss.close, ^.onClick --> hide, Icon.close), <.div(/*SignupCSS.Style.signUpHeading*/)(/*headerText*/)), /*<.div()(headerText)),*/

          closed = () => t.backend.formClosed(state, props),
          addStyles = Seq(LoginCSS.Style.loginModalStyle), keyboard = false, id = "loginContainer"
        ),
        <.form(^.id := "LoginForm", "data-toggle".reactAttr := "validator", ^.role := "form", ^.onSubmit ==> t.backend.submitForm)(
          <.div(^.className := "row")(
            <.div(^.className := "col-md-12")(
              <.div()(
                if (props.isUserVerified) {
                  <.div(^.className := "emailVerifiedContainer")(<.h5("Email address verified."), <.h5("Please login with your credentails "))
                } else
                  <.img(^.src := "./assets/synereo-images/synereologo.png", LoginCSS.Style.loginImg),
                <.div(LoginCSS.Style.loginHeading)(headerText),
                <.div(LoginCSS.Style.loginFormInputText)(
                  <.div(LoginCSS.Style.apiDetailsContainer)(
                    <.div(^.id := "addLabel", ^.className := "collapse")(
                      <.div(^.className := "input-group")(
                        // <.label(LoginCSS.Style.loginFormLabel)("API Server"),
                        <.input(SignupCSS.Style.inputStyleSignUpForm, ^.tpe := "text", bss.formControl, ^.id := "apiserver", ^.className := "form-control",
                          ^.placeholder := "API-Server", "data-error".reactAttr := "Server URL is required", "ref".reactAttr := "", ^.value := state.apiURL, ^.onChange ==> t.backend.updateAPIURL, ^.required := true),
                        <.div(^.className := "help-block with-errors"),
                        <.span(^.className := "input-group-addon", ^.`type` := "button", "data-toggle".reactAttr := "collapse", "data-target".reactAttr := "#addLabel", ^.className := "btn", ^.onClick ==> t.backend.closeAPITextbox)(Icon.times),
                        <.span(^.className := "input-group-addon", ^.`type` := "button", "data-toggle".reactAttr := "collapse", "data-target".reactAttr := "#addLabel", ^.className := "btn", ^.onClick --> Callback {
                          $(editApiDetailBtn).show()
                        })(Icon.check)
                      )
                    ),
                    <.button(^.id := "editApiDetailBtn", ^.`type` := "button",LoginCSS.Style.editApiDetailBtn ,^.className := "btn btn-default", "data-toggle".reactAttr := "collapse", "data-target".reactAttr := "#addLabel", ^.onClick --> Callback {
                      $(editApiDetailBtn).hide()
                    })(state.lang.selectDynamic("EDIT_API_DETAILS").toString)
                  )
                ),
                <.div(LoginCSS.Style.loginFormInputText, ^.className := "form-group has-feedback")(
                  //  <.label(LoginCSS.Style.loginFormLabel)("User Name"),
                  <.input(SignupCSS.Style.inputStyleSignUpForm, ^.tpe := "text", bss.formControl, ^.id := "Name", ^.placeholder := state.lang.selectDynamic("EMAIL").toString,
                    "data-error".reactAttr := "Email is required", ^.value := state.userModel.email, ^.onChange ==> t.backend.updateEmail, ^.required := true, ^.ref := "nameInput"),
                  <.span(^.className := "glyphicon form-control-feedback", SignupCSS.Style.formControlMargin, "aria-hidden".reactAttr := "true"),
                  <.div(^.className := "help-block with-errors")
                ),
                <.div(LoginCSS.Style.loginFormInputText, ^.className := "form-group has-feedback")(
                  // <.label(LoginCSS.Style.loginFormLabel)("Password"),
                  <.input(SignupCSS.Style.inputStyleSignUpForm, ^.tpe := "password", bss.formControl, ^.placeholder := state.lang.selectDynamic("PASSWORD").toString, ^.className := "form-control", ^.id := "inputPassword", "data-error".reactAttr := "Password is required",
                    ^.value := state.userModel.password, ^.onChange ==> t.backend.updatePassword, ^.required := true),
                  <.span(^.className := "glyphicon form-control-feedback", SignupCSS.Style.formControlMargin, "aria-hidden".reactAttr := "true"),
                  <.div(^.className := "help-block with-errors")
                ),
                <.div(^.className := "text-center", ^.className := "form-group")(
                  <.button(^.tpe := "submit", ^.id := "LoginBtn", LoginCSS.Style.modalLoginBtn, ^.className := "btn", state.lang.selectDynamic("LOGIN").toString)
                )
              )
            )
          )
        ),
        <.div(bss.modal.footer, LoginCSS.Style.loginModalFooter)(
          Button(Button.Props(t.backend.addNewUserForm(), CommonStyle.default, Seq(LoginCSS.Style.dontHaveAccountBtnLoginModal), "", ""), state.lang.selectDynamic("DONT_HAVE_AN_ACCOUNT?").toString),
          Button(Button.Props(t.backend.showVerifyEmailModal(), CommonStyle.default, Seq(LoginCSS.Style.verifyUserBtnLoginModal), "", ""), state.lang.selectDynamic("VERIFY YOUR TOKEN").toString)
        )
      )

    })
    .componentDidMount(scope => {
      scope.backend.mounted()
    }
    )
    .componentDidUpdate(scope => Callback {
      if (scope.currentState.login || scope.currentState.showConfirmAccountCreation || scope.currentState.showNewUserForm || scope.currentState.showNewInviteForm) {
        scope.$.backend.hide
      }
      //      if (scope.currentState.showNewAgentForm) NewUserForm(NewUserForm.Props(scope.component.backend.addNewUser()))
    })
    .build

  def apply(props: Props) = component(props)

}
