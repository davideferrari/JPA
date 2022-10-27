package com.example.jpa.entity

import javax.persistence.*

@Entity
@Table(name="book")
class BookEntity(
    @Id
    @Column(name = "book_id")
    var id: Long,
    @Column(name = "title")
    var title: String,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name="book_id")
    val chapters : Set<ChapterEntity>
)