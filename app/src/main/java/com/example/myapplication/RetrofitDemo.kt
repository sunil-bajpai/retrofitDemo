package com.example.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RetrofitDemo {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("worth")
    @Expose
    var worth: String? = null

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("instructions")
    @Expose
    var instructions: String? = null

    @SerializedName("open_giveaway_url")
    @Expose
    var openGiveawayUrl: String? = null

    @SerializedName("published_date")
    @Expose
    var publishedDate: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("platforms")
    @Expose
    var platforms: String? = null

    @SerializedName("end_date")
    @Expose
    var endDate: String? = null

    @SerializedName("users")
    @Expose
    var users: Int? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("gamerpower_url")
    @Expose
    var gamerpowerUrl: String? = null

    @SerializedName("open_giveaway")
    @Expose
    var openGiveaway: String? = null

}