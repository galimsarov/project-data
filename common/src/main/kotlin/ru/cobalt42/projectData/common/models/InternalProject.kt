package ru.cobalt42.projectData.common.models

data class InternalProject(
    var uid: InternalUid = InternalUid.NONE,
    var name: String = "",
    var code: String = "",
    var country: String = "",
    var region: String = "",
    var city: String = "",
    var street: String = "",
    var house: String = "",
    var building: String = "",
    var postCode: String = "",
    var objectStatus: InternalObjectStatus = InternalObjectStatus(),
    var lock: InternalLock = InternalLock.NONE,
)
