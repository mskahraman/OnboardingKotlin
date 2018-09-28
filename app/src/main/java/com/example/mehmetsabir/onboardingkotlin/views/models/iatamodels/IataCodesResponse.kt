package com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels

import com.google.gson.annotations.SerializedName

class IataCodesResponse {

    @SerializedName("airport")
    var listIataCodes: IataCodesofAirport? = null

}