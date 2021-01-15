package com.rompos.activator.kmm.shared

import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.shared.api.PluginActivatorApi
import com.rompos.activator.kmm.shared.model.ServerFormViewModel
import com.rompos.activator.kmm.shared.model.ServerViewModel
import com.rompos.activator.kmm.shared.repository.Database

class ActivatorSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    lateinit var cachedServers: List<Server>
//    lateinit var server: Server
//    var list: List<Server> = emptyList()
//    private var serverId: Long = 0

    suspend fun getServers(forceReload: Boolean): List<Server> {
        val cachedServers = database.getAll()
        return cachedServers
    }

    suspend fun saveServer(serverId: Long, model: ServerFormViewModel) {
        database.save(serverId, model.getModel(serverId))
    }

    suspend fun deleteServer(item: Server) {
        database.delete(item.ID)
    }

    suspend fun getPluginList() {
    }
}