package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MetaModel {
    @SerializedName("defaults")
    @Expose
    var defaultModel : DefaultModel? = null
}