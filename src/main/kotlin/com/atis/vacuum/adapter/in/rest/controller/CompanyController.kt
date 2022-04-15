package com.atis.vacuum.adapter.`in`.rest.controller

import com.atis.vacuum.adapter.`in`.mapper.toDomain
import com.atis.vacuum.adapter.`in`.rest.dto.CompanyDto
import com.atis.vacuum.application.domain.enterprise.Company
import com.atis.vacuum.extensions.PaginationCommand
import com.atis.vacuum.ports.usecases.CompanyUseCase
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.validation.Valid
import org.slf4j.LoggerFactory

@Controller("/company")
open class CompanyController(
    private val companyUseCase: CompanyUseCase<Company>
) {

    private val logger = LoggerFactory.getLogger(CompanyController::class.java)

    @Post
    fun register(@Body companyDto: CompanyDto) = companyDto.toDomain()
        .onSuccess {
//            companyService.createOrUpdate(it)
            logger.info("Empresa ${it.name} registrada")
        }
        .onFailure {
            logger.error("Erro ao registrar empresa", it)
        }

    @Get("/{?paginationCommand*}")
    open fun list(@Valid paginationCommand: PaginationCommand) = companyUseCase.findAll(paginationCommand)

}