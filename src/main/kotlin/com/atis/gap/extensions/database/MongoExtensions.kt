package com.atis.gap.extensions.database

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoCollection

fun MongoClient.retrieve(
    db: String,
    collectionName: String,
    clazz: Class<*>
): MongoCollection<out Any> = run {
    this.getDatabase(db).getCollection(collectionName, clazz)
}
