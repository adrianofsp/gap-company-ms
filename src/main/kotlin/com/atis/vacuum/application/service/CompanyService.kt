package com.atis.vacuum.application.service

import com.atis.vacuum.application.domain.enterprise.Company
import com.atis.vacuum.extensions.PaginationCommand
import com.atis.vacuum.ports.repository.CompanyRepository
import com.atis.vacuum.ports.usecases.CompanyUseCase
import jakarta.inject.Singleton

@Singleton
class CompanyService(
    private val companyRepository: CompanyRepository<Company>,
): CompanyUseCase<Company> {

    override fun findAll(
        paginationCommand: PaginationCommand
    ) = companyRepository.findAll(
        paginationCommand = paginationCommand
    )

    override fun findByName(
        name: String,
        paginationCommand: PaginationCommand
    ) = companyRepository.findByText(
        text = name,
        paginationCommand = paginationCommand
    )

}