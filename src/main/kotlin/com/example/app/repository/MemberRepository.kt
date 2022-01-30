package com.example.app.repository

import com.example.app.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: JpaRepository<Member, Long> {

    fun findByUserNameAndPassword(username: String, password: String): Member
    fun findByUserName(username: String): Member
    fun existsByUserNameAndPassword(username: String, password: String): Boolean
}