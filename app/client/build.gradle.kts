plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

val jsOutputFile = "kamp-$version.js"
kotlin {
  jvm()
  js {
    useCommonJs()
    binaries.executable()
    browser {
      distribution {
        directory = buildDir.resolve("dist/WEB-INF")
      }
      commonWebpackConfig {
        cssSupport.enabled = true
        outputFileName = jsOutputFile
        devServer = devServer?.copy(
          port = 3000,
          proxy = mapOf("/api/*" to "http://localhost:8080"),
          open = false
        )
      }
    }
  }

  sourceSets {
    commonMain {
      dependencies {
        implementation(compose.web.web)
        implementation(compose.runtime)
        implementation(project(":app:common"))
        implementation("org.reduxkotlin:redux-kotlin-threadsafe:_")
        implementation("org.reduxkotlin:redux-kotlin-thunk:_")
        // implementation("io.ktor:ktor-client-cio:_")
        implementation("io.ktor:ktor-client-auth:_")
        implementation("io.ktor:ktor-client-serialization:_")
      }
    }
    named("jsMain") {
      dependencies {
        implementation(project(":app:client:mdc"))
      }
    }
    named("jvmMain") {
      dependencies {
        implementation(compose.foundation)
        implementation(compose.material)
        implementation(compose.materialIconsExtended)
        implementation(compose.desktop.common)
      }
    }
  }
}

tasks {
  named("jsProcessResources", Copy::class) {
    eachFile {
      if (name == "index.html") {
        expand(project.properties + mapOf("jsOutputFileName" to jsOutputFile))
      }
    }
  }
}
