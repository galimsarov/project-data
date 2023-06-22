plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":api-v1-jackson"))
    implementation(project(":common"))

    testImplementation(kotlin("test-junit"))
}