package com.example.mehmetsabir.onboardingkotlin.views.views.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import com.example.mehmetsabir.onboardingkotlin.R
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.AirportModel

class SearchAirportAdapter(context: Context, list: List<AirportModel>, tag: String, onAirportSelectListener: OnAirportSelectListener) :
        RecyclerView.Adapter<SearchAirportAdapter.Define>() {

    private val context: Context
    private val list: List<AirportModel>
    private var tag: String? = null
    var onAirportSelectListener: OnAirportSelectListener? = null

    init {
        this.context = context
        this.list = list
        this.tag = tag
        this.onAirportSelectListener = onAirportSelectListener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Define {
        val view = LayoutInflater.from(context).inflate(R.layout.search_adapter_layout, parent, false)
        return Define(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Define, position: Int) {
        holder.itemOfSearchedAirport.text = "${list[position].name} - ${list[position].code}"

        holder.itemOfSearchedAirport.setOnClickListener {

            if (onAirportSelectListener != null) {
                onAirportSelectListener?.onAirportSelected(tag!!, list[position].name.toString(), list[position].code.toString())
            }
        }

    }


    inner class Define(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemOfSearchedAirport: TextView

        init {
            super.itemView
            itemOfSearchedAirport = itemView.findViewById(R.id.searchedAirports) as TextView

        }
    }

    interface OnAirportSelectListener {

        fun onAirportSelected(tag: String, airportName: String, airportCode: String)

    }
}