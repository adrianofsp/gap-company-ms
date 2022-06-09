package com.atis.gap.adapter.`in`.rest.controller

import com.atis.gap.application.domain.enterprise.CompanyLake
import com.atis.gap.extensions.PaginationCommand
import com.atis.gap.ports.repository.CompanyLakeRepository
import com.atis.gap.ports.usecases.CompanyLakeUseCase
import io.micronaut.http.annotation.*
import org.bson.types.ObjectId
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
    fun create(companyLake: CompanyLake) = companyLakeUseCase.createOrUpdate(companyLake)

    @Put("/")
    fun update(companyLake: CompanyLake) = companyLakeUseCase.createOrUpdate(companyLake)

    @Delete("/{id}")
    fun delete(id: ObjectId) = companyLakeUseCase.removeById(id)

}