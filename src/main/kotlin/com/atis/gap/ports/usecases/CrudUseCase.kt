package com.atis.gap.ports.usecases

import com.atis.gap.application.domain.enterprise.IIdentifier

interface CrudUseCase<E: IIdentifier<*>, T> {

    fun createOrUpdate(entity: E): E
    fun removeById(id: T)

}