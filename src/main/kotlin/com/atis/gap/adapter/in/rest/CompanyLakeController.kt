package com.atis.gap.adapter.`in`.rest

import com.atis.gap.ports.repository.CompanyLakeRepository
import com.atis.gap.ports.usecases.CompanyLakeUseCase
import io.micronaut.http.annotation.*

@Controller("/company/lake")
open class CompanyLakeController(
    private val companyLakeUseCase: CompanyLakeUseCase
) {

    @Get("/health")
    fun isHealth() = true

    @Get
    fun listAll() = companyLakeUseCase.findAll()

//    @Get("/{?paginationCommand*}")
//    open fun list(@Valid paginationCommand: PaginationCommand) = companyLakeRepository.findAll(paginationCommand)
//
//    @Get("/{name}{?paginationCommand*}")
//    open fun listByName(
//        name: String,
//        @Valid paginationCommand: PaginationCommand
//    ) = companyLakeRepository.findByText(text = name, paginationCommand = paginationCommand)
//
//    @Post("/")
//    fun create(companyLake: CompanyLake) = companyLakeUseCase.createOrUpdate(companyLake)
//
//    @Put("/")
//    fun update(companyLake: CompanyLake) = companyLakeUseCase.createOrUpdate(companyLake)
//
//    @Delete("/{id}")
//    fun delete(id: ObjectId) = companyLakeUseCase.removeById(id)

}