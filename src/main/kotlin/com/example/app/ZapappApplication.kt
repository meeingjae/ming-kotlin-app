package com.example.app

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ZapappApplication

fun main(args: Array<String>) {
    runApplication<ZapappApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
