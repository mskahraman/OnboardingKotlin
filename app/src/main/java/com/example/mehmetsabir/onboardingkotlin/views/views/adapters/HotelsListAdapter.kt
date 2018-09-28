package com.example.mehmetsabir.onboardingkotlin.views.views.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mehmetsabir.onboardingkotlin.R
import com.example.mehmetsabir.onboardingkotlin.views.models.amadeushotelmodels.DataModel

class HotelsListAdapter(listOfHotel : ArrayList<DataModel> , context : Context ) : BaseAdapter() {

    private var listOfHotel = ArrayList<DataModel>()
    private var context: Context? = null
    private var nameOfHotels: TextView? = null
    private var typeOfHotels: TextView? = null
    private var descriptionfHotels: TextView? = null
    private var priceOfHotels: TextView? = null
    private var currentPriceOfHotels: TextView? = null

    init {
        this.listOfHotel = listOfHotel
        this.context = context

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?

        view = LayoutInflater.from(context).inflate(R.layout.hotels_layout_adapter, parent, false)

        nameOfHotels = view.findViewById(R.id.nameOfHotels) as TextView
        typeOfHotels = view.findViewById(R.id.typeOfHotels) as TextView
        descriptionfHotels = view.findViewById(R.id.descriptionfHotels) as TextView
        priceOfHotels = view.findViewById(R.id.priceOfHotels) as TextView
        currentPriceOfHotels = view.findViewById(R.id.currentPriceOfHotels) as TextView

        nameOfHotels?.text = listOfHotel[position].hotel?.name
        typeOfHotels?.text = listOfHotel[position].offers?.get(0)?.room?.type.toString()
        descriptionfHotels?.text = listOfHotel[position].offers?.get(0)?.room?.description?.text.toString()
        priceOfHotels?.text = listOfHotel[position].offers?.get(0)?.price?.total.toString()
        currentPriceOfHotels?.text = "  " + listOfHotel[position].offers?.get(0)?.price?.currency.toString()

        return view
    }

    override fun getItem(position: Int): Any {
        return listOfHotel.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
       return  listOfHotel.size
    }

}