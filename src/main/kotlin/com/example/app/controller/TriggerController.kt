package com.example.app.controller

import com.example.app.TriggerService
import com.example.app.dto.Entities
import mu.KotlinLogging
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/trigger")
class TriggerController(val triggerService: TriggerService) {

    private val logger = KotlinLogging.logger {}

    @GetMapping("/member-info")
    fun memberInfo(
        @RequestParam userName: String,
        @RequestParam userPass: String
    ): Long {
        logger.info { userName }
        logger.info { userPass }

        return triggerService.memberInfo(userName, userPass)
    }

    @PostMapping
    fun subscribe(@RequestBody subscribeData: Entities.SubscribeData): Entities.SubscribeResponse {

        logger.info { subscribeData.toString() }

        return Entities.SubscribeResponse(triggerService.subscribe(subscribeData))
    }

    @DeleteMapping
    fun unsubscribe(@RequestBody unSubscribeData: Entities.UnSubscribeData): String {
        logger.info { unSubscribeData.id }

        triggerService.unsubscribe(unSubscribeData)

        return "success"
    }

    @GetMapping("/perform-list")
    fun performList(): Array<Entities.PlainUser> {

        return triggerService.performList()
    }
}