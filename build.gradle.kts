buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath ("com.squareup.sqldelight:gradle-plugin:1.4.4")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.4.21")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven( url = "https://dl.bintray.com/icerockdev/moko" )
    }
}