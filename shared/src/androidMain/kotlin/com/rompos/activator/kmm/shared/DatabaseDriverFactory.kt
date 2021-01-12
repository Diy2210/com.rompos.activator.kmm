package com.rompos.activator.kmm.shared

import android.content.Context
import com.rompos.activator.kmm.databes.Servers
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(Servers.Schema, context, "servers.db")
    }
}