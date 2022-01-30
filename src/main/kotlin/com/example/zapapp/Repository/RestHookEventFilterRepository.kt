package com.example.zapapp.Repository

import com.example.zapapp.Entity.RestHookEventFilter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestHookEventFilterRepository: JpaRepository<RestHookEventFilter, Long> {

    fun deleteByRestHookUid(restHookUid: Long)
}