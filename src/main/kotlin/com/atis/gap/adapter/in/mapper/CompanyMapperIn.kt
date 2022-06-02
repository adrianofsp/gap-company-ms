package com.atis.gap.adapter.`in`.mapper

import com.atis.gap.adapter.`in`.rest.dto.CompanyDto
import com.atis.gap.application.domain.enterprise.Company

fun CompanyDto.toDomain() = runCatching {
    with(this) {
        var company = Company(name = name)
        company
    }
}