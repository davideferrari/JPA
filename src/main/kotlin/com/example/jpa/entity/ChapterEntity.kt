package com.example.jpa.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class ChapterEntity(
    @Id
    @Column(name = "chapter_id")
    var chapter_id: Long,
    @Column(name = "name")
    var name: String,
)