package com.example.app.repository

import com.example.app.entity.Member
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
open class RepositoryTest @Autowired constructor(
    val memberRepository: MemberRepository,
    val restHookRepository: RestHookRepository,
    val restHookEventFilterRepository: RestHookEventFilterRepository
) {

    @Test
    fun `Member Repository Sequence Test`() {

        memberRepository.save(Member(10000L,"testName","testPassword"))
        val testMember = memberRepository.findByUserName("testName")
        assert(testMember.userName == "testName" && testMember.memberUid == 1L) // SequenceGenerate
    }
}