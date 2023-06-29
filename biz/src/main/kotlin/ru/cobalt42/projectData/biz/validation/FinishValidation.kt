package ru.cobalt42.projectData.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalState

fun CorChainDsl<ProjectContext>.finishProjectValidation(title: String) = worker {
    this.title = title
    on { state == InternalState.RUNNING }
    handle {
        projectValidated = projectValidating
    }
}