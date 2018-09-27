package com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HotelResponse {

    @SerializedName("data")
    @Expose
    var data: List<DataModel>? = null

}