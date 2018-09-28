package com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OfferModel {

    @SerializedName("room")
    @Expose
    var room: RoomModel? =null
    @SerializedName("price")
    @Expose
    var price:  PriceModel? = null
}