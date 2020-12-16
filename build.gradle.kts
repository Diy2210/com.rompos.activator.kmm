buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven ( url = "https://dl.bintray.com/icerockdev/moko" )
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.4.21")
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath ("com.squareup.sqldelight:gradle-plugin:1.4.4")
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

//buildscript {
//    repositories {
//        gradlePluginPortal()
//        jcenter()
//        google()
//        mavenCentral()
//    }
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
//        classpath("com.android.tools.build:gradle:4.1.1")
//        classpath ("com.squareup.sqldelight:gradle-plugin:1.4.4")
//        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.4.21")
//    }
//}
//
//allprojects {
//    repositories {
//        google()
//        jcenter()
//        mavenCentral()
//        maven( url = "https://dl.bintray.com/icerockdev/moko" )
//    }
//}