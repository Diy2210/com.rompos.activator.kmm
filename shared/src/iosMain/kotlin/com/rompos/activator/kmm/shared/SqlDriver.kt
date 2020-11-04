package com.rompos.activator.kmm.shared

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.rompos.activator.kmm.databes.Servers

actual fun getSqlDriver(databaseName: String): SqlDriver = NativeSqliteDriver(Servers.Schema, databaseName)
