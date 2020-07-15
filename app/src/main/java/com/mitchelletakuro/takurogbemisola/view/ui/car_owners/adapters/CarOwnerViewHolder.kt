package com.mitchelletakuro.takurogbemisola.view.ui.car_owners.adapters

import android.annotation.SuppressLint
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mitchelletakuro.takurogbemisola.R
import com.mitchelletakuro.takurogbemisola.data.models.CarOwner
import kotlinx.android.synthetic.main.item_filter.view.*


class CarOwnerViewHolder (itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    var name: TextView = itemView.findViewById(R.id.name)
    var gender:TextView = itemView.findViewById(R.id.gender_content)
    var email: TextView = itemView.findViewById(R.id.email_content)
    var carModel: TextView = itemView.findViewById(R.id.car_model_content)
    var carModelYear: TextView = itemView.findViewById(R.id.car_model_content)
    var carColor: TextView = itemView.findViewById(R.id.car_color_content)
    var country: TextView = itemView.findViewById(R.id.country_content)
    var job : TextView = itemView.findViewById(R.id.job_content)
    var bio : TextView = itemView.findViewById(R.id.bio_content)


    @SuppressLint("SetTextI18n")
    fun bind(owner: CarOwner, clickListener: AdapterView.OnItemClickListener)
    {

        name.text = "${owner.firstName} ${owner.lastName}"
        gender.text = owner.gender
        email.text = owner.email
        carModel.text = owner.carModel
        carModelYear.text = owner.carModelYear.toString()
        carColor.text = owner.carColor
        country.text = owner.country
        bio.text = owner.biography
        job.text = owner.jobTitle


    }

}