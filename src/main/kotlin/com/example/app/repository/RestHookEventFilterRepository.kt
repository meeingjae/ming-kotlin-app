package com.example.app.repository

import com.example.app.entity.RestHookEventFilter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestHookEventFilterRepository: JpaRepository<RestHookEventFilter, Long> {

    fun deleteByRestHookUid(restHookUid: Long)
}