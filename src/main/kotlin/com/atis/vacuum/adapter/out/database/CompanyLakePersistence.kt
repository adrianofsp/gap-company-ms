package com.atis.vacuum.adapter.out.database

import com.atis.vacuum.application.domain.enterprise.CompanyLake
import com.atis.vacuum.ports.repository.CompanyRepository
import com.atis.vacuum.ports.repository.MongoRepository
import com.mongodb.reactivestreams.client.MongoDatabase
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class CompanyLakePersistence (
    mongoDatabase: MongoDatabase
): CompanyRepository<CompanyLake>,
    MongoRepository<CompanyLake>(
        mongoDatabase, "companiesLake", CompanyLake::class.java
    ) {

    private val logger = LoggerFactory.getLogger(CompanyLakePersistence::class.java)

}