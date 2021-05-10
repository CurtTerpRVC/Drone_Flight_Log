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

    var droneFlightLogDB = DFL_DB(this, null, DATABASE_NAME, DATABASE_VERSION)

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
        val ckYawLeftRight = findViewById<CheckBox>(R.id.ckYawLeftRight)
        val btnSavePreflight = findViewById<Button>(R.id.btnSavePreflight)

        var dtDate = ""
        var tmStartTime = ""
        var tmEndTime = ""
        var txtLocation = ""
        var txtFlightNotes = ""
        var drone = ""



        btnSavePreflight.setOnClickListener {
            var appWorking = ""
            var gimbalCheck = ""
            var droneBattery = ""
            var controllerBattery = ""
            var propCheck = ""
            var leftRight = ""
            var upDown = ""
            var yawLeftRight = ""
            var gimbalMovement = ""

            if (ckAppWorking.isChecked){ appWorking = "Checked"}
            if (ckGimbalCheck.isChecked){ gimbalCheck = "Checked" }
            if (ckDroneBattery.isChecked){ droneBattery = "Checked" }
            if (chControllerBattery.isChecked){ controllerBattery = "Checked" }
            if (ckProp.isChecked){ propCheck = "Checked" }
            if (ckLeftRight.isChecked){ leftRight = "Checked" }
            if (ckUpDown.isChecked){ upDown = "Checked" }
            if (ckYawLeftRight.isChecked){ yawLeftRight = "Checked"}
            if (ckGimbalMovement.isChecked){ gimbalMovement = "Checked" }

            //Save preflight checks to database
            droneFlightLogDB.insertRowPREFLIGHT(dtDate, tmStartTime, tmEndTime, txtLocation, txtFlightNotes, drone,appWorking, gimbalCheck, droneBattery, controllerBattery, propCheck, leftRight, upDown, yawLeftRight, gimbalMovement)

            // reset all checkboxes to unchecked
            ckAppWorking.isChecked = false
            ckGimbalCheck.isChecked = false
            ckDroneBattery.isChecked = false
            chControllerBattery.isChecked = false
            ckProp.isChecked = false
            ckLeftRight.isChecked = false
            ckUpDown.isChecked = false
            ckYawLeftRight.isChecked = false
            ckGimbalMovement.isChecked = false

            // let the user know data has been saved
            Toast.makeText(this,"Values have been saved.",Toast.LENGTH_LONG).show()


        }// end of btnSavePreflight

    }// End of Oncreate

}// End of Preflight_Check_Activity