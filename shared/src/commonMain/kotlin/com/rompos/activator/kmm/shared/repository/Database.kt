package com.rompos.activator.kmm.shared.repository

import com.benasher44.uuid.Uuid
import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.databes.Servers
import com.rompos.activator.kmm.shared.DatabaseDriverFactory
import com.rompos.activator.kmm.shared.model.ServerViewModel

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Servers(databaseDriverFactory.createDriver())
    private val serverQueries = database.serverQueries

    fun getAll(): List<Server> {
        return serverQueries.selectAll().executeAsList()
    }

//    internal fun getAllServers(): List<Server> {
//        return serverQueries.selectAllServers(::mapServers).executeAsList()
//    }
//
//    private fun mapServers(
//        ID: Long,
//        title: String,
//        url: String,
//        token: String
//    ): Server {
//            return Server(
//                ID = ID,
//                title = title,
//                url = url,
//                token = token
//        )
//    }

    fun get(id: Long): Server {
        return serverQueries.selectByID(id).executeAsOne()
    }

//    fun save(id: Uuid, model: Server) {
//        if (id > 0) {
//            serverQueries.update(
//                model.title,
//                model.url,
//                model.token,
//                id
//            )
//        } else {
//            serverQueries.insert(
//                model.title,
//                model.url,
//                model.token
//            )
//        }
//    }

    fun saveServer(title: String, url: String, token: String) {
        serverQueries.insert(title, url, token)
    }

    fun updateServer(title: String, url: String, token: String, id: Long) {
        serverQueries.update(title, url, token, id)
    }

    fun delete(id: Long) {
        serverQueries.deleteByID(id)
    }
}