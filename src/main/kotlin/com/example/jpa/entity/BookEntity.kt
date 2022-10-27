package com.example.jpa.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
class BookEntity(
    @Id
    @Column(name = "book_id")
    var id: Long,
    @Column(name = "title")
    var title: String,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name="book_id")
    val chapters : List<ChapterEntity>
)