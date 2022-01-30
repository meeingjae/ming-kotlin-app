package com.example.zapapp

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZapappApplication

fun main(args: Array<String>) {
    runApplication<ZapappApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
