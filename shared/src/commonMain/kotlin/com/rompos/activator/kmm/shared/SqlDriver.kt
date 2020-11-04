package com.rompos.activator.kmm.shared

import com.squareup.sqldelight.db.SqlDriver

expect fun getSqlDriver(databaseName: String): SqlDriver

