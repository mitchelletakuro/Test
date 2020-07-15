package com.mitchelletakuro.takurogbemisola.view.ui.car_owners.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.mitchelletakuro.takurogbemisola.R
import com.mitchelletakuro.takurogbemisola.data.models.CarOwner

class CarOwnerAdapter (
        var owners: List<CarOwner>,
        var listener: AdapterView.OnItemClickListener
) :
    RecyclerView.Adapter<CarOwnerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarOwnerViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_owner, parent, false)
        return CarOwnerViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: CarOwnerViewHolder, position: Int) {
        val owner = owners[position]
        holder.bind(owner, listener)
    }

    override fun getItemCount(): Int {
        return owners.count()
    }

}