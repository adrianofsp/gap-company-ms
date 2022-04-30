package com.atis.vacuum.ports.usecases

import com.atis.vacuum.extensions.PaginationCommand
import org.reactivestreams.Publisher

interface CompanyUseCase<T> {

    fun findAll(paginationCommand: PaginationCommand): Publisher<T>

    fun findByName(name: String, paginationCommand: PaginationCommand): Publisher<T>

}