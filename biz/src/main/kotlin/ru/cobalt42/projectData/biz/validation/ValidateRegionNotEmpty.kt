package ru.cobalt42.projectData.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.helpers.errorValidation
import ru.cobalt42.projectData.common.helpers.fail

fun CorChainDsl<ProjectContext>.validateRegionNotEmpty(title: String) = worker {
    this.title = title
    on { projectValidating.region.isEmpty() }
    handle {
        fail(
            errorValidation(
                field = "region",
                violationCode = "region",
                description = "field must not be empty"
            )
        )
    }
}