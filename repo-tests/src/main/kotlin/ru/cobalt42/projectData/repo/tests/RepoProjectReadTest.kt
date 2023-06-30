package ru.cobalt42.projectData.repo.tests

import org.junit.Test
import ru.cobalt42.projectData.common.models.InternalProject
import ru.cobalt42.projectData.common.models.InternalUid
import ru.cobalt42.projectData.common.repo.DbProjectUidRequest
import ru.cobalt42.projectData.common.repo.IProjectRepository
import kotlin.test.assertEquals

abstract class RepoProjectReadTest {
    abstract val repo: IProjectRepository
    protected open val readSuccess = initObjects[0]

    @Test
    fun readSuccess() = runRepoTest {
        val result = repo.readCommodity(DbProjectUidRequest(readSuccess.uid))

        assertEquals(true, result.isSuccess)
        assertEquals(readSuccess, result.data)
        assertEquals(emptyList(), result.errors)
    }

    @Test
    fun readNotFound() = runRepoTest {
        val result = repo.readCommodity(DbProjectUidRequest(notFoundUid))

        assertEquals(false, result.isSuccess)
        assertEquals(null, result.data)
        val error = result.errors.find { it.code == "not-found" }
        assertEquals("uid", error?.field)
    }

    companion object : BaseInitProject("read") {
        override val initObjects: List<InternalProject> = listOf(
            createInitTestModel("read")
        )

        val notFoundUid = InternalUid("project-repo-read-notFound")
    }
}