package ru.cobalt42.projectData.biz.groups

import com.crowdproj.kotlin.cor.handlers.CorChainDsl
import com.crowdproj.kotlin.cor.handlers.chain
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalCommand
import ru.cobalt42.projectData.common.models.InternalState

fun CorChainDsl<ProjectContext>.operation(
    title: String, command: InternalCommand, block: CorChainDsl<ProjectContext>.() -> Unit
) = chain {
    block()
    this.title = title
    on { this.command == command && state == InternalState.RUNNING }
}