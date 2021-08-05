package dev.petuska.kmdc.card

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.Builder
import dev.petuska.kmdc.ComposableBuilder
import dev.petuska.kmdc.MDCDsl
import dev.petuska.kmdc.button.MDCButton
import dev.petuska.kmdc.button.MDCButtonScope
import dev.petuska.kmdc.icon.button.MDCIconButton
import dev.petuska.kmdc.icon.button.MDCIconButtonScope
import dev.petuska.kmdc.icon.button.MDCIconLink
import dev.petuska.kmdc.icon.button.MDCIconLinkScope
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement

data class MDCCardActionsOpts(var type: Type = Type.Normal) {
  enum class Type(vararg val classes: String) {
    Normal,
    FullBleed("mdc-card__actions--full-bleed")
  }
}

class MDCCardActionsScope(scope: ElementScope<HTMLDivElement>) : ElementScope<HTMLDivElement> by scope

@MDCDsl
@Composable
fun MDCCardScope.MDCCardActions(
  opts: Builder<MDCCardActionsOpts>? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCCardActionsScope>? = null
) {
  val options = MDCCardActionsOpts().apply { opts?.invoke(this) }
  Div(
    attrs = {
      classes("mdc-card__actions", *options.type.classes)
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardActionsScope(this).it() } }
  )
}

@MDCDsl
@Composable
fun MDCCardActionsScope.MDCCardActionButtons(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCCardActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__action-buttons")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardActionsScope(this).it() } }
  )
}

@MDCDsl
@Composable
fun MDCCardActionsScope.MDCCardActionButton(
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCButtonScope>? = null
) {
  MDCButton(
    attrs = {
      classes("mdc-card__action", "mdc-card__action--button")
      attrs?.invoke(this)
    },
    content = content
  )
}

@MDCDsl
@Composable
fun MDCCardActionsScope.MDCCardActionIcons(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ComposableBuilder<MDCCardActionsScope>? = null
) {
  Div(
    attrs = {
      classes("mdc-card__action-icons")
      attrs?.invoke(this)
    },
    content = content?.let { { MDCCardActionsScope(this).it() } }
  )
}

@MDCDsl
@Composable
fun MDCCardActionsScope.MDCCardActionIconButton(
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ComposableBuilder<MDCIconButtonScope>? = null
) {
  MDCIconButton(
    attrs = {
      classes("mdc-card__action", "mdc-card__action--icon")
      attrs?.invoke(this)
    },
    content = content
  )
}

@MDCDsl
@Composable
fun MDCCardActionsScope.MDCCardActionIconLink(
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
  content: ComposableBuilder<MDCIconLinkScope>? = null
) {
  MDCIconLink(
    attrs = {
      classes("mdc-card__action", "mdc-card__action--icon")
      attrs?.invoke(this)
    },
    content = content
  )
}
