package ru.cobalt42.projectData.common.repo

import ru.cobalt42.projectData.common.models.InternalError

interface IDbResponse<T> {
    val data: T?
    val isSuccess: Boolean
    val errors: List<InternalError>
}