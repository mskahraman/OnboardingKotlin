package com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DescriptionModel {

    @SerializedName("lang")
    @Expose
    var lang: String? = null
    @SerializedName("text")
    @Expose
    var text: String? = null
}