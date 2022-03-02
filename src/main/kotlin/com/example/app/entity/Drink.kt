package com.example.app.entity

import javax.persistence.*

@Entity
@Table(name = "E_DRINK")
class Drink(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRINK_SEQ")
    @SequenceGenerator(name = "DRINK_SEQ", sequenceName = "DRINK_SEQ", allocationSize = 1)
    @Column(name = "DRINK_UID") var drinkUid: Long = 0,
    @Column(name = "DRINK_NAME") var drinkName: String = "",
    @Column(name = "DRINK_PRICE") var drinkPrice: String = "",
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAFE_UID")
    var cafe: Cafe
)

