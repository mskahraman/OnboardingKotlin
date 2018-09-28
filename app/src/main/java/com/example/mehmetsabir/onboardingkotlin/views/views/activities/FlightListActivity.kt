package com.example.mehmetsabir.onboardingkotlin.views.views.activities

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.mehmetsabir.onboardingkotlin.R
import com.example.mehmetsabir.onboardingkotlin.views.connections.BaseUrl
import com.example.mehmetsabir.onboardingkotlin.views.connections.ManagerAll
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.DataAirportModel
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.FlightsDetailsResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.TokenResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.AirportModel
import com.example.mehmetsabir.onboardingkotlin.views.views.adapters.FlightListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class FlightListActivity : AppCompatActivity() {

    private var listView: ListView? = null
    private val flightsDetailsResponse = ArrayList<DataAirportModel>()
    private var adp: FlightListAdapter? = null
    private var header: String? = null
    private var origin: String? = null
    private var destination: String? = null
    private var departureDate: String? = null
    private var travelClass: String? = null
    private var passengersCount: Int? = null
    private var nonStopOrNot: Boolean? = null
    private var bundle: Bundle? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_list)
        listView = findViewById<ListView>(R.id.listviewFlightList)
        getAccessTokenWithResponse()
    }


    private fun getAccessTokenWithResponse() {

        progressDialog = ProgressDialog(this@FlightListActivity)
        progressDialog?.setTitle("Bilgi Ekranı")
        progressDialog?.setMessage("Havaalanları Yükleniyor , Lütfen Bekleyiniz ...")
        progressDialog?.setCancelable(true)
        progressDialog?.show()

        ManagerAll.instance.getInfoTickets("client_credentials", BaseUrl.CLIENT_ID, BaseUrl.CLIENT_SECRET)
                .enqueue(object : Callback<TokenResponse> {
                    override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {

                        if (response.isSuccessful) {

                            header = "Bearer " + response.body()!!.accessToken.toString()
                            getFlightsResponse()
                        }
                    }

                    override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                        Log.e("servis hatası", t.localizedMessage)
                    }
                })

    }

    private fun getFlightsResponse() {

        bundle = intent.extras
        origin = bundle?.getString("origin")
        destination = bundle?.getString("destination")
        departureDate = bundle?.getString("departureDate")
        travelClass = bundle?.getString("travelClass")
        passengersCount = bundle?.getInt("passengersCount")
        nonStopOrNot = bundle?.getBoolean("nonStopOrNot")

        ManagerAll.instance.FlightsDetailsResponse(header!!, origin!!, destination!!, departureDate!!,
                travelClass!!, nonStopOrNot!!).enqueue(object : Callback<FlightsDetailsResponse> {

            override fun onResponse(call: Call<FlightsDetailsResponse>, response: Response<FlightsDetailsResponse>) {

                if (response.isSuccessful) {

                    flightsDetailsResponse?.clear()

                    flightsDetailsResponse.addAll(response.body()?.data!!)
                    adp = FlightListAdapter(this@FlightListActivity, flightsDetailsResponse, this@FlightListActivity, passengersCount!!)
                    listView?.adapter = adp
                    adp?.notifyDataSetChanged()
                }

                progressDialog?.cancel()

            }

            override fun onFailure(call: Call<FlightsDetailsResponse>, t: Throwable) {

            }
        })

    }

}
