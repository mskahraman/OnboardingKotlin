package com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RoomModel {
    @SerializedName("type")
    @Expose
    var type : String? = null

    @SerializedName("description")
    @Expose
    var description : DescriptionModel? = null
}