package com.example.mehmetsabir.onboardingkotlin.views.models.databindingmodels

import android.view.View


class Handler() {

    fun onClickSelectDate() {

    }


    fun onClickOrigin(view:View) {


    }

    fun onClickDestination() {


    }

    fun onClickGetFlights() {


    }

    interface OnGetFlightsListener {

        fun getDateForSelect()
        fun getOrigin(view: View)
        fun getDestination()
        fun getFlights()

    }

}