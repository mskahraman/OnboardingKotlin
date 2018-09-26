package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PricingDetailPerAdultModel {

    @SerializedName("travelClass")
    @Expose
    var travelClass: String? = null
    @SerializedName("fareClass")
    @Expose
    var fareClass: String? = null
    @SerializedName("availability")
    @Expose
    var availability: Int? = null
    @SerializedName("fareBasis")
    @Expose
    var fareBasis: String? = null
}