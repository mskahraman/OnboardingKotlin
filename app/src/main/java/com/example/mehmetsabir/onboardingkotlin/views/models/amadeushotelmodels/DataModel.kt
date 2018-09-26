package com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataModel {

    @SerializedName("type")
    @Expose
    var type : String?=null
    @SerializedName("hotel")
    @Expose
    var hotel : String?=null
    @SerializedName("available")
    @Expose
    var available : String?=null
    @SerializedName("offers")
    @Expose
    var offers: List<OfferModel>?  = null;
}