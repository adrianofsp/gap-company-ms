package com.atis.gap.ports.usecases

import com.atis.gap.extensions.annotations.State
import org.reactivestreams.Publisher

interface CompanyLakeUseCase {

    fun findAll()

}
//    : CrudUseCase<CompanyLake, ObjectId>