package com.example.jpa

import com.example.jpa.entity.BookEntity
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
	@Test
	fun saveData() {
		repo.save(BookEntity(id=1,name="test"))
		assertEquals(1, repo.findAll().size)
	}


}
