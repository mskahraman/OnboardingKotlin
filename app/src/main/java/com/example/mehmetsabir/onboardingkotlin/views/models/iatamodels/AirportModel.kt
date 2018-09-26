package com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AirportModel {

    @Expose
    @SerializedName("code")
    private var code: String?=null

    @Expose
    @SerializedName("name")
    private var name:String? =null
}