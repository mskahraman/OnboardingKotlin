package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FlightSegmentModel {

    @SerializedName("departure")
    @Expose
    var departure: DepartureModel? = null

    @SerializedName("arrival")
    @Expose
    var arrival: ArrivalModel? = null

    @SerializedName("number")
    @Expose
    var number: String? = null


}