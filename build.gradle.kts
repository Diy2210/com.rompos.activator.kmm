buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven ( url = "https://dl.bintray.com/icerockdev/moko" )
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
        classpath("com.android.tools.build:gradle:4.1.0")
        classpath ("com.squareup.sqldelight:gradle-plugin:1.4.3")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.4.10")
    }
    allprojects {
        repositories {
            maven( url = "https://dl.bintray.com/icerockdev/moko" )
        }
    }
}
group = "com.rompos.activator.kmm"
version = "1.0"

repositories {
    mavenCentral()
}
