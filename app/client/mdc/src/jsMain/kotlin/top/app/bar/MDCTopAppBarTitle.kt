package dev.petuska.kmdc.top.app.bar

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.MDCDsl
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

@MDCDsl
@Composable
fun MDCTopAppBarSectionScope.MDCTopAppBarTitle(
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  Span(
    attrs = {
      classes("mdc-top-app-bar__title")
      attrs?.invoke(this)
    },
    content = content
  )
}

@MDCDsl
@Composable
fun MDCTopAppBarSectionScope.MDCTopAppBarTitle(
  text: String,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
) {
  MDCTopAppBarTitle(attrs = attrs) {
    Text(text)
  }
}
