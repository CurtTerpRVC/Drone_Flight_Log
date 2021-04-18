/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class PreFlight_Check_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_flight__check_)

        val ckAppWorking = findViewById<CheckBox>(R.id.ckAppWorking)
        val ckGimbalCheck = findViewById<CheckBox>(R.id.ckGimbalCheck)
        val ckDroneBattery = findViewById<CheckBox>(R.id.ckDroneBattery)
        val chControllerBattery = findViewById<CheckBox>(R.id.ckControllerBattery)
        val ckProp = findViewById<CheckBox>(R.id.ckProp)
        val ckLeftRight = findViewById<CheckBox>(R.id.ckLeftRight)
        val ckUpDown = findViewById<CheckBox>(R.id.ckUpDown)
        val ckGimbalMovement = findViewById<CheckBox>(R.id.ckGimbalMovement)
        val btnSavePreflight = findViewById<Button>(R.id.btnSavePreflight)



        btnSavePreflight.setOnClickListener {
            Toast.makeText(this, "Save Preflight has been clicked", Toast.LENGTH_LONG).show()


        }

    }// End of Oncreate


}// End of Preflight_Check_Activity