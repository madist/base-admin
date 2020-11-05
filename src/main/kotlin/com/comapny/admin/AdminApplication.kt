package com.comapny.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.company.admin"])
class AdminApplication

fun main(args: Array<String>) {
    runApplication<AdminApplication>(*args)
}
