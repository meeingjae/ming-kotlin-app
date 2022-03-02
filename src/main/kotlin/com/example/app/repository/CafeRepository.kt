package com.example.app.repository

import com.example.app.entity.Cafe
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CafeRepository : JpaRepository<Cafe, Long> {

    fun findByCafeUid(cafeUid: Long): Cafe
}