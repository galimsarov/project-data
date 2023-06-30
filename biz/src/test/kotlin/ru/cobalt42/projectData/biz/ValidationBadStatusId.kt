package ru.cobalt42.projectData.biz

import kotlinx.coroutines.test.runTest
import ru.cobalt42.projectData.common.ProjectContext
import ru.cobalt42.projectData.common.models.InternalCommand
import ru.cobalt42.projectData.common.models.InternalObjectStatus
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalState
import ru.cobalt42.projectData.stubs.InternalProjectStub
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

private val STUB = InternalProjectStub.get()

fun validationStatusIdCorrect(command: InternalCommand, processor: InternalProjectProcessor) = runTest {
    val ctx = ProjectContext(
        command = command,
        state = InternalState.NONE,
        projectRequest = InternalProject(
            uid = STUB.uid,
            name = "abc",
            code = "abc",
            country = "abc",
            region = "abc",
            city = "abc",
            street = "abc",
            house = "1",
            postCode = "123456",
            objectStatus = InternalObjectStatus(statusId = 1)
        )
    )
    processor.exec(ctx)
    assertEquals(0, ctx.errors.size)
    assertNotEquals(InternalState.FAILING, ctx.state)
    assertEquals(1, ctx.projectValidated.objectStatus.statusId)
}

fun validationStatusId(command: InternalCommand, processor: InternalProjectProcessor) = runTest {
    val ctx = ProjectContext(
        command = command,
        state = InternalState.NONE,
        projectRequest = InternalProject(
            uid = STUB.uid,
            name = "abc",
            code = "abc",
            country = "abc",
            region = "abc",
            city = "abc",
            street = "abc",
            house = "1",
            postCode = "123456",
            objectStatus = InternalObjectStatus(statusId = 0)
        )
    )
    processor.exec(ctx)
    assertEquals(1, ctx.errors.size)
    assertEquals(InternalState.FAILING, ctx.state)
    val error = ctx.errors.firstOrNull()
    assertEquals("statusId", error?.field)
    assertContains(error?.message ?: "", "statusId")
}