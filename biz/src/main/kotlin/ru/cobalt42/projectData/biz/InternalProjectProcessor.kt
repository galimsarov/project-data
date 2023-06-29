package ru.cobalt42.projectData.biz

import com.crowdproj.kotlin.cor.ICorExec
import com.crowdproj.kotlin.cor.handlers.worker
import com.crowdproj.kotlin.cor.rootChain
import ru.cobalt42.projectData.biz.groups.operation
import ru.cobalt42.projectData.biz.validation.*
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalChangeDate
import ru.cobalt42.projectData.common.models.InternalCommand
import ru.cobalt42.projectData.common.models.InternalUid

class InternalProjectProcessor {
    suspend fun exec(ctx: ProjectContext) = BusinessChain.exec(ctx)

    companion object {
        private val BusinessChain: ICorExec<ProjectContext> = rootChain<ProjectContext> {
            operation("Создание проекта", InternalCommand.CREATE) {
                validation {
                    worker("Копируем поля в commodityValidating") { projectValidating = projectRequest.copy() }
                    worker("Очистка uid") { projectValidating.uid = InternalUid.NONE }
                    worker("Очистка наименования") { projectValidating.name = projectValidating.name.trim() }
                    worker("Очистка шифра") { projectValidating.code = projectValidating.code.trim() }
                    worker("Очистка страны") { projectValidating.country = projectValidating.country.trim() }
                    worker("Очистка области") { projectValidating.region = projectValidating.region.trim() }
                    worker("Очистка города") { projectValidating.city = projectValidating.city.trim() }
                    worker("Очистка улицы") { projectValidating.street = projectValidating.street.trim() }
                    worker("Очистка номера дома") { projectValidating.house = projectValidating.house.trim() }
                    worker("Очистка номера корпуса дома") {
                        projectValidating.building = projectValidating.building.trim()
                    }
                    worker("Очистка почтового индекса") {
                        projectValidating.postCode = projectValidating.postCode.trim()
                    }
                    worker("Очистка даты изменения") {
                        projectValidating.objectStatus.changeDate = InternalChangeDate.NONE
                    }
                    validateNameNotEmpty("Проверка, что наименование не пустое")
                    validateNameHasContent("Проверка символов")
                    validateCodeNotEmpty("Проверка, что шифр не пустой")
                    // Можно добавить валидацию шифра через регулярное выражение
                    validateCountryNotEmpty("Проверка, что страна не пустая")
                    validateCountryHasContent("Проверка символов")
                    validateRegionNotEmpty("Проверка, что область не пустая")
                    validateRegionHasContent("Проверка символов")
                    validateCityNotEmpty("Проверка, что город не пустой")
                    validateCityHasContent("Проверка символов")
                    validateStreetNotEmpty("Проверка, что улица не пустая")
                    // Можно добавить валидацию улицы через регулярное выражение
                    validateHouseNotEmpty("Проверка, что номер дома не пустой")
                    validateHouseHasContent("Проверка символов")
                    // Номера корпуса может не быть. Либо добавляем проверку на отсутствие пустоты и, если нужно, формат
                    validatePostCodeNotEmpty("Проверка, что почтовый индекс дома не пустой")
                    validatePostCodeHasContent("Проверка символов")
                    validateStatusIdNotNull("Проверка, что statusId не 0")

                    finishProjectValidation("Завершение проверок")
                }
            }

        }.build()
    }
}
