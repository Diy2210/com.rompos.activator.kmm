package com.rompos.activator.kmm.databes

import com.rompos.activator.kmm.ServerQueries
import com.rompos.activator.kmm.databes.shared.newInstance
import com.rompos.activator.kmm.databes.shared.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver

interface Servers : Transacter {
  val serverQueries: ServerQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = Servers::class.schema

    operator fun invoke(driver: SqlDriver): Servers = Servers::class.newInstance(driver)}
}
