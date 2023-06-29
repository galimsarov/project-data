package ru.cobalt42.projectData.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.helpers.errorValidation
import ru.cobalt42.projectData.common.helpers.fail

fun CorChainDsl<ProjectContext>.validatePostCodeHasContent(title: String) = worker {
    this.title = title
    val regExp = Regex("\\d{6}")
    on { projectValidating.postCode.isNotEmpty() && !projectValidating.postCode.contains(regExp) }
    handle {
        fail(
            errorValidation(
                field = "postCode",
                violationCode = "noContent",
                description = "field must contain letters"
            )
        )
    }
}