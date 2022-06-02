package com.atis.gap.ports.repository

import com.atis.gap.application.domain.enterprise.Entity
import com.atis.gap.extensions.PaginationCommand
import com.mongodb.client.model.Filters
import com.mongodb.reactivestreams.client.MongoCollection
import com.mongodb.reactivestreams.client.MongoDatabase
import org.reactivestreams.Publisher

abstract class MongoRepository<T: Entity<*>> (
    private val mongoDatabase: MongoDatabase,
    private val collectionName: String,
    private val clazz: Class<T>
) {

    private fun <R> withCollection(fn: MongoCollection<T>.() -> R): R =
        mongoDatabase
            .getCollection(collectionName, clazz)
            .let(fn)

    fun findAll(paginationCommand: PaginationCommand): Publisher<T> =
        withCollection { with(paginationCommand) {
            find().skip(offset).limit(max)
        }}

    fun findByText(
        text: String,
        fieldName: String,
        paginationCommand: PaginationCommand
    ): Publisher<T> =
        withCollection { with(paginationCommand) {
            find(
                Filters.regex(fieldName, ".*$text.*", "i")
            ).skip(offset).limit(max)
        }}

}