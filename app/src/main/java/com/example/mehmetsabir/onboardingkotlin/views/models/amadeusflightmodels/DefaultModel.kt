package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DefaultModel {

    @SerializedName("nonStop")
    @Expose
    var nonStop : Boolean? =null
}