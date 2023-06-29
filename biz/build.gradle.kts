val kotlinCorVersion: String by project
val coroutinesVersion: String by project

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation(project(":stubs"))
    implementation("com.crowdproj:kotlin-cor:$kotlinCorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    testImplementation(kotlin("test-junit"))
}