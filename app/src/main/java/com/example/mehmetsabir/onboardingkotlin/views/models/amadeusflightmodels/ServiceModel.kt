package com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ServiceModel {

    @SerializedName("segments")
    @Expose
    var segments : List<SegmentModel>? = null

}