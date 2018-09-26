package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PriceAirportModel {

    @SerializedName("total")
    @Expose
    var total: String? = null
    @SerializedName("totalTaxes")
    @Expose
    var totalTaxes: String? = null

}