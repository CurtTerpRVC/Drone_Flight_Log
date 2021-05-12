/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Drone flight Log - Final App
*/

package edu.rockvalleycollege.droneflightlog

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView



class DflDataAdapter : RecyclerView.Adapter<DflDataAdapter.DflDataHolder>(){

    var data = mutableListOf<Cursor?>()


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DflDataHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.cardview_dfldata,viewGroup,false)

        return DflDataHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DflDataHolder, position: Int) {

        val logData = data[position]

        //TODO This code below does not recognize the Text View within the card view specified in the inflate code

    /*
        viewHolder.itemView.tvId.text = logData.pvId.toString()
        viewHolder.itemView.tvDate.text = logData.pvDate
        viewHolder.itemView.tvStart.text = logData.pvStart
        viewHolder.itemView.tvEnd.text = logData.pvEnd
        */
    }

    override fun getItemCount(): Int {

        return  data.size
        //return 2
    }

    inner class DflDataHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    }// End of Inner Class

}// end of dflDataAdapter class