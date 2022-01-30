package com.example.app.entity

import javax.persistence.*

@Entity
@Table(name = "E_MEMBER")
data class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    @SequenceGenerator(name = "MEMBER_SEQ", sequenceName = "MEMBER_SEQ", allocationSize = 1)
    @Column(name = "MEMBER_UID")
    var memberUid: Long,

    @Column(name = "USER_NAME")
    var userName: String,

    @Column(name = "PASSWORD")
    var password: String
)
