package com.atis.vacuum.ports.repository

import com.atis.vacuum.extensions.PaginationCommand
import org.reactivestreams.Publisher

interface BaseRepository<T> {

    fun findAll(paginationCommand: PaginationCommand): Publisher<T>

    fun findByText(
        text: String,
        fieldName: String = "name",
        paginationCommand: PaginationCommand
    ): Publisher<T>

}