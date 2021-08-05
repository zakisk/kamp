package dev.petuska.kmdc.chips

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.MDCDsl
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.Element

@JsModule("@material/chips/dist/mdc.chips.css")
private external val MDCChipsCSS: dynamic

@JsModule("@material/chips")
internal external object MDCChipsModule {
  class MDCChipSet(element: Element) {
    companion object {
      fun attachTo(element: Element)
    }
  }
}

/**
 * [JS API](https://github.com/material-components/material-components-web/tree/v12.0.0/packages/mdc-chips)
 */
@MDCDsl
@Composable
fun ElementScope<*>.MDCChipSet() {
  MDCChipsCSS
  DomSideEffect {
    TODO()
  }
}
