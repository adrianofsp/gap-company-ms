package com.atis.gap.adapter.`in`.rest.controller

import com.atis.gap.application.domain.enterprise.Company
import com.atis.gap.application.domain.enterprise.CompanyLake
import com.atis.gap.extensions.PaginationCommand
import com.atis.gap.ports.repository.CompanyLakeRepository
import com.atis.gap.ports.repository.CompanyRepository
import com.atis.gap.ports.usecases.CompanyLakeUseCase
import com.atis.gap.ports.usecases.CompanyUseCase
import io.micronaut.http.annotation.*
import javax.validation.Valid

@Controller("/company/lake")
open class CompanyLakeController(
    private val companyLakeUseCase: CompanyLakeUseCase,
    private val companyLakeRepository: CompanyLakeRepository
) {

    @Get("/health")
    fun isHealth() = true

    @Get("/{?paginationCommand*}")
    open fun list(@Valid paginationCommand: PaginationCommand) = companyLakeRepository.findAll(paginationCommand)

    @Get("/{name}{?paginationCommand*}")
    open fun listByName(
        name: String,
        @Valid paginationCommand: PaginationCommand
    ) = companyLakeRepository.findByText(text = name, paginationCommand = paginationCommand)

    @Post("/")
    fun create(companyLake: CompanyLake) = companyLakeUseCase.manage(companyLake)

    @Put("/")
    fun update(companyLake: CompanyLake) = companyLakeUseCase.manage(companyLake)

    @Delete("/{id}")
    fun delete(id: Int) = companyLakeUseCase.manage(id)

}