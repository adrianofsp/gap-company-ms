plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.20"
    id("org.jetbrains.kotlin.kapt") version "1.6.20"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.3.2"
    id("org.barfuin.gradle.jacocolog") version "2.0.0"
    jacoco
}

version = "0.1"
group = "com.atis.gap"

val kotlinVersion: String by project
val jacocoDir = "$buildDir/reports/jococo"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut.data:micronaut-data-document-processor:3.3.0")

    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")

    implementation("io.micronaut.mongodb:micronaut-mongo-reactive")

    implementation("io.micronaut:micronaut-validation")

    implementation("io.micronaut.reactor:micronaut-reactor")
    implementation("io.micronaut.reactor:micronaut-reactor-http-client")



    runtimeOnly("org.mongodb:mongodb-driver-reactivestreams")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("ch.qos.logback:logback-classic")
}

application {
    mainClass.set("com.atis.gap.ApplicationKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("17")
}

tasks {
    clean {
        doFirst { println("Executing cleanup") }
    }
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    test {
        finalizedBy(jacocoTestReport)
    }
    jacocoTestReport {
        dependsOn(test)
        reports {
            html.outputLocation.set(layout.buildDirectory.dir("$jacocoDir/html"))
        }
    }
}

jacoco {
    toolVersion = "0.8.7"
    reportsDirectory.set(layout.buildDirectory.dir(jacocoDir))
}

graalvmNative.toolchainDetection.set(false)

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.atis.gap.ApplcationKt"
    }
}

micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("com.atis.gap.*")
    }
}


