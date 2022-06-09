package com.atis.gap.mocks

import com.atis.gap.application.domain.enterprise.CompanyLake
import com.atis.gap.extensions.charPool
import com.atis.gap.extensions.numberPool
import com.atis.gap.ports.repository.CompanyLakeRepository
import org.bson.types.ObjectId

fun CompanyLakeRepository.mock(
    name: String = (1..9)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString(""),
    taxCode: String = (1..9)
        .map { numberPool.random() }
        .joinToString(""),
) = CompanyLake(ObjectId(), name, taxCode, "SP", "015839009")

fun CompanyLakeRepository.mock(
    id: ObjectId? = null,
    name: String = (1..9)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString(""),
    taxCode: String = (1..9)
        .map { numberPool.random() }
        .joinToString(""),
    state: String? = null,
    postalCode: String? = null
) = CompanyLake(id, name, taxCode, state, postalCode)