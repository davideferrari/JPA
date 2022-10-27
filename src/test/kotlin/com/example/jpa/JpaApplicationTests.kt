package com.example.jpa

import com.example.jpa.entity.BookEntity
import com.example.jpa.entity.ChapterEntity
import com.example.jpa.repo.BookRepo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JpaApplicationTests(

) {
    @Autowired
    private lateinit var repo: BookRepo

    private val book1 = BookEntity(
        id = 1, title = "test",
        chapters = listOf(ChapterEntity(chapter_id = 1, name = "run!"))
    )

    @Test
    fun saveData() {
        repo.save(book1)
        //assertEquals(1, repo.findAll().size)

        println("--------------------")
        repo.findByName("test")
        

    }


}
