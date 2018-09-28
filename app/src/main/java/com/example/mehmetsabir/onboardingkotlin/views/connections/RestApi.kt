package com.example.mehmetsabir.onboardingkotlin.views.connections

import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.FlightsDetailsResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.TokenResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels.HotelResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.IataCodesResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.SearchAirportResponse
import retrofit2.Call
import retrofit2.http.*

interface RestApi {

    @FormUrlEncoded
    @POST("security/oauth2/token")
    fun getInfo(@Field("grant_type") grant_type: String, @Field("client_id") client_id: String,
                @Field("client_secret") client_secret: String): Call<TokenResponse>


    @GET("shopping/flight-offers")
    fun getInfoFlight(@Header("Authorization") header: String,
                      @Query("origin") origin: String,
                      @Query("destination") destination: String,
                      @Query("departureDate") departureDate: String,
                      @Query("travelClass") travelClass: String,
                      @Query("nonStop") nonStop: Boolean): Call<FlightsDetailsResponse>

    @GET("shopping/hotel-offers")
    fun getInfoHotel(@Header("Authorization") header: String,
                     @Query("latitude") latitude: Double,
                     @Query("longitude") longitude: Double): Call<HotelResponse>


    @GET("airports")
    fun getAirports(@Query("api_key") api_key: String): Call<SearchAirportResponse>


    @GET("single")
    fun getInformationsToSendHotelApi(@Header("APC-Auth") headerOfAPCAuth: String,
                                      @Header("APC-Auth-Secret") headerAPCAuthSecret: String,
                                      @Query("iata") iataCode: String): Call<IataCodesResponse>

}