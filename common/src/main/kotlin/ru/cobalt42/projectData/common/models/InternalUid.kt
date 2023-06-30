package ru.cobalt42.projectData.common.models

@JvmInline
value class InternalUid(private val uid: String) {
    fun asString() = uid

    companion object {
        val NONE = InternalUid("")
    }
}