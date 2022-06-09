package com.atis.gap.ports.usecases

import com.atis.gap.application.domain.enterprise.CompanyLake
import org.bson.types.ObjectId

interface CompanyLakeUseCase: CrudUseCase<CompanyLake, ObjectId>