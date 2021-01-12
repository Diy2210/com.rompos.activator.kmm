package com.rompos.activator.kmm.shared.repository

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

    fun get(id: Long): Server {
        return serverQueries.selectByID(id).executeAsOne()
    }

    fun save(id: Long, model: Server) {
        if (id > 0) {
            serverQueries.update(
                model.title,
                model.url,
                model.token,
                id
            )
        } else {
            serverQueries.insert(
                model.title,
                model.url,
                model.token
            )
        }
    }

    fun delete(id: Long) {
        serverQueries.deleteByID(id)
    }
}