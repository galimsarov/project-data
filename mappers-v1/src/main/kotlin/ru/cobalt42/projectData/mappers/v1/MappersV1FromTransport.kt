package ru.cobalt42.projectData.mappers.v1

import ru.cobalt42.api.v1.models.ObjectStatus
import ru.cobalt42.api.v1.models.Project
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalObjectStatus
import ru.cobalt42.projectData.common.models.InternalUid

fun ProjectContext.fromTransport(project: Project) {
    projectRequest.uid = project.uid.toInternalUid()
    projectRequest.name = project.name ?: ""
    projectRequest.code = project.code ?: ""
    projectRequest.country = project.country ?: ""
    projectRequest.region = project.region ?: ""
    projectRequest.city = project.city ?: ""
    projectRequest.street = project.street ?: ""
    projectRequest.house = project.house ?: ""
    projectRequest.building = project.building ?: ""
    projectRequest.postCode = project.postCode ?: ""
    projectRequest.objectStatus = project.objectStatus.toInternalObjectStatus()
}

fun String?.toInternalUid(): InternalUid = if (this == null) InternalUid.NONE else InternalUid(this)

fun ObjectStatus?.toInternalObjectStatus() = InternalObjectStatus(
    changeDate = this?.changeDate ?: "",
    statusId = this?.statusId ?: 0
)