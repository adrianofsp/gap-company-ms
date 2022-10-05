package com.atis.gap.application.domain.enterprise

import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId

@Introspected
data class Company @Creator @BsonCreator constructor(
    @BsonProperty("_id")
    override var id: ObjectId? = null,
    @BsonProperty("name")
    var name: String
): IIdentifier<ObjectId>