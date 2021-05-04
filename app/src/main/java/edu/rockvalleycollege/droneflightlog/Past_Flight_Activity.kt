/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Past_Flight_Activity : AppCompatActivity() {

    var droneFlightLogDB = DFL_DB(this, null, DATABASE_NAME, DATABASE_VERSION)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_past__flight_)

        droneFlightLogDB.getAllRow()




    }// End of Oncreate


}// end of Past Flight Actibity