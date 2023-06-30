package ru.cobalt42.projectData.repo.tests

import ru.cobalt42.projectData.common.models.InternalLock
import ru.cobalt42.projectData.common.models.InternalObjectStatus
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalUid

abstract class BaseInitProject(val op: String) : IInitObjects<InternalProject> {
    open val lockOld: InternalLock = InternalLock("20000000-0000-0000-0000-000000000001")
    open val lockBad: InternalLock = InternalLock("20000000-0000-0000-0000-000000000009")

    fun createInitTestModel(suf: String, lock: InternalLock = lockOld) = InternalProject(
        uid = InternalUid("project-repo-$op-$suf"),
        name = "$suf stub",
        code = "$suf stub code",
        country = "$suf stub country",
        region = "$suf stub country",
        city = "$suf stub city",
        street = "$suf stub street",
        house = "1",
        building = "$suf stub building",
        postCode = "$suf stub post code",
        objectStatus = InternalObjectStatus(statusId = 1),
        lock = lock
    )

    companion object : BaseInitProject("create") {
        override val initObjects: List<InternalProject> = emptyList()
    }
}