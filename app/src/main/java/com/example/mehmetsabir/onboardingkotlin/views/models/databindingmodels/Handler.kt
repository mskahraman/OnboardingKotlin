package com.example.mehmetsabir.onboardingkotlin.views.models.databindingmodels

import android.content.Intent
import android.util.Log
import com.example.mehmetsabir.onboardingkotlin.views.views.activities.MainActivity
import com.example.mehmetsabir.onboardingkotlin.views.views.activities.SearchActivity
import com.example.mehmetsabir.onboardingkotlin.views.views.activities.SplashActivity


class Handler {

    private var listener: onGetDepartureDateClickListener?= null
    var mainActivity : MainActivity? =null



    fun selectDate(){

        Log.d("handler",  " selectDate çalıştı ");
        mainActivity = MainActivity()
        listener=mainActivity
       // listener?.onGetDateForSelect("sabir")

    }


    fun getInfo(a : String?){

        Log.d("handler", ""+a);
    }

    fun clickOrigin(){


        Log.d("handler", "origin");


    }

    interface onGetDepartureDateClickListener{

        fun onGetDateForSelect()
    }

}