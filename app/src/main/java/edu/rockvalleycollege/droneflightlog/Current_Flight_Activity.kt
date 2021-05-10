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
import org.jetbrains.annotations.NotNull
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
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
        val btnSave = findViewById<Button>(R.id.btnSaveData)

        val dtDate = findViewById<EditText>(R.id.dtFlightDate)
        val tmStartTime = findViewById<EditText>(R.id.tmFlightStart)
        val tmEndTime = findViewById<EditText>(R.id.tmFlightEnd)
        val txtLocation = findViewById<EditText>(R.id.txtlocation)
        val txtFlightNotes = findViewById<EditText>(R.id.txtFlightNotes)

        val spDrone = findViewById<Spinner>(R.id.spDrone)


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

        btnSave.setOnClickListener {

            var dtDate = dtDate.text.toString()
            var tmStartTime = tmStartTime.text.toString()
            var tmEndTime = tmEndTime.text.toString()
            var txtLocation = txtLocation.text.toString()
            var txtFlightNotes = txtFlightNotes.text.toString()
            var drone = spDrone.selectedItem.toString()

            // this code keeps from erasing existing saves. It only looks for the end time
            if(tmEndTime != ""){
                droneFlightLogDB.updateRowFLIGHTLOG(dtDate, tmStartTime, tmEndTime, txtLocation, txtFlightNotes, drone)
                Toast.makeText(this, "Data has been saved",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Please enter a flight end time before saving",Toast.LENGTH_LONG).show()
            }

        }//end of onclick listener

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