package scanner.util

import kotlin.properties.*
import kotlin.reflect.*
import kotlin.reflect.full.*
import org.slf4j.*
import org.slf4j.LoggerFactory.getLogger

class LoggerDelegate<in R : Any> : ReadOnlyProperty<R, Logger> {
  override fun getValue(thisRef: R, property: KProperty<*>): Logger {
    val javaClass =
        thisRef.javaClass.let { java ->
          java.enclosingClass?.takeIf { it.kotlin.companionObject?.java == javaClass } ?: java
        }
    return getLogger(javaClass.name)
  }
}
