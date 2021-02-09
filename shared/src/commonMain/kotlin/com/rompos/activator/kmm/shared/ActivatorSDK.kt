package com.rompos.activator.kmm.shared

import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.shared.api.PluginActivatorApi
import com.rompos.activator.kmm.shared.model.PluginModel
import com.rompos.activator.kmm.shared.model.PluginResponseModel
import com.rompos.activator.kmm.shared.repository.Database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ActivatorSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = PluginActivatorApi()
    lateinit var resp: PluginResponseModel

    var listServers: List<Server> = emptyList()
    var listPlugins: List<PluginModel> = emptyList()

    suspend fun getServers(forceReload: Boolean): List<Server> {
        listServers = database.getAll()
        return listServers
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

    @Throws(Exception::class)
    suspend fun getPluginList(server: Server): List<PluginModel> {
        GlobalScope.launch {
//            try {
            api.getPluginsList(server).also { response ->
                resp = Json.decodeFromString(PluginResponseModel.serializer(), response)
                if (resp.success) {
                    listPlugins = resp.data
                    println("Success")
                } else {
                    println("Error")
                }
            }
//            } catch (e: Exception) {
//                println("Server Error: $e")
//            }
        }
        return listPlugins
    }

    @Throws(Exception::class)
    suspend fun updatePluginStatus(server: Server, pluginModel: PluginModel, state: Boolean) {
        GlobalScope.launch {
//            try {
            api.updatePluginStatus(server, pluginModel, state)
//            } catch (e: Exception) {
//                println("Server Error: $e")
//            }
        }
    }
}