package com.venkatesh.mvvm.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.venkatesh.mvvm.databinding.Dashboardbinding
import com.venkatesh.mvvm.model.Fruites

/*
   Using databinding concept please check item.xml for detail
 */
class DashboardAdapter(val list: List<Fruites>) :
        RecyclerView.Adapter<DashboardAdapter.DashboardVH>() {


    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: DashboardVH, position: Int) {
        holder.bind(list.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardVH {
        return DashboardVH(Dashboardbinding.
                inflate(LayoutInflater.from(parent.context),parent,false))
    }


    class DashboardVH(val view: Dashboardbinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(model: Fruites) {
            view.dashviewmodel = model
            view.executePendingBindings()

        }
    }
}