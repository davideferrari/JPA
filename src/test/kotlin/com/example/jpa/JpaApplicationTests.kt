package com.example.jpa

import com.example.jpa.entity.BookEntity
import com.example.jpa.entity.ChapterEntity
import com.example.jpa.repo.BookRepo
import com.example.jpa.repo.ChapterRepo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.system.measureTimeMillis

@SpringBootTest
class JpaApplicationTests(

) {
    @Autowired
    private lateinit var bookRepo: BookRepo

    @Autowired
    private lateinit var chapterRepo: ChapterRepo


    @BeforeEach
    private fun init() {
        bookRepo.deleteAll()
        chapterRepo.deleteAll()
    }

    @Test
    @Disabled
    fun `try to add a new chapter with native query`() {
        val book1 = BookEntity(
            id = 1, title = "test",
            chapters = setOf(
                ChapterEntity(chapter_id = 1, name = "run!"),
                ChapterEntity(chapter_id = 2, name = "run faster!")
            )
        )

        bookRepo.save(book1)

        println("--------------------")
        val book = bookRepo.findByName("test")

        chapterRepo.insertNew(book.id)

        val bookAfter = bookRepo.findByNameWithChildren("test")

    }

    @Test
    fun `TEST current situation of add chapter`() {
        val book1 = BookEntity(
            id = 1, title = "test",
            chapters = (1..500).map { ChapterEntity(chapter_id = it.toLong(), name = "run!$it") }.toSet()
        )

        bookRepo.save(book1)

        println("--------------------")
        val time = measureTimeMillis {
            val book = bookRepo.findByNameWithChildren("test")

           //book.chapters.toMutableList().add(ChapterEntity(501, name = "ops"))
            bookRepo.save(BookEntity(
                id = book.id,
                title = book.title,
                chapters = book.chapters.toMutableSet()+ChapterEntity(501, name = "ops")
            ))
        }

        print("REQUESTED $time ms")

    }

    @Test
    @Disabled
    fun `TEST try to add a new chapter with native query`() {
        val book1 = BookEntity(
            id = 1, title = "test",
            chapters = (1..500).map { ChapterEntity(chapter_id = it.toLong(), name = "run!$it") }.toSet()
        )

        bookRepo.save(book1)

        println("--------------------")
        val time = measureTimeMillis {
            val book = bookRepo.findByName("test")
            chapterRepo.insertNew(book.id)
        }

        print("REQUESTED $time ms")
    }


}
