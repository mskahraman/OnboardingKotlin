package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SegmentModel {

    @SerializedName("flightSegment")
    @Expose
    var flightSegment: FlightSegmentModel? = null
    @SerializedName("pricingDetailPerAdult")
    @Expose
    var pricingDetailPerAdult : PricingDetailPerAdultModel? = null
}