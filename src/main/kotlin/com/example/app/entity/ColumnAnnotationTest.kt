package com.example.app.entity

import javax.persistence.*

@Entity
@Table(name = "COLUMN_ANNOTATION_TEST")
class ColumnAnnotationTest(

    /**
     * Column 어노테이션 제거
     * 결과 : 각 field명을 Default 컬럼명으로 매핑해서 사용
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLUMN_ANNOTATION_SEQ")
    @SequenceGenerator(name = "COLUMN_ANNOTATION_SEQ", sequenceName = "COLUMN_ANNOTATION_SEQ", allocationSize = 1)
    var thisId: Long = 0,
    var name: String = "",
)
