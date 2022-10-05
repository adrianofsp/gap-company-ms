package com.atis.gap.adapter.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoDatabase
import io.micronaut.configuration.mongo.core.DefaultMongoConfiguration
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class MongoConfig {
    @Singleton
    fun mongoDatabase(
        mongoClient: MongoClient,
        configuration: DefaultMongoConfiguration
    ): MongoDatabase = mongoClient.getDatabase(configuration.connectionString.get().database)

}




//@Value("\${db.name}")
//private val db: String,