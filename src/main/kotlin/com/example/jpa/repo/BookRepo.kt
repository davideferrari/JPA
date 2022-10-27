package com.example.jpa.repo

import com.example.jpa.entity.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BookRepo : JpaRepository<BookEntity, Long> {

    @Query("SELECT b FROM BookEntity b LEFT JOIN FETCH b.chapters WHERE b.title=:title")
    fun findByNameWithChildren(title: String) : BookEntity
    @Query("SELECT b FROM BookEntity b WHERE b.title=:title ")
    fun findByName(title : String) : BookEntity
}