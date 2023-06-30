package ru.cobalt42.projectData.common.models

@JvmInline
value class InternalLock(private val id: String) {
    fun asString() = id

    companion object {
        val NONE = InternalLock("")
    }
}