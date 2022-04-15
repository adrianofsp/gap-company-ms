package com.atis.vacuum.application.domain.enterprise

import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty

@Introspected
data class CompanyLake @Creator @BsonCreator constructor(
    @BsonProperty("name")
    var name: String,
    @BsonProperty("taxCode")
    var taxCode: String,
    @BsonProperty("state")
    var state: String,
    @BsonProperty("postalCode")
    var postalCode: String
)
