/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPreferences = findViewById<Button>(R.id.btnPreferences)
        val btnCurrentFlight = findViewById<Button>(R.id.btnCurrentFlight)
        val btnPreflight = findViewById<Button>(R.id.btnPreflight)
        val btnPastFlight = findViewById<Button>(R.id.btnPastFlights)




        // On Click Listeners for all buttons

        btnPreferences.setOnClickListener {

            val intent = Intent(this, Preferences_Activity::class.java)
            //Go to Preferences activity
            startActivity(intent)
        }

        btnCurrentFlight.setOnClickListener {
            val intent = Intent(this, Current_Flight_Activity::class.java)
            //Go to Flight activity
            startActivity(intent)

        }

        btnPreflight.setOnClickListener {
            val intent = Intent(this, PreFlight_Check_Activity::class.java)
            //Go to Preflight activity
            startActivity(intent)

        }

        btnPastFlight.setOnClickListener {
            val intent = Intent(this, Past_Flight_Activity::class.java)
            //Go to Past flight activity
            startActivity(intent)

        }


    }// end of Oncreate

}// end of Main Activity