package com.atis.vacuum.ports.repository

import org.reactivestreams.Publisher

interface CompanyRepository<T> {
    fun findAll(skip: Int, limit: Int): Publisher<T>
    fun findByName(name: String, skip: Int, limit: Int): Publisher<T>
//    fun manage(company: Company)

}