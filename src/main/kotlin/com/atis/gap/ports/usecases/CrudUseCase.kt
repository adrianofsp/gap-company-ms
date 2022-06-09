package com.atis.gap.ports.usecases

import org.reactivestreams.Publisher

interface CrudUseCase<E> {

    fun <T> manage(entity: T): T

}