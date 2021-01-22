package com.rompos.activator.kmm.shared

import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.shared.api.PluginActivatorApi
import com.rompos.activator.kmm.shared.model.ServerFormViewModel
import com.rompos.activator.kmm.shared.model.ServerViewModel
import com.rompos.activator.kmm.shared.repository.Database

class ActivatorSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)

    var cachedServers: List<Server> = emptyList()
//    lateinit var server: Server
//    var list: List<Server> = emptyList()
//    private var serverId: Long = 0

    suspend fun getServers(forceReload: Boolean): List<Server> {
        cachedServers = database.getAll()
        return cachedServers
    }

    suspend fun save(serverId: Long, model: ServerFormViewModel) {
        database.save(serverId, model.getModel(serverId))
    }

    suspend fun saveServer(title: String, url: String, token: String) {
        database.saveServer(title, url, token)
    }

    suspend fun updateServer(title: String, url: String, token: String, id: Long) {
        database.updateServer(title, url, token, id)
    }

    suspend fun deleteServer(id: Long) {
        database.delete(id)
    }

    suspend fun getPluginList() {
    }
}