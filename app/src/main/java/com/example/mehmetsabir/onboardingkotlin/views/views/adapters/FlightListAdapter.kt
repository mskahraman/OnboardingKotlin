package com.example.mehmetsabir.onboardingkotlin.views.views.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mehmetsabir.onboardingkotlin.R
import com.example.mehmetsabir.onboardingkotlin.views.connections.ManagerAll
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeusflightmodels.DataAirportModel
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.IataCodesResponse
import com.example.mehmetsabir.onboardingkotlin.views.views.activities.HotelListActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlightListAdapter(context: Context,list : ArrayList<DataAirportModel> ,activity: Activity,countOfPassengers : Int)
    : BaseAdapter(){

    private var list= ArrayList<DataAirportModel>()
    private var context: Context? = null
    private var txtFlightOrigin: TextView? = null
    private var txtFlightDestination:TextView? = null
    private var txtFlightDateofGoing:TextView? = null
    private var txtFlightClass:TextView? = null
    private var txtFlightOfPrice:TextView? = null
    private var txtFlightNonStop:TextView? = null
    private var btnChooseFlight: Button? = null
    private var activity: Activity? = null
    private var countOfPassengers: Int? = null
    private var headerOfAPCAuth = "536b7a1254"
    private var headerAPCAuthSecret = "4d7cc5efb9ea6a0"

    init {
        this.context=context
        this.list = list
        this.activity = activity
        this.countOfPassengers = countOfPassengers
    }


    override fun getView(position: Int, convertView : View?, parent: ViewGroup): View? {
        val view: View?

        view = LayoutInflater.from(context).inflate(R.layout.flight_list_adapter, parent, false)

        txtFlightOrigin = view.findViewById(R.id.flightOrigin) as TextView
        txtFlightDestination = view.findViewById(R.id.flightDestination) as TextView
        txtFlightDateofGoing = view.findViewById(R.id.flightDateofGoing) as TextView
        txtFlightOfPrice = view.findViewById(R.id.flightOfPrice) as TextView
        txtFlightClass = view.findViewById(R.id.flightClass) as TextView
        btnChooseFlight = view.findViewById(R.id.chooseFlight) as Button
        txtFlightNonStop = view.findViewById(R.id.nonStopOrNot) as TextView


        val segmentModel = list.get(position).offerItems?.get(0)?.services?.get(0)?.segments?.get(0)

        txtFlightOrigin?.text = segmentModel?.flightSegment?.departure?.iataCode

        txtFlightDestination?.text = segmentModel?.flightSegment?.arrival?.iataCode

        txtFlightDateofGoing?.text = segmentModel?.flightSegment?.departure?.at

        txtFlightClass?.text = segmentModel?.pricingDetailPerAdult?.travelClass

        txtFlightOfPrice?.text = (countOfPassengers.toString() + " Yolcu: " + countOfPassengers + " * " +
                list.get(position).offerItems?.get(0)?.price?.total + " = " +
                java.lang.Double.parseDouble(list.get(position).offerItems?.get(0)?.price?.total) * countOfPassengers!!)


        btnChooseFlight?.setOnClickListener(View.OnClickListener { getInformationsOfLocations() })

        return view
    }

    fun getInformationsOfLocations(){

        ManagerAll.instance.getIataCodesForHotels(headerOfAPCAuth,
                headerAPCAuthSecret, txtFlightDestination?.text.toString()).enqueue(object : Callback<IataCodesResponse> {
            override fun onResponse(call: Call<IataCodesResponse>, response: Response<IataCodesResponse>) {

                if (response.isSuccessful()) {

                    val intent = Intent(activity, HotelListActivity::class.java)
                    intent.putExtra("latitude", java.lang.Double.parseDouble(response.body()!!.listIataCodes?.latitude))
                    intent.putExtra("longitude", java.lang.Double.parseDouble(response.body()!!.listIataCodes?.longitude))
                    activity?.startActivity(intent)

                }
            }

            override fun onFailure(call: Call<IataCodesResponse>, t: Throwable) {}
        })


    }

    override fun getItem(position: Int): DataAirportModel {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
       return list.size
    }
}