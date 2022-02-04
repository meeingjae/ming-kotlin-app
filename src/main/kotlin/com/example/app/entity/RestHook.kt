package com.example.app.entity

import org.springframework.data.annotation.CreatedDate
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "E_REST_HOOK")
data class RestHook(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REST_HOOK_SEQ")
    @SequenceGenerator(name = "REST_HOOK_SEQ", sequenceName = "REST_HOOK_SEQ", allocationSize = 1)
    @Column(name = "REST_HOOK_UID") var restHookUid: Long? = 0,
    @Column(name = "HOOK_URL") var hookUrl: String,
    @Column(name = "MEMBER_UID") var memberUid: Long,
    @Column(name = "HOOK_TYPE") var hookType: String,
    @Column(name = "DATA_TYPE") var dataType: String,
    @Column(name = "EVENT_TYPE") var eventType: String,
    @Column(name = "CREATED_DATE") @CreatedDate var createdDate: Date? = Date.from(Instant.now()),
    @Column(name = "DELETE_FLAG") var deleteFlag: Int? = 0,
    @Column(name = "DELETED_DATE") var deletedDate: Date? = null,
    @Column(name = "VERSION") var version: String
) {
    override fun toString(): String {
        return "RestHook(restHookUid=$restHookUid, hookUrl='$hookUrl', memberUid=$memberUid, hookType='$hookType', dataType='$dataType', eventType='$eventType', createdDate=$createdDate, deleteFlag=$deleteFlag, deletedDate=$deletedDate)"
    }
}
