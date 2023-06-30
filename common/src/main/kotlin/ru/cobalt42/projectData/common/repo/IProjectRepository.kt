package ru.cobalt42.projectData.common.repo

interface IProjectRepository {
    suspend fun createCommodity(rq: DbProjectRequest): DbProjectResponse
    suspend fun readCommodity(rq: DbProjectUidRequest): DbProjectResponse
    suspend fun updateCommodity(rq: DbProjectRequest): DbProjectResponse

    companion object {
        val NONE = object : IProjectRepository {
            override suspend fun createCommodity(rq: DbProjectRequest): DbProjectResponse {
                TODO("Not yet implemented")
            }

            override suspend fun readCommodity(rq: DbProjectUidRequest): DbProjectResponse {
                TODO("Not yet implemented")
            }

            override suspend fun updateCommodity(rq: DbProjectRequest): DbProjectResponse {
                TODO("Not yet implemented")
            }
        }
    }
}