package com.example.app.repository

import com.example.app.entity.ColumnAnnotationTest
import org.springframework.data.jpa.repository.JpaRepository

interface ColumnAnnotationTestRepository: JpaRepository<ColumnAnnotationTest, Long> {
}