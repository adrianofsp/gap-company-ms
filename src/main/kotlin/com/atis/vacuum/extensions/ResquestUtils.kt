package com.atis.vacuum.extensions

import io.micronaut.core.annotation.Introspected

@Introspected
data class PaginationCommand(
    var max: Int = 100,
    var offset: Int = 0
)