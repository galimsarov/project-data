package ru.cobalt42.projectData.stubs

import ru.cobalt42.projectData.common.models.InternalChangeDate
import ru.cobalt42.projectData.common.models.InternalObjectStatus
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalUid

object InternalProjectStub {
    fun get(): InternalProject = PROJECT

    private val PROJECT = InternalProject(
        uid = InternalUid("project_stub_uid"),
        name = "stub project",
        code = "stub code",
        country = "stub country",
        region = "stub region",
        city = "stub city",
        street = "stub street",
        house = "1",
        building = "stub building",
        postCode = "stub postCode",
        objectStatus = InternalObjectStatus(
            changeDate = InternalChangeDate("2023-01-01"),
            statusId = 1
        )
    )
}