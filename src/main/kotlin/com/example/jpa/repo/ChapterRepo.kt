package com.example.jpa.repo

import com.example.jpa.entity.BookEntity
import com.example.jpa.entity.ChapterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import javax.transaction.Transactional

interface ChapterRepo : JpaRepository<ChapterEntity, Long> {

    @Transactional
    @Modifying
    @Query("INSERT INTO CHAPTER(chapter_id, name, book_id) VALUES (:chapterId,'run new!', :bookId)", nativeQuery = true)
    fun insertNew(chapterId: Long, bookId: Long)

}