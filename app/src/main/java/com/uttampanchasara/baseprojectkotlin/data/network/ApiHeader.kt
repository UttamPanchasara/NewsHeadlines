package com.uttampanchasara.baseprojectkotlin.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHeader @Inject
constructor(val protectedApiHeader: ProtectedApiHeader) {

    class ProtectedApiHeader(@field:Expose
                             @field:SerializedName("api_key")
                             var apiKey: String?, @field:Expose
                             @field:SerializedName("access_token")
                             var accessToken: String?) {

        @Expose
        @SerializedName("user_id")
        var userId: Long? = null

        init {
            this.userId = userId
        }
    }
}
