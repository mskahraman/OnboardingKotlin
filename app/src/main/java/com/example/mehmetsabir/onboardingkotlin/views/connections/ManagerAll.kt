package com.example.mehmetsabir.onboardingkotlin.views.connections

import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.FlightsDetailsResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.TokenResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels.HotelResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.IataCodesResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.SearchAirportResponse
import retrofit2.Call

class ManagerAll {

    private var restApiClient: RestApiClient? = null

    fun getAirports(apikey: String): Call<SearchAirportResponse> {

        restApiClient = RestApiClient(BaseUrl.URL_AIRPORTS)
        var x: Call<SearchAirportResponse> = restApiClient!!.getRestApi().getAirports(apikey)
        return x
    }

    fun getInfoTickets(type: String, clientid: String, clientsecret: String): Call<TokenResponse> {

        restApiClient = RestApiClient(BaseUrl.URL)
        var x: Call<TokenResponse> = restApiClient!!.getRestApi().getInfo(type, clientid, clientsecret)
        return x
    }

    fun FlightsDetailsResponse(header: String, origin: String, destination: String, departureDate: String, travelClass: String, nonStop: String)
            : Call<FlightsDetailsResponse> {

        restApiClient = RestApiClient(BaseUrl.URL)
        var x: Call<FlightsDetailsResponse> = restApiClient!!.getRestApi().getInfoFlight(header, origin, destination,
                departureDate, travelClass, nonStop)
        return x
    }

    fun getInfoHotels(header: String, latitude: Double, longitude: Double)
            : Call<HotelResponse> {

        restApiClient = RestApiClient(BaseUrl.URL)
        var x: Call<HotelResponse> = restApiClient!!.getRestApi().getInfoHotels(header, latitude, longitude)
        return x
    }

    fun getIataCodesForHotels(headerOfAPCAuth: String, headerAPCAuthSecret: String, iataCode: String)
            : Call<IataCodesResponse> {

        restApiClient = RestApiClient(BaseUrl.URL_AIRCODES)
        var x: Call<IataCodesResponse> = restApiClient!!.getRestApi().getInformationsToSendHotelApi(headerOfAPCAuth, headerAPCAuthSecret, iataCode)
        return x
    }


    companion object {

        private var ourInstance: ManagerAll? = null

        val instance: ManagerAll
            get() {
                if (ourInstance == null) {
                    ourInstance = ManagerAll()
                }
                return ourInstance!!
            }

    }
}