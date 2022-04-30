package com.atis.vacuum.ports.repository

import com.atis.vacuum.extensions.PaginationCommand
import com.mongodb.client.model.Filters
import com.mongodb.reactivestreams.client.MongoCollection
import com.mongodb.reactivestreams.client.MongoDatabase
import org.reactivestreams.Publisher

abstract class MongoRepository<T> (
    private val mongoDatabase: MongoDatabase,
    private val collectionName: String,
    private val clazz: Class<T>
): BaseRepository<T> {

    private fun <R> withCollection(fn: MongoCollection<T>.() -> R): R =
        mongoDatabase
            .getCollection(collectionName, clazz)
            .let(fn)

    override fun findAll(paginationCommand: PaginationCommand): Publisher<T> =
        withCollection { with(paginationCommand) {
            find().skip(offset).limit(max)
        }}

    override fun findByText(
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