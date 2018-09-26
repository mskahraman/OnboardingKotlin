package com.example.mehmetsabir.onboardingkotlin.views.views.activities

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import com.example.mehmetsabir.onboardingkotlin.R
import com.example.mehmetsabir.onboardingkotlin.databinding.ActivityMainBinding
import com.example.mehmetsabir.onboardingkotlin.views.models.databindingmodels.Handler
import com.example.mehmetsabir.onboardingkotlin.views.models.databindingmodels.InformationsOfFlight
import java.text.DateFormat
import java.util.*

class MainActivity() : AppCompatActivity(), Handler.onGetDepartureDateClickListener {


    private var binding : ActivityMainBinding?=null
    var mcurrentTime: Calendar?=null
    var datePicker : DatePicker?=null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding!!.handlerGettingInfo = Handler()


    }

    private fun getDate() {

        Log.d("handler", "Gelen deger: ");

       /* var info  = InformationsOfFlight()
        info.departureDate="ss"
        binding!!.flight=info
*/



    }
    override fun onGetDateForSelect() {
       getDate()
    }


}
