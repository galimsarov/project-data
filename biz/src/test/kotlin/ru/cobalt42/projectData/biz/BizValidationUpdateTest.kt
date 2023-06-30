package ru.cobalt42.projectData.biz

import org.junit.Test
import ru.cobalt42.projectData.common.models.InternalCommand

class BizValidationUpdateTest {
    private val command = InternalCommand.UPDATE
    private val processor by lazy { InternalProjectProcessor() }

    // name
    @Test
    fun correctUid() = validationUidCorrect(command, processor)

    @Test
    fun emptyUid() = validationUidEmpty(command, processor)

    // name
    @Test
    fun correctName() = validationNameCorrect(command, processor)

    @Test
    fun trimName() = validationNameTrim(command, processor)

    @Test
    fun emptyName() = validationNameEmpty(command, processor)

    @Test
    fun badSymbolsName() = validationNameSymbols(command, processor)

    // code
    @Test
    fun correctCode() = validationCodeCorrect(command, processor)

    @Test
    fun trimCode() = validationCodeTrim(command, processor)

    @Test
    fun emptyCode() = validationCodeEmpty(command, processor)

    // country
    @Test
    fun correctCountry() = validationCountryCorrect(command, processor)

    @Test
    fun trimCountry() = validationCountryTrim(command, processor)

    @Test
    fun emptyCountry() = validationCountryEmpty(command, processor)

    @Test
    fun badSymbolsCountry() = validationCountrySymbols(command, processor)

    // region
    @Test
    fun correctRegion() = validationRegionCorrect(command, processor)

    @Test
    fun trimRegion() = validationRegionTrim(command, processor)

    @Test
    fun emptyRegion() = validationRegionEmpty(command, processor)

    @Test
    fun badSymbolsRegion() = validationRegionSymbols(command, processor)

    // city
    @Test
    fun correctCity() = validationCityCorrect(command, processor)

    @Test
    fun trimCity() = validationCityTrim(command, processor)

    @Test
    fun emptyCity() = validationCityEmpty(command, processor)

    @Test
    fun badSymbolsCity() = validationCitySymbols(command, processor)

    // street
    @Test
    fun correctStreet() = validationStreetCorrect(command, processor)

    @Test
    fun trimStreet() = validationStreetTrim(command, processor)

    @Test
    fun emptyStreet() = validationStreetEmpty(command, processor)

    // house
    @Test
    fun correctHouse() = validationHouseCorrect(command, processor)

    @Test
    fun trimHouse() = validationHouseTrim(command, processor)

    @Test
    fun emptyHouse() = validationHouseEmpty(command, processor)

    @Test
    fun badSymbolsHouse() = validationHouseSymbols(command, processor)

    // postCode
    @Test
    fun correctPostCode() = validationPostCodeCorrect(command, processor)

    @Test
    fun trimPostCode() = validationPostCodeTrim(command, processor)

    @Test
    fun emptyPostCode() = validationPostCodeEmpty(command, processor)

    @Test
    fun badSymbolsPostCode() = validationPostCodeSymbols(command, processor)

    // statusId
    @Test
    fun correctStatusId() = validationStatusIdCorrect(command, processor)

    @Test
    fun badStatusId() = validationStatusId(command, processor)
}