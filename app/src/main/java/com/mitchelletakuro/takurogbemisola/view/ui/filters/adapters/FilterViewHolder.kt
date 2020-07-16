package com.mitchelletakuro.takurogbemisola.view.ui.filters.adapters

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mitchelletakuro.takurogbemisola.R
import com.mitchelletakuro.takurogbemisola.data.models.FilterModel

class FilterViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    var gender: TextView = itemView.findViewById(R.id.gender)
    var colors: TextView = itemView.findViewById(R.id.colors)
    var countries: TextView = itemView.findViewById(R.id.countries)
    var carModelYear: TextView = itemView.findViewById(R.id.car_model_year)


    @SuppressLint("SetTextI18n")
    fun bind(filter: FilterModel, clickListener: OnItemClickListener)
    {

        carModelYear.text = "${filter.carModel_startYear} ${filter.carModel_endYear}"
        gender.text = filter.gender
        countries.text = filter.countries.joinToString(", ")
        colors.text = filter.colors.joinToString(", ")



        itemView.setOnClickListener {
            clickListener.onItemClicked(filter)
        }

    }

}
interface OnItemClickListener{
    fun onItemClicked( clicked: FilterModel)}

