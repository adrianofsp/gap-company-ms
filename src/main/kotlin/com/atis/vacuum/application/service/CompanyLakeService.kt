package com.atis.vacuum.application.service

import com.atis.vacuum.application.domain.enterprise.CompanyLake
import com.atis.vacuum.extensions.PaginationCommand
import com.atis.vacuum.ports.repository.CompanyRepository
import com.atis.vacuum.ports.usecases.CompanyUseCase
import jakarta.inject.Singleton
import org.reactivestreams.Publisher

@Singleton
class CompanyLakeService(
    private val companyRepository: CompanyRepository<CompanyLake>
): CompanyUseCase<CompanyLake> {

    override fun findAll(
        paginationCommand: PaginationCommand
    ) = companyRepository.findAll(
        skip = paginationCommand.offset,
        limit = paginationCommand.max
    )

    override fun findByName(
        name:String,
        paginationCommand: PaginationCommand
    ) = companyRepository.findByName(
        name = name,
        skip = paginationCommand.offset,
        limit = paginationCommand.max
    )


}