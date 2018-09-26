package com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class IataCodesofAirport {

    @SerializedName("name")
    @Expose
    var name : String? = null
    @SerializedName("city")
    @Expose
    var city : String? = null
    @SerializedName("iata")
    @Expose
    var iata : String? = null
    @SerializedName("latitude")
    @Expose
    var latitude : String? = null
    @SerializedName("longitude")
    @Expose
    var longitude : String? = null
}