package com.example.msg_assignment.model.data

import com.google.gson.annotations.SerializedName

data class User (
     @SerializedName("name")val userName: String
    , @SerializedName("login")val userId: String
    , @SerializedName("avatar_url")val userProfile: String
    , @SerializedName("bio") val userIntroduction: String
    , @SerializedName("followers")val userFollow: Int
    , @SerializedName("following")val userFollowing: Int
)