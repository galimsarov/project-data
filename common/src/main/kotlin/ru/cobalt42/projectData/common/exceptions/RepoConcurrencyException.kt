package ru.cobalt42.projectData.common.exceptions

import ru.cobalt42.projectData.common.models.InternalLock

class RepoConcurrencyException(expectedLock: InternalLock, actualLock: InternalLock?) : RuntimeException(
    "Expected lock is $expectedLock while actual lock in db is $actualLock"
)