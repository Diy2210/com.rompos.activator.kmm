package com.rompos.activator.kmm.androidApp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
//import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.androidApp.databinding.PluginListItemBinding
import com.rompos.activator.kmm.shared.model.PluginModel
import com.rompos.activator.kmm.shared.model.PluginViewModel
import dev.icerock.moko.mvvm.livedata.MutableLiveData

class PluginsAdapter(
    var server: Server,
    var items: MutableLiveData<List<PluginModel>>
) : RecyclerView.Adapter<PluginsAdapter.ItemTableViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemTableViewHolder {
        return ItemTableViewHolder(PluginListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = items.value.size

    fun refreshList(items: MutableLiveData<List<PluginModel>>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemTableViewHolder, position: Int) {
        holder.bind(items.value[position])
    }

    inner class ItemTableViewHolder(private val pluginListItemBinding: PluginListItemBinding) : RecyclerView.ViewHolder(pluginListItemBinding.root) {
        fun bind(item: PluginModel) {
            pluginListItemBinding.item = item
            pluginListItemBinding.server = server
            pluginListItemBinding.handler = PluginViewModel()
            pluginListItemBinding.executePendingBindings()
        }
    }
}