package ru.cobalt42.projectData.common.models

data class InternalObjectStatus(
    var changeDate: InternalChangeDate = InternalChangeDate.NONE,
    var statusId: Int = 0
)