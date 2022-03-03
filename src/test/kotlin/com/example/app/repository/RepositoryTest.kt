package com.example.app.repository

import com.example.app.entity.Cafe
import com.example.app.entity.ColumnAnnotationTest
import com.example.app.entity.Drink
import com.example.app.entity.Member
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
open class RepositoryTest @Autowired constructor(
    val memberRepository: MemberRepository,
    val restHookRepository: RestHookRepository,
    val restHookEventFilterRepository: RestHookEventFilterRepository,
    val columnAnnotationTestRepository: ColumnAnnotationTestRepository,
    val cafeRepository: CafeRepository,
    val drinkRepository: DrinkRepository
//    val memberRepositoryImpl: MemberRepositoryImpl
) {

    @Test
    fun `Member Repository Sequence Test`() {

        memberRepository.save(Member(10000L, "testName", "testPassword"))
        val testMember = memberRepository.findByUserName("testName")
        assert(testMember.userName == "testName" && testMember.memberUid == 1L) // SequenceGenerate
    }

    @Test
    fun `Column Annotation Default Name Test`() {

        columnAnnotationTestRepository.save(ColumnAnnotationTest(1L, "testname"))
        val test = columnAnnotationTestRepository.findById(1L)

        if (test.isEmpty) {
            assert(false)
        } else {
            val existTest = test.get()
            assert(existTest.thisId == 1L && existTest.name == "testname")
            println("thisId : " + existTest.thisId + ", name : " + existTest.name)
        }
    }

    @Test
    fun `one to many test`() {

        val americano:Drink = drinkRepository.save(Drink(drinkUid = 1L, drinkName = "americano", drinkPrice = "1000", null))
        val icetea:Drink = drinkRepository.save(Drink(drinkUid = 2L, drinkName = "icetea", drinkPrice = "1500", null))

        cafeRepository.save(
            Cafe(
                cafeUid = 1L,
                cafeName = "starbucks",
                drinks = listOf<Drink>(
                    americano,
                    icetea
                ) as MutableList<Drink>
            )
        )

        val cafe: Cafe = cafeRepository.findByCafeUid(1L)

        assert(cafe.drinks.size == 2)
    }
}