package ru.cobalt42.projectData.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.helpers.errorValidation
import ru.cobalt42.projectData.common.helpers.fail

fun CorChainDsl<ProjectContext>.validateCityHasContent(title: String) = worker {
    this.title = title
    val regExp = Regex("\\p{L}")
    on { projectValidating.city.isNotEmpty() && !projectValidating.city.contains(regExp) }
    handle {
        fail(
            errorValidation(
                field = "city",
                violationCode = "noContent",
                description = "field must contain letters"
            )
        )
    }
}