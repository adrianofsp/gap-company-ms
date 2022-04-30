package com.atis.vacuum.adapter.out.database

import com.atis.vacuum.application.domain.enterprise.Company
import com.atis.vacuum.ports.repository.CompanyRepository
import com.atis.vacuum.ports.repository.MongoRepository
import com.mongodb.reactivestreams.client.MongoDatabase
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class CompanyPersistence(
    mongoDatabase: MongoDatabase
): CompanyRepository<Company>,
    MongoRepository<Company>(
        mongoDatabase, "companiesLake", Company::class.java
    ) {

    private val logger = LoggerFactory.getLogger(CompanyPersistence::class.java)

}