package ru.cobalt42.projectData.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.helpers.errorValidation
import ru.cobalt42.projectData.common.helpers.fail

fun CorChainDsl<ProjectContext>.validatePostCodeNotEmpty(title: String) = worker {
    this.title = title
    on { projectValidating.postCode.isEmpty() }
    handle {
        fail(
            errorValidation(
                field = "postCode",
                violationCode = "postCode",
                description = "field must not be empty"
            )
        )
    }
}