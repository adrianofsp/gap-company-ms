package com.atis.gap.extensions.annotations

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoCollection
import com.mongodb.reactivestreams.client.MongoDatabase
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.Introduction
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import io.micronaut.configuration.mongo.core.DefaultMongoConfiguration
import io.micronaut.core.annotation.Internal
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Singleton
import java.util.*
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

@Introduction
@Singleton
@MustBeDocumented
@Retention(RUNTIME)
@Target(CLASS, FILE, ANNOTATION_CLASS, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER)
annotation class MongoCollectionFactory (
    val collectionName: String = "",
    val clazz: KClass<*>
)

@Singleton
@InterceptorBean(MongoCollectionFactory::class) //
class StubIntroduction(
    mongoClient: MongoClient,
    configuration: DefaultMongoConfiguration
) : MethodInterceptor<Any, Any> { //

    private val mongoDatabase: MongoDatabase = mongoClient.getDatabase(configuration.connectionString.get().database)

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        val params = context.getValues(MongoCollectionFactory::class.java.canonicalName)
        return  mongoDatabase.getCollection(
            params["collectionName"].toString(),
            Class.forName(params["clazz"]!!.toString())
        )
    }
}

@Serdeable
data class State (
    val country: String,
)

interface GenericRepository<E> {

    @Internal
    val collection: MongoCollection<E>

}

@MongoCollectionFactory(collectionName = "states", clazz = State::class)
interface StateRepository: GenericRepository<State>
