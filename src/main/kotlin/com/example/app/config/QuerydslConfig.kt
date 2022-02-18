package com.example.app.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
open class QuerydslConfig(@PersistenceContext val entityManager: EntityManager) {

    @Bean
    open fun jpaQueryFactory() = JPAQueryFactory(entityManager)
}