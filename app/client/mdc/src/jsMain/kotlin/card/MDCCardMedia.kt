package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.Builder
import dev.petuska.kmdc.ComposableBuilder
import dev.petuska.kmdc.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

data class MDCCardMediaOpts(var type: Type = Type.Free) {
  enum class Type(vararg val classes: String) {
    Free,
    Square("mdc-card__media--square"),
    Cinema("mdc-card__media--16-9")
  }
}

class MDCCardMediaScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

@MDCDsl
@Composable
fun MDCCardScope.MDCCardMedia(
  opts: Builder<MDCCardMediaOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCCardMediaScope>? = null
) {
  val options = MDCCardMediaOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-card__media", *options.type.classes)
      attrs?.invoke(this)
    },
  ) {
    content?.let { MDCCardMediaScope(this).it() }
  }
}

@MDCDsl
@Composable
fun MDCCardMediaScope.MDCCardMediaContent(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__media-content")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardScope(this).it() } }
  )
}
