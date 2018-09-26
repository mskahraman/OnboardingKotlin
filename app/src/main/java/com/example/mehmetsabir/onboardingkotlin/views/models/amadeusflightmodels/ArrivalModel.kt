package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArrivalModel {

    @SerializedName("iataCode")
    @Expose
    var iataCode: String? = null
    @SerializedName("terminal")
    @Expose
    var terminal: String? = null
    @SerializedName("at")
    @Expose
    var at: String? = null
}