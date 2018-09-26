package com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PriceModel {

    @SerializedName("currency")
    @Expose
    var currency: String? = null
    @SerializedName("total")
    @Expose
    var total: String? = null

}