package com.rompos.activator.kmm.androidApp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.androidApp.R
import com.rompos.activator.kmm.androidApp.databinding.ServerListItemBinding
import com.rompos.activator.kmm.shared.model.ServerViewModel

class ServersAdapter(
    var items: List<Server>,
    val clickItemCallback: ClickCallback,
    private val clickEditItemCallback: EditClickCallback,
    private val clickDeleteItemCallback: DeleteClickCallback
) : RecyclerView.Adapter<ServersAdapter.ServerViewHolder>() {

    inner class ServerViewHolder(private val binding: ServerListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServerViewModel) {
            binding.item = item
            binding.executePendingBindings()
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) clickItemCallback.onItemClicked(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerViewHolder {
        return ServerViewHolder(ServerListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = items.size

    fun refreshList(items: List<Server>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ServerViewHolder, position: Int) {
        holder.itemView.setOnCreateContextMenuListener { contextMenu, _, _ ->
            contextMenu.add(R.string.edit_item).setOnMenuItemClickListener {
                if (position != RecyclerView.NO_POSITION) {
                    clickEditItemCallback.onEditItemClicked(items[position])
                }
                true
            }
            contextMenu.add(R.string.delete_item).setOnMenuItemClickListener {
                if (position != RecyclerView.NO_POSITION) {
                    clickDeleteItemCallback.onDeleteItemClicked(items[position])
                }
                true
            }
        }
        holder.bind(ServerViewModel().setModel(items[position]))
    }

    interface ClickCallback {
        fun onItemClicked(item: Server)
    }

    interface EditClickCallback {
        fun onEditItemClicked(item: Server)
    }

    interface DeleteClickCallback {
        fun onDeleteItemClicked(item: Server)
    }
}
