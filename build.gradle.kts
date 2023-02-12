import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

group = "com.suihan74"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")

    // coroutines
    val coroutinesVersion = "1.6.4"
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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")

    // html parser
    implementation("org.jsoup:jsoup:1.15.3")

    // Testing
    testImplementation("junit:junit:4.13.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}