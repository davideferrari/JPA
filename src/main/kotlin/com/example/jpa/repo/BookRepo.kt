package com.example.jpa.repo

import com.example.jpa.entity.BookEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepo : JpaRepository<BookEntity, Long> {
}