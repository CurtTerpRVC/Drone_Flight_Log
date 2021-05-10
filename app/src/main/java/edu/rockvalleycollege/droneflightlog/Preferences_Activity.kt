/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.File
import java.io.FileWriter
import java.io.IOException

class Preferences_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences_)

        val txtDroneModel = findViewById<EditText>(R.id.txtDroneModel)
        val txtDroneSN = findViewById<EditText>(R.id.txtDroneSN)
        val btnSaveDroneInfo = findViewById<Button>(R.id.btnSaveDroneInfo)
        var droneToSave = ""
        var csvHeader = "Drones"



        btnSaveDroneInfo.setOnClickListener(){

            hideKeyboard()

            // Writing New Drone Models to csv file for spinner
            droneToSave = "${txtDroneModel.text} - S/N:${txtDroneSN.text}"

            var fileWriter: FileWriter? = null

            val file = File(filesDir, "Drones.csv")

            try {

                fileWriter = FileWriter("$file")
                if(file.exists()== false){
                    fileWriter.append(csvHeader)
                    fileWriter.append("\n")
                }
                fileWriter.append(droneToSave)
                fileWriter.append(',')
                //fileWriter.append("\n")


                println(droneToSave)
                println("Write CSV successfully!")
                txtDroneModel.setText("")
                txtDroneSN.setText("")
                txtDroneModel.requestFocus()


            } catch (e: Exception) {
                println("Writing CSV error!")
                e.printStackTrace()
            } finally {
                try {
//                    fileWriter!!.flush()
                    fileWriter?.close()
                } catch (e: IOException) {
                    println("Flushing/closing error!")
                    e.printStackTrace()
                }
            }

        }// end of setonclicklistener


        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }// End of hidekeyboard findviewbyid

    }//End of oncreate

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
    }// end of Preferences Activity