/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class DFL_DB(context: Context, factory: SQLiteDatabase.CursorFactory?, DATABASE_NAME: String?, DATABASE_VERSION: Int) :
            SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){

    override fun onCreate(db: SQLiteDatabase?) {

        val createQuery = "CREATE TABLE $TABLE_NAME " +
                "($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_dtDate TEXT, " +
                "$COLUMN_tmStartTime TEXT, " +
                "$COLUMN_tmEndTime TEXT, " +
                "$COLUMN_txtLocation TEXT, " +
                "$COLUMN_txtFlightNotes TEXT, " +
                "$COLUMN_spDrone TEXT, " +
                "$COLUMN_ckAppWorking TEXT, " +
                "$COLUMN_ckGimbalCheck TEXT, " +
                "$COLUMN_ckDroneBattery TEXT, " +
                "$COLUMN_chControllerBattery TEXT, " +
                "$COLUMN_ckProp TEXT, " +
                "$COLUMN_ckLeftRight TEXT, " +
                "$COLUMN_ckUpDown TEXT, " +
                "$COLUMN_ckYawLeftRight TEXT, " +
                "$COLUMN_ckGimbalMovement TEXT) ;"

        db?.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    //Update Rows for Preflight
    fun insertRowPREFLIGHT(dtDate: String, tmStartTime:String, tmEndTime: String, txtLocation:String, txtFlightNotes:String, spDrone:String, ckAppWorking:String, ckGimbalCheck: String, ckDroneBattery:String, chControllerBattery: String, ckProp:String, ckLeftRight:String, ckUpDown:String, ckYawLeftRight: String, ckGimbalMovement:String) {
        val values = ContentValues()
        values.put(COLUMN_dtDate,dtDate)
        values.put(COLUMN_tmStartTime, tmStartTime)
        values.put(COLUMN_tmEndTime, tmEndTime)
        values.put(COLUMN_txtLocation, txtLocation)
        values.put(COLUMN_txtFlightNotes, txtFlightNotes)
        values.put(COLUMN_spDrone, spDrone)
        values.put(COLUMN_ckAppWorking, ckAppWorking)
        values.put(COLUMN_ckGimbalCheck, ckGimbalCheck)
        values.put(COLUMN_ckDroneBattery, ckDroneBattery)
        values.put(COLUMN_chControllerBattery, chControllerBattery)
        values.put(COLUMN_ckProp, ckProp)
        values.put(COLUMN_ckLeftRight, ckLeftRight)
        values.put(COLUMN_ckUpDown, ckUpDown)
        values.put(COLUMN_ckYawLeftRight, ckYawLeftRight)
        values.put(COLUMN_ckGimbalMovement, ckGimbalMovement)

        //long rowId = db.insert("table", "nullColumnHack", data);
        val db = this.writableDatabase
        lastRowInsert = (db.insert(TABLE_NAME, null, values)).toInt()
        db.close()
    }

    //Update Rows for FLIGHTLOG
    fun updateRowFLIGHTLOG(dtDate: String, tmStartTime:String, tmEndTime: String, txtLocation:String, txtFlightNotes:String, spDrone:String) {
        val values = ContentValues()
        values.put(COLUMN_dtDate, dtDate)
        values.put(COLUMN_tmStartTime, tmStartTime)
        values.put(COLUMN_tmEndTime, tmEndTime)
        values.put(COLUMN_txtLocation, txtLocation)
        values.put(COLUMN_txtFlightNotes, txtFlightNotes)
        values.put(COLUMN_spDrone, spDrone)

        val db = this.writableDatabase
        db.update(TABLE_NAME, values, "$COLUMN_ID = $lastRowInsert",null)
        db.close()
    }

    fun deleteRow(row_id: String) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_ID = ?", null)
        db.close()
    }

    fun getAllRow(): Cursor? {
        val db = this.readableDatabase
        val query = db.rawQuery("SELECT * FROM $TABLE_NAME ORDER BY ID", null)
        return query
        db.close()
    }

    fun getLastRow(lastRowIndex: Int): Cursor? {

        val db = this.readableDatabase
        val cLastRow = db.rawQuery("SELECT * FROM $TABLE_NAME Where id = $lastRowIndex", null)
        db.close()
        return cLastRow
    }

    fun getLastRowStart(lastRowIndex: Int): String? {

        val db = this.readableDatabase
        val etartTime = db.rawQuery("SELECT StartTime FROM $TABLE_NAME Where id = $lastRowIndex", null).toString()
        db.close()
        return etartTime
    }

    fun getLastRowEnd(lastRowIndex: Int): String? {

        val db = this.readableDatabase
        val endTime = db.rawQuery("SELECT EndTime FROM $TABLE_NAME Where id = $lastRowIndex", null).toString()
        db.close()
        return endTime
    }

    fun getLastRowLocation(lastRowIndex: Int): String? {

        val db = this.readableDatabase
        val location = db.rawQuery("SELECT Location FROM $TABLE_NAME Where id = $lastRowIndex", null).toString()
        db.close()
        return location
    }

    fun getLastRowFlightNotes(lastRowIndex: Int): String? {

        val db = this.readableDatabase
        val flightNotes = db.rawQuery("SELECT FlightNotes FROM $TABLE_NAME Where id = $lastRowIndex", null).toString()
        db.close()
        return flightNotes
    }


    companion object {
        const val DATABASE_VERSION = 8
        const val DATABASE_NAME = "myFlightLog.db"
        const val TABLE_NAME = "flight_data"

        const val COLUMN_ID = "id"
        const val COLUMN_dtDate = "Date"
        const val COLUMN_tmStartTime = "StartTime"
        const val COLUMN_tmEndTime = "EndTime"
        const val COLUMN_txtLocation = "Location"
        const val COLUMN_txtFlightNotes = "FlightNotes"
        const val COLUMN_spDrone = "Drone"
        const val COLUMN_ckAppWorking = "AppWorking"
        const val COLUMN_ckGimbalCheck = "GimbalCheck"
        const val COLUMN_ckDroneBattery = "DroneBattery"
        const val COLUMN_chControllerBattery = "ControllerBattery"
        const val COLUMN_ckProp = "Prop"
        const val COLUMN_ckLeftRight = "LeftRight"
        const val COLUMN_ckUpDown = "UpDown"
        const val COLUMN_ckYawLeftRight = "YawLeftRight"
        const val COLUMN_ckGimbalMovement = "GimbalMovement"
    }

}// end of class DFL_DB




