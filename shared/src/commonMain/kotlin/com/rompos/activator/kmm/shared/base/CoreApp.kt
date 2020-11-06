package com.rompos.activator.kmm.shared.base

import com.squareup.sqldelight.db.SqlDriver
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import com.rompos.activator.kmm.shared.getSqlDriver
import com.rompos.activator.kmm.shared.repository.ServersRepository

class CoreApp(sqlDriver: SqlDriver) {
    var kodein = DI {
        bind() from singleton { ServersRepository(sqlDriver) }
    }
}

var isInitialized = false
//    private set
lateinit var myApp: CoreApp
//    private set

fun initApplication(sqlDriver: SqlDriver? = null) {
    if (!isInitialized) {
        myApp = CoreApp(sqlDriver ?: getSqlDriver("servers.db"))
        isInitialized = true
    }
}
