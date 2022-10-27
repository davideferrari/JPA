package com.example.jpa.repo

import com.example.jpa.entity.BookEntity
import com.example.jpa.entity.ChapterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ChapterRepo : JpaRepository<ChapterEntity, Long> {

}