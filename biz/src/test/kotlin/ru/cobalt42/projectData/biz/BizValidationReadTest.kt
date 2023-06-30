package ru.cobalt42.projectData.biz

import org.junit.Test
import ru.cobalt42.projectData.common.models.InternalCommand

class BizValidationReadTest {
    private val command = InternalCommand.READ
    private val processor by lazy { InternalProjectProcessor() }

    // name
    @Test
    fun correctUid() = validationUidCorrect(command, processor)

    @Test
    fun emptyUid() = validationUidEmpty(command, processor)
}