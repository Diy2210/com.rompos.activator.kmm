package com.rompos.activator.kmm.shared

import com.rompos.activator.kmm.databes.Servers
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Servers.Schema, "servers.db")
    }
}