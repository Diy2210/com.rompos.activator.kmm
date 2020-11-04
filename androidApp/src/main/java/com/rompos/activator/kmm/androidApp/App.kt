package com.rompos.activator.kmm.androidApp

import android.app.Application
import com.rompos.activator.kmm.databes.Servers
import com.rompos.activator.kmm.shared.base.initApplication
import com.squareup.sqldelight.android.AndroidSqliteDriver

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        initApplication(
            AndroidSqliteDriver(
                Servers.Schema,
                applicationContext,
                "servers.db"
            )
        )
    }
}
