package com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels

import com.google.gson.annotations.SerializedName

class SearchAirportResponse {

    @SerializedName("response")

    var airports : List<AirportModel>? = null
}