package ru.cobalt42.projectData.common.repo

import ru.cobalt42.projectData.common.models.InternalLock
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalUid

data class DbProjectUidRequest(
    val uid: InternalUid,
    val lock: InternalLock = InternalLock.NONE,
) {
    constructor(project: InternalProject) : this(project.uid)
}