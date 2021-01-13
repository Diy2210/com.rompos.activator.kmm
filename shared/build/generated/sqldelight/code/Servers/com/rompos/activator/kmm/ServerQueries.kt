package com.rompos.activator.kmm

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Long
import kotlin.String

interface ServerQueries : Transacter {
  fun <T : Any> selectAll(mapper: (
    ID: Long,
    title: String?,
    url: String?,
    token: String?
  ) -> T): Query<T>

  fun selectAll(): Query<Server>

  fun <T : Any> selectAllServers(mapper: (
    ID: Long,
    title: String?,
    url: String?,
    token: String?
  ) -> T): Query<T>

  fun selectAllServers(): Query<Server>

  fun <T : Any> selectByID(ID: Long, mapper: (
    ID: Long,
    title: String?,
    url: String?,
    token: String?
  ) -> T): Query<T>

  fun selectByID(ID: Long): Query<Server>

  fun insert(
    title: String?,
    url: String?,
    token: String?
  )

  fun update(
    title: String?,
    url: String?,
    token: String?,
    ID: Long
  )

  fun deleteByID(ID: Long)
}
