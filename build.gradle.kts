plugins {
    id("antlr")
    id("java")
    id("org.jetbrains.intellij") version "1.5.2"
}

group = "com.github.gomelon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    version.set("2021.3")
    type.set("GO") // Target IDE Platform

    plugins.set(listOf("go"))
}

dependencies {
    antlr("org.antlr:antlr4:4.10.1") { // use ANTLR version 4
        //TODO 这里要看下怎么写
//        exclude group: 'com.ibm.icu'; module: 'icu4j'
    }
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    testImplementation("org.mockito:mockito-core:4.8.1")
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    patchPluginXml {
        sinceBuild.set("212")
        untilBuild.set("222.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }

    test {
        useJUnitPlatform()
    }
}