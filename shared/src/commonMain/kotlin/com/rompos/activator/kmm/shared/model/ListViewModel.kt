package com.rompos.activator.kmm.shared.model

import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.shared.base.myApp
import com.rompos.activator.kmm.shared.repository.ServersRepository
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.kodein.di.instance

class ListViewModel : ViewModel() {

    private val repository: ServersRepository by myApp.kodein.instance()
    var list: List<Server> = emptyList()
    private val _servers: MutableLiveData<List<Server>> = MutableLiveData(list)

    init {
        reload()
    }

    fun reload() {
        list = repository.getAll()
        _servers.value = list
    }

    fun getInitList(): MutableLiveData<List<Server>> {
        _servers.value = list
        return _servers
    }

    val servers: LiveData<List<Server>> = _servers

    fun getList() {
        list = repository.getAll()
        _servers.value = list
    }

    fun delete(item: Server) {
        try {
            repository.delete(item.ID).also {
//                adapter.items = repository.getAll()
//                adapter.notifyDataSetChanged()
                }
            } catch (e: Exception) {
        }
    }
}