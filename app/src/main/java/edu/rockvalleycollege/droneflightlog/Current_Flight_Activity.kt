/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Current_Flight_Activity : AppCompatActivity() {

    var droneFlightLogDB = DFL_DB(this, null, DATABASE_NAME, DATABASE_VERSION)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight__log_)

        val btnDate = findViewById<Button>(R.id.btnDate)
        val btnStartTime = findViewById<Button>(R.id.btnStartTime)
        val btnEndTime = findViewById<Button>(R.id.btnEndTime)
        val btnLocation = findViewById<Button>(R.id.btnLocation)
        val btnSave = findViewById<Button>(R.id.btnSaveData)

        val dtDate = findViewById<EditText>(R.id.dtFlightDate)
        val tmStartTime = findViewById<EditText>(R.id.tmFlightStart)
        val tmEndTime = findViewById<EditText>(R.id.tmFlightEnd)
        val txtLocation = findViewById<TextView>(R.id.txtlocation)
        val txtFlightNotes = findViewById<EditText>(R.id.txtFlightNotes)

        val spDrone = findViewById<Spinner>(R.id.spDrone)

        //TODO Build a shared preference here for the user to save different drones

        // Spinner load code goes here. Fake information is here as a placeholder
        var spinList = arrayOf("Mavic", "Autel", "Parrot", "Tello", "Other")

        val adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinList)
        android.R.layout.simple_spinner_item
        android.R.layout.simple_spinner_dropdown_item
        spDrone.adapter = adapter1


        // Onclick Listeners start here
        btnDate.setOnClickListener {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            val currentDate: String = simpleDateFormat.format(Date())

            dtDate.setText(currentDate)
        }

        btnStartTime.setOnClickListener {
            val simpleTimeFormat = SimpleDateFormat("HHmm z")
            val currentTime: String = simpleTimeFormat.format(Date())

            tmStartTime.setText(currentTime)
        }

        btnEndTime.setOnClickListener {
            val simpleTimeFormat = SimpleDateFormat("HHmm z")
            val currentTime: String = simpleTimeFormat.format(Date())

            tmEndTime.setText(currentTime)
        }

        btnLocation.setOnClickListener {
            //Todo - Need to find code to get GPS location here, or just have a label/text field
            Toast.makeText(this, "Location code will go here", Toast.LENGTH_LONG).show()
        }

        btnSave.setOnClickListener {
            var dtDate = dtDate.text.toString()
            var tmStartTime = tmStartTime.text.toString()
            var tmEndTime = tmEndTime.text.toString()
            var txtLocation = txtLocation.text.toString()
            var txtFlightNotes = txtFlightNotes.text.toString()
            var drone = spDrone.selectedItem.toString()

            droneFlightLogDB.updateRowFLIGHTLOG(dtDate, tmStartTime, tmEndTime, txtLocation, txtFlightNotes, drone)

            Toast.makeText(this,"Date $dtDate, Start Time $tmStartTime, End Time $tmEndTime, Location $txtLocation, Flight Notes $txtFlightNotes, Drone $spDrone ",Toast.LENGTH_LONG).show()

        }

        // Hide Keyboard
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }// End of hidekeyboard findviewbyid

    }// End of Oncreate


    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }// End of HideKeyboard

}// End of Current_flight_Activity