package ru.cobalt42.projectData.common.repo

import ru.cobalt42.projectData.common.helpers.errorRepoConcurrency
import ru.cobalt42.projectData.common.models.InternalError
import ru.cobalt42.projectData.common.models.InternalLock
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.helpers.errorEmptyId as internalErrorEmptyId
import ru.cobalt42.projectData.common.helpers.errorNotFound as internalErrorNotFound

class DbProjectResponse(
    override val data: InternalProject?,
    override val isSuccess: Boolean,
    override val errors: List<InternalError> = emptyList()
) : IDbResponse<InternalProject> {
    companion object {
        val MOCK_SUCCESS_EMPTY = DbProjectResponse(null, true)

        fun success(result: InternalProject) = DbProjectResponse(result, true)

        fun error(errors: List<InternalError>) = DbProjectResponse(null, false, errors)

        fun error(error: InternalError, data: InternalProject? = null) = DbProjectResponse(data, false, listOf(error))

        val errorEmptyId: DbProjectResponse = error(internalErrorEmptyId)

        fun errorConcurrent(lock: InternalLock, project: InternalProject?) = error(
            errorRepoConcurrency(lock, project?.lock?.let { InternalLock(it.asString()) }),
            project
        )

        val errorNotFound = error(internalErrorNotFound)
    }
}