package com.example.app.repository

import com.example.app.entity.Drink
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DrinkRepository : JpaRepository<Drink, Long> {
}