package com.example.app.dto

class Entities {

    class User(
        var firstName: String,
        var lastName: String,
        var description: String,
        var id: Long? = null
    )

    class PlainUser(
        var firstName: String,
        var lastName: String,
        var customData: List<CustomData>
    )

    class SubscribeData(
        var hookUrl: String,
        var username: String,
        var hookType: String,
        var dataType: String,
        var eventType: String,
        var distributionListUid: Long,
        var version: String
    ) {
        override fun toString(): String {
            return "SubscribeData(hookUrl='$hookUrl', username='$username', hookType='$hookType', dataType='$dataType', eventType='$eventType', distributionListUid=$distributionListUid)"
        }
    }

    class SubscribeResponse(
        var id: Long?
    )

    class UnSubscribeData(
        var id: String
    )


    class CustomData(
        var id: Long,
        var name: String
    )

}