package com.example.app.service

import com.example.app.dto.Entities
import com.example.app.entity.Member
import com.example.app.entity.RestHook
import com.example.app.entity.RestHookEventFilter
import com.example.app.repository.MemberRepository
import com.example.app.repository.RestHookEventFilterRepository
import com.example.app.repository.RestHookRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class TriggerService {

    private val logger = KotlinLogging.logger {}

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var restHookRepository: RestHookRepository

    @Autowired
    lateinit var restHookEventFilterRepository: RestHookEventFilterRepository

    fun memberInfo(userName: String, userPass: String): Long {

        val member: Member = memberRepository.findByUserNameAndPassword(userName, userPass)

        logger.info { member.memberUid }
        logger.info { member.userName }
        logger.info { member.password }

        return member.memberUid
    }

    fun subscribe(subscribeData: Entities.SubscribeData): Long? {

        val member: Member = memberRepository.findByUserName(subscribeData.username)

        val restHook = restHookRepository.save(
            RestHook(
                hookUrl = subscribeData.hookUrl,
                memberUid = member.memberUid,
                hookType = subscribeData.hookType,
                dataType = subscribeData.dataType,
                eventType = subscribeData.eventType,
                version = subscribeData.version
            )
        )

        val restHookEventFilter = restHookEventFilterRepository.save(
            RestHookEventFilter(
                restHookUid = restHook.restHookUid,
                filterName = "distributionList",
                filterValue = subscribeData.distributionListUid.toString(),
                filterFormat = "Long"
            )
        )

        logger.info { restHook.toString() }
        logger.info { restHookEventFilter.toString() }

        return restHook.restHookUid
    }

    fun unsubscribe(unSubscribeData: Entities.UnSubscribeData) {

        var restHook: RestHook = restHookRepository.findByRestHookUid(unSubscribeData.id.toLong())

        restHook.deleteFlag = 1
        restHook.deletedDate = Date.from(Instant.now())
        restHook = restHookRepository.save(restHook)

        logger.info { "Delete Success" }
        logger.info { restHook.toString() }
    }

    fun performList(): Array<Entities.PlainUser> {
        var user1 = Entities.PlainUser(
            "mingFirst11", "mingLast11",
            listOf(
                Entities.CustomData(1, "ming1"),
                Entities.CustomData(2, "ming2")
            )
        )
        var user2 = Entities.PlainUser(
            "mingThird12", "mingFourth12",
            listOf(
                Entities.CustomData(3, "ming3"),
                Entities.CustomData(4, "ming4")
            )
        )
        logger.info { user1 }

        return arrayOf(user1, user2)
    }
}