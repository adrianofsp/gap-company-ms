package com.atis.gap.application.service

import com.atis.gap.application.domain.enterprise.Company
import com.atis.gap.ports.repository.CompanyRepository
import com.atis.gap.ports.usecases.CompanyUseCase
import jakarta.inject.Singleton

@Singleton
class CompanyService(
    private val companyRepository: CompanyRepository,
): CompanyUseCase {

    override fun <T> manage(entity: T) {
        when (entity) {
            is Company -> {
                if(entity.id == null) companyRepository.save(entity)
                else companyRepository.update(entity)
            }
            is Int -> companyRepository.deleteById(entity)
            else -> throw Exception()
        }
    }

}