package com.example.zapapp.Repository

import com.example.zapapp.Entity.RestHook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestHookRepository: JpaRepository<RestHook, Long> {

    fun findByRestHookUid(restHook: Long): RestHook
}