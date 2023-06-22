rootProject.name = "projectData"

pluginManagement {
    val kotlinVersion: String by settings
    val openapiVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion

        id("org.openapi.generator") version openapiVersion
    }
}

include("api-v1-jackson")
include("common")
include("mappers-v1")