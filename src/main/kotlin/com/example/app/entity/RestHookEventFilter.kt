package com.example.app.entity

import javax.persistence.*

@Entity
@Table(name = "E_REST_HOOK_EVENT_FILTER")
class RestHookEventFilter(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REST_HOOK_EVENT_FILTER_SEQ")
    @SequenceGenerator(
        name = "REST_HOOK_EVENT_FILTER_SEQ",
        sequenceName = "REST_HOOK_EVENT_FILTER_SEQ",
        allocationSize = 1
    )
    @Column(name = "REST_HOOK_EVENT_FILTER_UID") var restHookEventFilterUid: Long? = 0,
    @Column(name = "REST_HOOK_UID") var restHookUid: Long?,
    @Column(name = "FILTER_NAME") var filterName: String,
    @Column(name = "FILTER_VALUE") var filterValue: String,
    @Column(name = "FILTER_FORMAT") var filterFormat: String
) {
    override fun toString(): String {
        return "RestHookEventFilter(restHookEventFilterUid=$restHookEventFilterUid, restHookUid=$restHookUid, filterName='$filterName', filterValue='$filterValue', filterFormat='$filterFormat')"
    }
}
