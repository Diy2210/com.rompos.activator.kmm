package com.rompos.activator.kmm.shared

import com.squareup.sqldelight.db.SqlDriver

actual fun getSqlDriver(databaseName: String): SqlDriver {
    throw UninitializedPropertyAccessException("Call from Android module")
}
