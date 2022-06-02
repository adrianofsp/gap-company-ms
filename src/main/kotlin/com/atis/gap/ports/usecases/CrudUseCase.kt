package com.atis.gap.ports.usecases

interface CrudUseCase<E> {

    fun <T> manage(entity: T)

}