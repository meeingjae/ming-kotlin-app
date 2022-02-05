package com.example.app.entity

import javax.persistence.*

@Entity //@Data 사용은 지양. toString()이 자동 생성되어, 순환참조 문제를 야기할 수 있음
@Table(name = "E_MEMBER")
data class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    @SequenceGenerator(name = "MEMBER_SEQ", sequenceName = "MEMBER_SEQ", allocationSize = 1)
    @Column(name = "MEMBER_UID") var memberUid: Long, //TODO: Column Annocation 필요 없나?? 확인
    @Column(name = "USER_NAME") var userName: String,
    @Column(name = "PASSWORD") var password: String
)
