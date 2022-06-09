package com.atis.gap.ports.usecases

import com.atis.gap.application.domain.enterprise.Entity

interface CrudUseCase<E: Entity<*>, T> {

    fun createOrUpdate(entity: E): E
    fun removeById(id: T)

}