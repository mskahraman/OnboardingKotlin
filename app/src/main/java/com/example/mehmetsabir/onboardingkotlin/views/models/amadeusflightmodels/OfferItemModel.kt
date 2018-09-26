package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OfferItemModel {

    @SerializedName("services")
    @Expose
    var services: List<ServiceModel>? = null
    @SerializedName("price")
    @Expose
    var price: PriceAirportModel? = null

}