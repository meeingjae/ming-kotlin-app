package com.example.app.repository

import com.example.app.entity.RestHook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestHookRepository: JpaRepository<RestHook, Long> {

    fun findByRestHookUid(restHook: Long): RestHook
}