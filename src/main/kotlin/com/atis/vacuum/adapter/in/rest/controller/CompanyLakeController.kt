package com.atis.vacuum.adapter.`in`.rest.controller

import com.atis.vacuum.application.domain.enterprise.CompanyLake
import com.atis.vacuum.extensions.PaginationCommand
import com.atis.vacuum.ports.usecases.CompanyUseCase
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.validation.Valid

@Controller("/company/lake")
open class CompanyLakeController(
    private val companyUseCase: CompanyUseCase<CompanyLake>
) {

    @Get("/{?paginationCommand*}")
    open fun list(@Valid paginationCommand: PaginationCommand) = companyUseCase.findAll(paginationCommand)

}