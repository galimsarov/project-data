package ru.cobalt42.projectData.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.helpers.errorValidation
import ru.cobalt42.projectData.common.helpers.fail

fun CorChainDsl<ProjectContext>.validateStatusIdNotNull(title: String) = worker {
    this.title = title
    on { projectValidating.objectStatus.statusId == 0 }
    handle {
        fail(
            errorValidation(
                field = "statusId",
                violationCode = "statusId",
                description = "field must not be equals null"
            )
        )
    }
}