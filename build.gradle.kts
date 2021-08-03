plugins {
  kotlin("multiplatform") apply false
  id("com.github.jakemarsden.git-hooks")
  id("org.jlleitschuh.gradle.ktlint")
  idea
}

gitHooks {
  setHooks(
    mapOf(
      "post-checkout" to "ktlintApplyToIdea",
      "pre-commit" to "ktlintFormat",
      "pre-push" to "check"
    )
  )
}

allprojects {
  apply(plugin = "org.jlleitschuh.gradle.ktlint")
  apply(plugin = "idea")

  idea {
    module {
      isDownloadSources = true
      isDownloadJavadoc = true
    }
  }

  ktlint {
    version by project.properties["ktlint.version"].toString()
    additionalEditorconfigFile.set(rootDir.resolve(".editorconfig"))
  }

  repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }

  tasks {
    withType<Test> {
      useJUnitPlatform()
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
      kotlinOptions {
        jvmTarget = "${project.properties["org.gradle.project.targetCompatibility"]}"
      }
    }
  }
}
