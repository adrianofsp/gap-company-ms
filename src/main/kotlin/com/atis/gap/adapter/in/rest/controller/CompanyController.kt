package com.atis.gap.adapter.`in`.rest.controller

import com.atis.gap.application.domain.enterprise.Company
import com.atis.gap.extensions.PaginationCommand
import com.atis.gap.ports.repository.CompanyRepository
import com.atis.gap.ports.usecases.CompanyUseCase
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.slf4j.LoggerFactory
import javax.validation.Valid

//@Controller("/company")
//open class CompanyController(
//    private val companyUseCase: CompanyUseCase,
//    private val companyRepository: CompanyRepository
//) {
//
//    private val logger = LoggerFactory.getLogger(CompanyController::class.java)
//
//    @Get("/{?paginationCommand*}")
//    open fun list(@Valid paginationCommand: PaginationCommand) = companyRepository.findAll(paginationCommand)
//
//    @Get("/{name}{?paginationCommand*}")
//    open fun listByName(
//        name: String,
//        @Valid paginationCommand: PaginationCommand
//    ) = companyRepository.findByText(text = name, paginationCommand = paginationCommand)
//
//    fun create(company: Company) = companyUseCase.manage(company)
//
//    fun update(company: Company) = companyUseCase.manage(company)
//
//    fun delete(id: Int) = companyUseCase.manage(id)
//
////    @Post
////    fun register(@Body companyDto: CompanyDto) = companyDto.toDomain()
////        .onSuccess {
//////            companyService.createOrUpdate(it)
////            logger.info("Empresa ${it.name} registrada")
////        }
////        .onFailure {
////            logger.error("Erro ao registrar empresa", it)
////        }
////
////    @Get("/{?paginationCommand*}")
////    open fun list(@Valid paginationCommand: PaginationCommand) = companyUseCase.findAll(paginationCommand)
//
//}