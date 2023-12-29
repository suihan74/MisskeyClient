import proguard.gradle.ProGuardTask

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.guardsquare:proguard-gradle:7.3.0")
    }
}

plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.10"
    `maven-publish`
}

group = "com.suihan74"
version = "0.0.9"

repositories {
    google()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

    // coroutines
    val coroutinesVersion = "1.7.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    // OkHttp3
    val okhttpVersion = "4.10.0"
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:$okhttpVersion")
    testImplementation("com.squareup.okhttp3:mockwebserver:$okhttpVersion")

    // Retrofit2
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
    testImplementation("com.squareup.retrofit2:retrofit-mock:$retrofitVersion")

    // Json
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    // html parser
    implementation("org.jsoup:jsoup:1.15.4")

    // Testing
    testImplementation("junit:junit:4.13.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Test> {
    /**
     * fix for retrofit https://github.com/square/retrofit/issues/3341
     */
    jvmArgs = listOf("--add-opens", "java.base/java.lang.invoke=ALL-UNNAMED")
}

tasks.register<ProGuardTask>("proguard") {
    configuration("proguard-rules.pro")

    injars(tasks.named<Jar>("jar").flatMap { it.archiveFile })

    val javaHome = System.getProperty("java.home")
    // Automatically handle the Java version of this build.
    if (System.getProperty("java.version").startsWith("1.")) {
        // Before Java 9, the runtime classes were packaged in a single jar file.
        libraryjars("$javaHome/lib/rt.jar")
    } else {
        // As of Java 9, the runtime classes are packaged in modular jmod files.
        libraryjars(
            // filters must be specified first, as a map
            mapOf("jarfilter" to "!**.jar", "filter" to "!module-info.class"),
            "$javaHome/jmods/java.base.jmod"
        )
    }
    verbose()

    val baseCoordinates = "misskeyclient"
    outjars(layout.buildDirectory.file("libs/${baseCoordinates}-minified.jar"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.suihan74.misskey"
            artifactId = "misskeyclient-kotlin"
            version = "0.0.9"
            from(components["kotlin"])
        }
    }
}