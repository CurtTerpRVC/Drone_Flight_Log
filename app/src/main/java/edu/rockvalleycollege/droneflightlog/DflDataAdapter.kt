/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class DflDataAdapter : RecyclerView.Adapter<DflDataAdapter.DflDataHolder>(){

    var data = mutableListOf<PVData>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DflDataHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.cardview_dfldata,viewGroup,  false)


        return DflDataHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DflDataHolder, position: Int) {

        var logData = data[position]



        /*
        viewHolder.itemView.tvId.text = logData.pvId.toString()
        viewHolder.itemView.tvDate.text = logData.pvDate
        viewHolder.itemView.tvStart.text = logData.pvStart
        viewHolder.itemView.tvEnd.text = logData.pvEnd
        */
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    inner class DflDataHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    }// End of Inner Class

}// end of dflDataAdapter class