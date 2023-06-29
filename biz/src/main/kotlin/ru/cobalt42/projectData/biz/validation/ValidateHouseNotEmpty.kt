package ru.cobalt42.projectData.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.helpers.errorValidation
import ru.cobalt42.projectData.common.helpers.fail

fun CorChainDsl<ProjectContext>.validateHouseNotEmpty(title: String) = worker {
    this.title = title
    on { projectValidating.house.isEmpty() }
    handle {
        fail(
            errorValidation(
                field = "house",
                violationCode = "house",
                description = "field must not be empty"
            )
        )
    }
}