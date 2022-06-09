package com.atis.gap
import com.atis.gap.adapter.`in`.rest.controller.CompanyLakeController
import com.atis.gap.application.domain.enterprise.CompanyLake
import com.atis.gap.extensions.PaginationCommand
import com.atis.gap.mocks.mock
import com.atis.gap.ports.repository.CompanyLakeRepository
import com.atis.gap.ports.usecases.CompanyLakeUseCase
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.extension.ExtendWith

@MicronautTest
@ExtendWith(MockKExtension::class)
class GapCompanyMsTest(
    @Client("/") private val httpClient: HttpClient,
): AnnotationSpec() {

    @MockK lateinit var companyLakeUseCase: CompanyLakeUseCase
    @MockK lateinit var companyLakeRepository: CompanyLakeRepository

    private lateinit var companyLakeController: CompanyLakeController

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        companyLakeController = CompanyLakeController(companyLakeUseCase, companyLakeRepository)
    }

    @Test
    fun `should `() {

//        every {
//            companyLakeController.isHealth()
////            companyLakeController.list(any())
//        } returns false
//
//        companyLakeController.isHealth() shouldBe false

//        var response = httpClient.toBlocking().exchange("/company/lake/health", Boolean::class.java)

//        response.body() shouldBe false

    }

    @Test
    fun `should manage on companyUseCase be invoked`() {
        val companyLake = companyLakeRepository.mock()

        every {
            companyLakeUseCase.manage<CompanyLake>(any())
        } returns companyLake

        companyLakeController.create(companyLake)

        verify(exactly = 1) {
            companyLakeUseCase.manage<CompanyLake>(
                match {
                    it.name == companyLake.name &&
                    it.postalCode == companyLake.postalCode
                }
            )
        }
    }






}
