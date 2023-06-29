package ru.cobalt42.projectData.biz.workers

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.worker
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalState

fun CorChainDsl<ProjectContext>.initStatus(title: String) = worker {
    this.title = title
    on { state == InternalState.NONE }
    handle { state = InternalState.RUNNING }
}