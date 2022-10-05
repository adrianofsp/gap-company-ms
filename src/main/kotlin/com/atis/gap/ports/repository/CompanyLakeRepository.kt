package com.atis.gap.ports.repository

import com.atis.gap.application.domain.enterprise.CompanyLake


interface CompanyLakeRepository: BaseRepository<CompanyLake> {

    fun findAll()

}