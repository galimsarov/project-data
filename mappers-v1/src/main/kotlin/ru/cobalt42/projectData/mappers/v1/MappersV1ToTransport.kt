package ru.cobalt42.projectData.mappers.v1

import ru.cobalt42.api.v1.models.*
import ru.cobalt42.projectData.common.ProjectContext

fun ProjectContext.toTransportProjectGet() = ProjectPaginatedResponse(
    total = 1,
    result = listOf(
        Project(
            uid = projectResponse.uid.asString(),
            name = projectResponse.name,
            code = projectResponse.code,
            country = projectResponse.country,
            region = projectResponse.region,
            city = projectResponse.city,
            street = projectResponse.street,
            house = projectResponse.house,
            building = projectResponse.building,
            postCode = projectResponse.postCode,
            objectStatus = ObjectStatus(
                changeDate = projectResponse.objectStatus.changeDate,
                statusId = projectResponse.objectStatus.statusId
            )
        )
    )
)

fun ProjectContext.toTransportProjectCreateUpdateResponse() = ProjectResponse(
    result = ProjectResult(
        result = Project(
            uid = projectResponse.uid.asString(),
            name = projectResponse.name,
            code = projectResponse.code,
            country = projectResponse.country,
            region = projectResponse.region,
            city = projectResponse.city,
            street = projectResponse.street,
            house = projectResponse.house,
            building = projectResponse.building,
            postCode = projectResponse.postCode,
            objectStatus = ObjectStatus(
                changeDate = projectResponse.objectStatus.changeDate,
                statusId = projectResponse.objectStatus.statusId
            )
        )
    )
)