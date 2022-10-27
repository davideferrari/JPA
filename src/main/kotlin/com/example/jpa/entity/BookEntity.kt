package com.example.jpa.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class BookEntity(
    @Id
    @Column(name = "id")
    var id: Long,
    @Column(name = "name")
    var name: String,
)