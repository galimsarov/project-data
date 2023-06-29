package ru.cobalt42.projectData.mappers.v1

import ru.cobalt42.api.v1.models.ObjectStatus
import ru.cobalt42.api.v1.models.Project
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalChangeDate
import ru.cobalt42.projectData.common.models.InternalObjectStatus
import ru.cobalt42.projectData.common.models.InternalUid

fun ProjectContext.fromTransport(project: Project = Project(), uid: String = "") {
    projectRequest.uid = toInternalUid(project, uid)
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

fun toInternalUid(project: Project?, uid: String) = when {
    uid.isNotBlank() -> InternalUid(uid)
    project == null -> InternalUid.NONE
    else -> project.uid?.let { InternalUid(it) } ?: InternalUid.NONE
}

fun ObjectStatus?.toInternalObjectStatus() = InternalObjectStatus(
    changeDate = toInternalChangeDate(),
    statusId = this?.statusId ?: 0
)

fun ObjectStatus?.toInternalChangeDate(): InternalChangeDate =
    if (this == null) InternalChangeDate.NONE
    else InternalChangeDate(changeDate ?: "")