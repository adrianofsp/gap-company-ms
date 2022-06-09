package com.atis.gap.application.service

import com.atis.gap.application.domain.enterprise.CompanyLake
import com.atis.gap.ports.repository.CompanyLakeRepository
import com.atis.gap.ports.usecases.CompanyLakeUseCase
import jakarta.inject.Singleton

@Singleton
class CompanyLakeService(
    private val companyLakeRepository: CompanyLakeRepository
): CompanyLakeUseCase  {


    override fun <T> manage(entity: T): T {
        when (entity) {
            is CompanyLake -> {
                if(entity.id == null) companyLakeRepository.save(entity)
//                else companyLakeRepository.update(entity)
            }
            is Int -> companyLakeRepository.deleteById(entity)
            else -> throw Exception()
        }
    }
}