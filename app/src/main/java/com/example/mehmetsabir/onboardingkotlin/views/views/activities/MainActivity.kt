package com.example.mehmetsabir.onboardingkotlin.views.views.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.example.mehmetsabir.onboardingkotlin.R
import java.util.*

class MainActivity() : AppCompatActivity() {

    private var edtTxtDepartureDate: EditText? = null
    private var edtTxtDateComingBack: EditText? = null
    private var edtTxtOrigin: EditText? = null
    private var edtTxtDestination: EditText? = null
    private var mCurrentTime: Calendar? = null
    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0
    private var spinnerAdult: Spinner? = null
    private var spinnerChild: Spinner? = null
    private var spinnerBabe: Spinner? = null
    private var countOfPassengers: Int? = null
    private var imgChangeDirection: ImageView? = null
    private var cbNonStop: CheckBox? = null
    private var rbtnGrpClassOfTravel: RadioGroup? = null
    private val spinnerArrayOfAges = arrayOf(0, 1, 2, 3, 4, 5, 6, 7)
    private var arrayAdapter: ArrayAdapter<*>? = null
    private var btnClickSearchOfFlights: Button? = null
    private var airportCodeForIntentDestination: String? = null
    private var airportCodeForIntentOrigin: String? = null
    private var datePicker: DatePickerDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // binding!!.handlerGettingInfo = Handler()
        init()
        getFlightsList()


    }

    fun init() {
        edtTxtDepartureDate = findViewById<EditText>(R.id.edtTxtDepartureDate)
        edtTxtDateComingBack = findViewById<EditText>(R.id.edtTxtDateOfComingBack)
        edtTxtOrigin = findViewById<EditText>(R.id.edtTxtOrigin)
        edtTxtDestination = findViewById<EditText>(R.id.edtTxtDestination)
        imgChangeDirection = findViewById(R.id.changeDirection) as ImageView
        cbNonStop = findViewById<CheckBox>(R.id.cbNonStop)
        spinnerAdult = findViewById<Spinner>(R.id.spinnerAdult)
        spinnerChild = findViewById<Spinner>(R.id.spinnerChild)
        spinnerBabe = findViewById<Spinner>(R.id.spinnerBabe)
        rbtnGrpClassOfTravel = findViewById<RadioGroup>(R.id.rbGroupClass)
        btnClickSearchOfFlights = findViewById<Button>(R.id.btnClickSearchOfFlights)

        setAdapterToSpinner()
        getItemCountFromSpinner(spinnerAdult)

    }

    private fun itemCbClicked(v: View): Boolean {

        if ((v as CheckBox).isChecked) {
            return true
        } else {
            return false
        }
    }

    private fun setAdapterToSpinner() {

        arrayAdapter = ArrayAdapter(this, R.layout.spinner_layout_item, spinnerArrayOfAges)
        spinnerAdult?.adapter = arrayAdapter
        spinnerChild?.adapter = arrayAdapter
        spinnerBabe?.adapter = arrayAdapter


    }

    private fun getItemCountFromSpinner(spinner: Spinner?): Int? {

        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                countOfPassengers = spinnerAdult?.selectedItem.toString().toInt()

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }

        }

        return countOfPassengers
    }

    private fun getClassfromGroup(id: Int): String {

        when (id) {
            R.id.rbBusinessClassOfTravel -> return "BUSINESS"
            R.id.rbComfortClassOfTravel -> return "COMFORT"
            R.id.rbEconomicClassOfTravel -> return "ECONOMY"
            else -> return "Ekonomi, Business yada Konforlu seçilmedi"
        }
    }

    fun onClickSelectDate(view: View) {

        mCurrentTime = Calendar.getInstance()
        year = mCurrentTime!!.get(Calendar.YEAR)
        month = mCurrentTime!!.get(Calendar.MONTH)
        day = mCurrentTime!!.get(Calendar.DAY_OF_MONTH)

        datePicker = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener

        { view, year, monthOfYear, dayOfMonth ->

            edtTxtDepartureDate?.setText(year.toString() + "-" + (monthOfYear + 1) as Int + "-" + dayOfMonth)
        }, year, month, day)

        datePicker?.setTitle("Tarih Seçiniz")
        datePicker?.setButton(DatePickerDialog.BUTTON_POSITIVE, "TARİHİ SEÇ", datePicker)
        datePicker?.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İPTAL ET", datePicker)
        datePicker?.show()
    }

    fun onClickChangeDirection(view: View) {

        var tempOfName = edtTxtOrigin?.text
        edtTxtOrigin?.text = edtTxtDestination?.text
        edtTxtDestination?.text = tempOfName


        var tempOfCode = airportCodeForIntentOrigin
        airportCodeForIntentDestination = airportCodeForIntentOrigin
        airportCodeForIntentOrigin = tempOfCode
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == 100) {
            var extras = data!!.extras
            if (extras != null) {
                var tagName = extras.getString("tag")
                var airportsName = extras.getString("airport")
                var airportsCode = extras.getString("airportCode")

                if (tagName == edtTxtDestination?.tag) {
                    edtTxtDestination?.setText(airportsName);
                    airportCodeForIntentDestination = airportsCode.toString()

                } else {
                    edtTxtOrigin?.setText(airportsName)
                    airportCodeForIntentOrigin = airportsCode.toString()

                }
            }
        }


    }

    fun onClickOrigin(view: View) {

        edtTxtOrigin!!.tag = "from"
        goToSearchActivity(edtTxtOrigin!!.tag.toString())

    }

    fun onClickDestination(view: View) {

        edtTxtDestination?.tag = "to"
        goToSearchActivity(edtTxtDestination!!.tag.toString())

    }

    private fun goToSearchActivity(comingTag: String?) {
        val intent: Intent = Intent(this@MainActivity, SearchActivity::class.java)
        intent.putExtra("tag", comingTag)
        startActivityForResult(intent, 100)

    }

    private fun getFlightsList() {

        btnClickSearchOfFlights?.setOnClickListener(View.OnClickListener {

            val Id = rbtnGrpClassOfTravel?.checkedRadioButtonId

            val intent = Intent(this@MainActivity, FlightListActivity::class.java)
            intent.putExtra("origin", airportCodeForIntentOrigin)
            intent.putExtra("destination", airportCodeForIntentDestination)
            intent.putExtra("departureDate", edtTxtDepartureDate?.text.toString())
            intent.putExtra("travelClass", getClassfromGroup(Id!!))
            intent.putExtra("nonStopOrNot", itemCbClicked(cbNonStop!!))
            intent.putExtra("passengersCount", getItemCountFromSpinner(spinnerAdult))
            startActivity(intent)
        })

    }

}


