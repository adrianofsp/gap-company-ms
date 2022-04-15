package com.atis.vacuum

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.atis.vacuum")
		.start()
}

