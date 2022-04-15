package com.atis.vacuum.adapter.`in`.mapper

import com.atis.vacuum.adapter.`in`.rest.dto.CompanyDto
import com.atis.vacuum.application.domain.enterprise.Company

fun CompanyDto.toDomain() = runCatching {
    with(this) {
        var company = Company(name=name)
        company
    }
}