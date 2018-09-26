package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataAirportModel {

    @SerializedName("offerItems")
    @Expose
    var offerItems: List<OfferItemModel>? = null
}