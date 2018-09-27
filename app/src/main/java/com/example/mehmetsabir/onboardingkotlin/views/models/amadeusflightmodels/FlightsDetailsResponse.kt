package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FlightsDetailsResponse {

        @SerializedName("data")
        @Expose
        var data: List<DataAirportModel>? = null
        @SerializedName("meta")
        @Expose
        var metaModel: MetaModel? = null

}