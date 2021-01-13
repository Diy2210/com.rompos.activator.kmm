package com.rompos.activator.kmm.shared

import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.shared.api.PluginActivatorApi
import com.rompos.activator.kmm.shared.model.ServerViewModel
import com.rompos.activator.kmm.shared.repository.Database

class ActivatorSDK(databaseDriverFactory: DatabaseDriverFactory) {
    val database = Database(databaseDriverFactory)

    suspend fun getServers(forceReload: Boolean): List<Server> {
        val cachedServers = database.getAll()

        return cachedServers
    }
}