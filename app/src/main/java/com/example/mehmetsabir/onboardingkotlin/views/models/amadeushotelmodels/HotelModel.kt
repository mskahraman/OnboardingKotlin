package com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HotelModel {

    @SerializedName("type")
    @Expose
    var type: String?=null
    @SerializedName("hotelId")
    @Expose
    var hotelId: String?=null
    @SerializedName("chainCode")
    @Expose
    var chainCode: String?=null
    @SerializedName("dupeId")
    @Expose
    var dupeId: String?=null
    @SerializedName("name")
    @Expose
    var name : String?=null
    @SerializedName("cityCode")
    @Expose
    var cityCode: String?=null
    @SerializedName("latitude")
    @Expose
    var latitude: Double?=null
    @SerializedName("longitude")
    @Expose
    var longitude: Double?=null
}