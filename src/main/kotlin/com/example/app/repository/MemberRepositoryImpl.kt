package com.example.app.repository

//import com.example.app.entity.Member
//import com.example.app.entity.QMember
//import com.querydsl.jpa.impl.JPAQueryFactory
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Repository

//@Repository
//class MemberRepositoryImpl @Autowired constructor(
//    private val jpaQueryFactory: JPAQueryFactory
//) {

//    fun findAll(): List<Member> {
//
//        //TODO: package 경로 못 찾는 문제
//        val memberList: List<Member> = jpaQueryFactory.selectFrom(QMember.member)
//            .fetch()
//
//        return memberList
//    }
//}