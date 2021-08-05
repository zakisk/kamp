package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.Builder
import dev.petuska.kmdc.ComposableBuilder
import dev.petuska.kmdc.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Header
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement

@JsModule("@material/top-app-bar/dist/mdc.top-app-bar.css")
private external val MDCTopAppBarStyle: dynamic

@JsModule("@material/top-app-bar")
private external object MDCTopAppBarModule {
  class MDCTopAppBar(element: Element) {
    companion object {
      fun attachTo(element: Element): MDCTopAppBar
    }
  }
}

data class MDCTopAppBarOpts(
  var type: Type = Type.Standard
) {
  enum class Type(val mainAdjustClass: String, vararg val classes: String) {
    Standard("mdc-top-app-bar--fixed-adjust"),
    Short("mdc-top-app-bar--short-fixed-adjust", "mdc-top-app-bar--short"),
    ShortCollapsed("mdc-top-app-bar--short-fixed-adjust", "mdc-top-app-bar--short", "mdc-top-app-bar--short-collapsed"),
    Fixed("mdc-top-app-bar--fixed-adjust", "mdc-top-app-bar--fixed"),
    Prominent("mdc-top-app-bar--prominent-fixed-adjust", "mdc-top-app-bar--prominent"),
    Dense("mdc-top-app-bar--dense-fixed-adjust", "mdc-top-app-bar--dense")
  }
}

class MDCTopAppBarScope(scope: ElementScope<HTMLElement>) : ElementScope<HTMLElement> by scope

/**
 * If using this [MDCTopAppBar] component, all the page content must be placed into [MDCTopAppBarMain] container.
 *
 * [JS API](https://github.com/material-components/material-components-web/tree/v12.0.0/packages/mdc-top-app-bar)
 */
@MDCDsl
@Composable
fun MDCTopAppBar(
  opts: Builder<MDCTopAppBarOpts>? = null,
  attrs: AttrBuilderContext<HTMLElement>? = null,
  content: ComposableBuilder<MDCTopAppBarScope>? = null
) {
  MDCTopAppBarStyle
  val options = MDCTopAppBarOpts().apply { opts?.invoke(this) }
  Header(
    attrs = {
      classes("mdc-top-app-bar", *options.type.classes)
      attrs?.invoke(this)
    },
  ) {
    DomSideEffect {
      MDCTopAppBarModule.MDCTopAppBar.attachTo(it)
    }
    content?.let { MDCTopAppBarScope(this).it() }
  }
}
