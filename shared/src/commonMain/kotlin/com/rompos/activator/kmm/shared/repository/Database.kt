package com.rompos.activator.kmm.shared.repository

import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.databes.Servers
import com.rompos.activator.kmm.shared.DatabaseDriverFactory

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Servers(databaseDriverFactory.createDriver())
    private val serverQueries = database.serverQueries

    fun getAll(): List<Server> {
        return serverQueries.selectAll().executeAsList()
    }

    fun get(id: Long): Server {
        return serverQueries.selectByID(id).executeAsOne()
    }

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