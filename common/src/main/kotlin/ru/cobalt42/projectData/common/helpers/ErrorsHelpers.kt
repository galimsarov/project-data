package ru.cobalt42.projectData.common.helpers

import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalError
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