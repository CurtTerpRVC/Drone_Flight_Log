/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import android.os.Bundle
import android.text.Layout
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileWriter
import java.io.IOException

//TODO still need to figure out why the card vieew is not working correctly. We are not displaying past flights in the database at this time
class Past_Flight_Activity : AppCompatActivity() {

    var droneFlightLogDB = DFL_DB(this, null, DATABASE_NAME, DATABASE_VERSION)

    lateinit var dflAdapter : DflDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_past__flight_)

        // variable setup
        var id = ""
        var date = ""
        var startTime = ""
        var endTime = ""
        var location = ""
        var flightNotes = ""
        var drone = ""
        var appWorking = ""
        var gimbalcheck = ""
        var droneBattery = ""
        var controllerBattery = ""
        var prop = ""
        var leftRight = ""
        var upDown = ""
        var gimbalMovement = ""

        val btnExportPastFlight = findViewById<Button>(R.id.btnExportPastFlight)
        
        val rvDFLData = findViewById<RecyclerView>(R.id.rvDFLData)

        var logData = mutableListOf<DFL_DB>()

        val cursor = droneFlightLogDB.getAllRow()

        rvDFLData.layoutManager = LinearLayoutManager(this)
        dflAdapter = DflDataAdapter()
        rvDFLData.adapter = dflAdapter


        btnExportPastFlight.setOnClickListener() {

            // getting the table row and putting them into variables for export
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    if (cursor != null) {
                        do {
                            val idIndex = cursor.getColumnIndex("id")
                             id = cursor.getInt(idIndex).toString()

                             date = cursor.getString(cursor.getColumnIndex("Date"))
                             startTime = cursor.getString(cursor.getColumnIndex("StartTime"))
                             endTime = cursor.getString(cursor.getColumnIndex("EndTime"))
                             location = cursor.getString(cursor.getColumnIndex("Location"))
                             flightNotes = cursor.getString(cursor.getColumnIndex("FlightNotes"))
                             drone = cursor.getString(cursor.getColumnIndex("Drone"))
                             appWorking = cursor.getString(cursor.getColumnIndex("AppWorking"))
                             gimbalcheck = cursor.getString(cursor.getColumnIndex("GimbalCheck"))
                             droneBattery = cursor.getString(cursor.getColumnIndex("DroneBattery"))
                             controllerBattery = cursor.getString(cursor.getColumnIndex("ControllerBattery"))
                             prop = cursor.getString(cursor.getColumnIndex("Prop"))
                             leftRight = cursor.getString(cursor.getColumnIndex("LeftRight"))
                             upDown = cursor.getString(cursor.getColumnIndex("UpDown"))
                             gimbalMovement = cursor.getString(cursor.getColumnIndex("GimbalMovement"))

                        // Start of write to csv file.
                        val CSV_HEADER =
                            "ID,Start Time,End Time,Location, Flight Notes, Drone, App Working, Gimbal Check, Drone Battery, Controller Battery, Prop Left-Right, Up-Down, yawleft-right, Gimbal Movement"

                        var fileWriter: FileWriter? = null

                        val file = File(filesDir, "flightdata.csv")

                        try {

                            fileWriter = FileWriter("$file")
                            if(id == "1"){
                            fileWriter.append(CSV_HEADER)
                            fileWriter.append('\n')
                            }

                            fileWriter.append(id)
                            fileWriter.append(',')
                            fileWriter.append(date)
                            fileWriter.append(',')
                            fileWriter.append(startTime)
                            fileWriter.append(',')
                            fileWriter.append(endTime)
                            fileWriter.append('\n')
                            fileWriter.append(location)
                            fileWriter.append('\n')
                            fileWriter.append(drone)
                            fileWriter.append(',')
                            fileWriter.append(flightNotes)
                            fileWriter.append(',')
                            fileWriter.append(appWorking)
                            fileWriter.append(',')
                            fileWriter.append(gimbalcheck)
                            fileWriter.append(',')
                            fileWriter.append(droneBattery)
                            fileWriter.append(',')
                            fileWriter.append(controllerBattery)
                            fileWriter.append(',')
                            fileWriter.append(prop)
                            fileWriter.append(',')
                            fileWriter.append(leftRight)
                            fileWriter.append(',')
                            fileWriter.append(upDown)
                            fileWriter.append(',')
                            fileWriter.append(gimbalMovement)
                            fileWriter.append(',')

                            println("Write CSV successfully!")
                        } catch (e: Exception) {
                            println("Writing CSV error!")
                            e.printStackTrace()
                        } finally {
                            try {
//                                fileWriter!!.flush()
                                fileWriter?.close()
                            } catch (e: IOException) {
                                println("Flushing/closing error!")
                                e.printStackTrace()
                            }
                        }
                        } while (cursor.moveToNext())

                    }
                }
            }// end of if cursor != null

            }//end of onclick listener


        }// End of Oncreate


}// end of Past Flight Actibity