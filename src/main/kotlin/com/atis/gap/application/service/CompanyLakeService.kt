package com.atis.gap.application.service

import com.atis.gap.extensions.annotations.State
import com.atis.gap.extensions.annotations.StateRepository
import com.atis.gap.ports.repository.CompanyLakeRepository
import com.atis.gap.ports.usecases.CompanyLakeUseCase
import jakarta.inject.Singleton
import reactor.core.publisher.Mono

@Singleton
class CompanyLakeService(
    private val op: StateRepository
): CompanyLakeUseCase  {

    //    override fun createOrUpdate(entity: CompanyLake) = companyLakeRepository.save(entity)
//
//    override fun removeById(id: ObjectId) {
//        TODO("Not yet implemented")
//    }
    override fun findAll() {
        Mono.from(
            op.collection.find().first()
        ).subscribe({
            println(it)
        },{
            println(it)
        })

    }

//        println(stubRepo01.withCollection())

//        companyLakeRepository.findAll()


}