package com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AirportModel {

    @Expose
    @SerializedName("code")
    var code: String? = null

    @Expose
    @SerializedName("name")
    var name: String? = null
}