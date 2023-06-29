package ru.cobalt42.projectData.biz.validation

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.chain
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalState

fun CorChainDsl<ProjectContext>.validation(block: CorChainDsl<ProjectContext>.() -> Unit) = chain {
    block()
    title = "Валидация"
    on { state == InternalState.RUNNING }
}