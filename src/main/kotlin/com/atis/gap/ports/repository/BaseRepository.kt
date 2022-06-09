package com.atis.gap.ports.repository

import com.atis.gap.application.domain.enterprise.Entity
import com.atis.gap.extensions.PaginationCommand
import com.mongodb.client.result.InsertOneResult
import org.bson.types.ObjectId
import org.reactivestreams.Publisher

interface BaseRepository<T: Entity<*>> {

    fun findAll(paginationCommand: PaginationCommand): Publisher<T>

    fun findByText(
        text: String,
        fieldName: String = "name",
        paginationCommand: PaginationCommand
    ): Publisher<T>

    fun save(entity: T): T

    fun update(entity: T): Publisher<T>

    fun deleteById(id: Any?)

}