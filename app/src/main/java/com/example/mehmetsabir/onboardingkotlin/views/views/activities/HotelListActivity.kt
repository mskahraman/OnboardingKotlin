package com.example.mehmetsabir.onboardingkotlin.views.views.activities

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.mehmetsabir.onboardingkotlin.R
import com.example.mehmetsabir.onboardingkotlin.views.connections.BaseUrl
import com.example.mehmetsabir.onboardingkotlin.views.connections.ManagerAll
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.TokenResponse
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels.DataModel
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels.HotelResponse
import com.example.mehmetsabir.onboardingkotlin.views.views.adapters.HotelsListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class HotelListActivity : AppCompatActivity() {


    private var header: String? = null
    private var bundle: Bundle? = null
    private var latitudeValue: Double? = null
    private var longitudeValue:Double? = null
    private var hotelAdapter: HotelsListAdapter? = null
    private val listOfHotels = ArrayList<DataModel>()
    private var lvHotelList: ListView? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_list)
        getHotels()
    }

    private fun getHotels() {

        progressDialog = ProgressDialog(this)
        progressDialog?.setTitle("Bilgi Ekranı")
        progressDialog?.setMessage("Yakınlardaki Oteller Yükleniyor , Lütfen Bekleyiniz ...")
        progressDialog?.setCancelable(true)
        progressDialog?.show()

        ManagerAll.instance.getInfoTickets("client_credentials", BaseUrl.CLIENT_ID, BaseUrl.CLIENT_SECRET).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                if (response.isSuccessful()) {

                    bundle = intent.extras
                    latitudeValue = bundle?.getDouble("latitude")
                    longitudeValue = bundle?.getDouble("longitude")

                    header = "Bearer " + response.body()?.accessToken.toString()
                    ManagerAll.instance.getInfoHotels(header!!, latitudeValue!!, longitudeValue!!).enqueue(object : Callback<HotelResponse> {
                        override fun onResponse(call: Call<HotelResponse>, response: Response<HotelResponse>) {
                            if (response.isSuccessful()) {

                                listOfHotels.addAll(response.body()?.data!!)
                                hotelAdapter = HotelsListAdapter(listOfHotels, this@HotelListActivity)
                                lvHotelList?.setAdapter(hotelAdapter)
                                hotelAdapter?.notifyDataSetChanged()
                            }

                            progressDialog?.cancel()
                        }

                        override fun onFailure(call: Call<HotelResponse>, t: Throwable) {

                        }
                    })

                } else {
                    Toast.makeText(this@HotelListActivity, "hata", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {

            }
        })
    }
}
