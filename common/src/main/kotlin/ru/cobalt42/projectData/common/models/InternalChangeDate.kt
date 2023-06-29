package ru.cobalt42.projectData.common.models

@JvmInline
value class InternalChangeDate(private val changeDate: String) {
    fun asString() = changeDate

    companion object {
        val NONE = InternalChangeDate("")
    }
}