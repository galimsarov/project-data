rootProject.name = "projectData"

pluginManagement {
    val kotlinVersion: String by settings
    val openapiVersion: String by settings

    val springframeworkBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val pluginSpringVersion: String by settings
    val pluginJpa: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion

        id("org.openapi.generator") version openapiVersion

        kotlin("plugin.serialization") version kotlinVersion
        id("org.springframework.boot") version springframeworkBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
        kotlin("plugin.spring") version pluginSpringVersion
        kotlin("plugin.jpa") version pluginJpa
    }
}

include("api-v1-jackson")
include("common")
include("mappers-v1")

include("app-spring")
include("stubs")

include("biz")

include("repo-tests")