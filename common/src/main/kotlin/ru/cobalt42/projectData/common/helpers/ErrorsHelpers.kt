package ru.cobalt42.projectData.common.helpers

import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.exceptions.RepoConcurrencyException
import ru.cobalt42.projectData.common.models.InternalError
import ru.cobalt42.projectData.common.models.InternalLock
import ru.cobalt42.projectData.common.models.InternalState

fun ProjectContext.fail(error: InternalError) {
    addError(error)
    state = InternalState.FAILING
}

fun ProjectContext.addError(vararg error: InternalError) = errors.addAll(error)

fun errorValidation(
    field: String,
    /**
     * Код, характеризующий ошибку. Не должен включать имя поля или указание на валидацию.
     * Например: empty, badSymbols, tooLong, etc
     */
    violationCode: String,
    description: String,
    level: InternalError.Level = InternalError.Level.ERROR,
) = InternalError(
    code = "validation-$field-$violationCode",
    field = field,
    group = "validation",
    message = "Validation error for field $field: $description",
    level = level,
)

fun errorRepoConcurrency(
    expectedLock: InternalLock,
    actualLock: InternalLock?,
    exception: Exception? = null,
) = InternalError(
    field = "lock",
    code = "concurrency",
    group = "repo",
    message = "The object has been changed concurrently by another user or process",
    exception = exception ?: RepoConcurrencyException(expectedLock, actualLock),
)

val errorNotFound = InternalError(field = "id", message = "Not Found", code = "not-found")

val errorEmptyId = InternalError(field = "id", message = "Id must not be null or blank")