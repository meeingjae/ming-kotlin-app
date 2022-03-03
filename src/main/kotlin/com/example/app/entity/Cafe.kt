package com.example.app.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "E_CAFE")
class Cafe(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAFE_SEQ")
    @SequenceGenerator(name = "CAFE_SEQ", sequenceName = "CAFE_SEQ", allocationSize = 1)
    @Column(name = "CAFE_UID") var cafeUid: Long = 0,
    @Column(name = "CAFE_NAME") var cafeName: String = "",
    @Column(name = "OWNER_UID") var ownerUid: Long = 0,

    @OneToMany(mappedBy = "cafe")
    var drinks: MutableList<Drink> = mutableListOf()
)