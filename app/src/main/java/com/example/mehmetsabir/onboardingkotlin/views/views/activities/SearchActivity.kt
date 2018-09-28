package com.example.mehmetsabir.onboardingkotlin.views.views.activities

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.example.mehmetsabir.onboardingkotlin.R
import com.example.mehmetsabir.onboardingkotlin.views.connections.ManagerAll
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.AirportModel
import com.example.mehmetsabir.onboardingkotlin.views.models.iatamodels.SearchAirportResponse
import com.example.mehmetsabir.onboardingkotlin.views.views.adapters.SearchAirportAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class SearchActivity : AppCompatActivity(), SearchAirportAdapter.OnAirportSelectListener {

    private val API_KEY = "9f2daca0-f8e5-4996-8a3b-7d7a099eaddf"
    private var recylerView: RecyclerView? = null
    private var edtTxtSearchOfAirportName: EditText? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private val mairports = ArrayList<AirportModel>()
    private var filterAdapter: SearchAirportAdapter? = null
    private val filterList = ArrayList<AirportModel>()
    private var bundle: Bundle? = null
    private var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recylerView = findViewById<RecyclerView>(R.id.searchrecyler)
        edtTxtSearchOfAirportName = findViewById<EditText>(R.id.editTxtSearchandFilter)

        getModel()
        searchAirports()

    }

    private  fun getModel() {

        progressDialog = ProgressDialog(this@SearchActivity)
        progressDialog?.setTitle("Bilgi Ekranı")
        progressDialog?.setMessage("Havaalanları Yükleniyor , Lütfen Bekleyiniz ...")
        progressDialog?.setCancelable(true)
        progressDialog?.show()

        ManagerAll.instance.getAirports(API_KEY).enqueue(object : Callback<SearchAirportResponse> {
            override fun onResponse(call: Call<SearchAirportResponse>, response: Response<SearchAirportResponse>) {
                if (response.isSuccessful) {

                    mairports?.clear()
                    mairports.addAll(response.body()?.airports!!)
                    layoutManager = LinearLayoutManager(this@SearchActivity)
                    recylerView?.layoutManager = layoutManager
                    bundle = intent.extras
                    filterAdapter = SearchAirportAdapter(applicationContext, mairports, bundle!!.get("tag").toString(),
                            this@SearchActivity)
                    recylerView?.adapter = filterAdapter
                }

                progressDialog?.cancel()

            }

            override fun onFailure(call: Call<SearchAirportResponse>, t: Throwable) {
                Log.e("hata", t.localizedMessage)
                if (t.localizedMessage.contains("timeout")) {

                }

            }
        })
    }

    override fun onAirportSelected(tag: String, airportName: String, airportCode: String) {
        val intent = Intent()
        intent.putExtra("airport", airportName)
        intent.putExtra("tag", tag)
        intent.putExtra("airportCode", airportCode)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun getFilter(search: String) {

        filterList.clear()

        for (airportModel in mairports) {

            if (airportModel.name?.toLowerCase()!!.contains(search.toLowerCase())) {

                filterList.add(airportModel)
                filterAdapter = SearchAirportAdapter(this@SearchActivity, filterList, bundle!!.get("tag").toString(),
                        this@SearchActivity)
                recylerView?.adapter = filterAdapter
                filterAdapter?.notifyDataSetChanged()
            }
        }

    }

    private fun searchAirports() {

        edtTxtSearchOfAirportName?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString() == "") {

                    getModel()

                } else {

                    getFilter(s.toString())
                }
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }


}
