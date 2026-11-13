pluginManagement {
    repositories { google(); mavenCentral(); gradlePluginPortal() }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jfrog.takuad.com/artifactory/china_sdk")
            content {
                includeGroup("com.anythink.sdk")
                includeGroup("com.verbto.tools")
            }
        }
        maven {
            url = uri("https://artifact.bytedance.com/repository/pangle")
            content { includeGroup("com.pangle.cn") }
        }
        maven {
            url = uri("https://maven.redmagic.com/repository/maven-releases/")
            credentials {
                username = providers.environmentVariable("NUBIA_MAVEN_USERNAME")
                    .orElse(providers.gradleProperty("nubia.maven.username")).orNull
                password = providers.environmentVariable("NUBIA_MAVEN_PASSWORD")
                    .orElse(providers.gradleProperty("nubia.maven.password")).orNull
            }
            content { includeModule("cn.nubia.accounts", "nbaccounts-sdk") }
        }
    }
}
rootProject.name = "sud-gi-white-demo"
include(":app")
