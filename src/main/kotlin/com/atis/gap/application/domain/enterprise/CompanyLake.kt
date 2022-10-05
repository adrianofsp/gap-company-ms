package com.atis.gap.application.domain.enterprise

import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.NonNull
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId
import javax.validation.constraints.NotBlank

@Introspected
data class CompanyLake @Creator @BsonCreator constructor(

    @BsonId
    override var id: ObjectId? = null,

    @NonNull
    @NotBlank
    @BsonProperty("name")
    var name: String,

    @NonNull
    @NotBlank
    @BsonProperty("taxCode")
    var taxCode: String,

    @BsonProperty("state")
    var state: String? = null,

    @BsonProperty("postalCode")
    var postalCode: String? = null
) : IIdentifier<ObjectId>
