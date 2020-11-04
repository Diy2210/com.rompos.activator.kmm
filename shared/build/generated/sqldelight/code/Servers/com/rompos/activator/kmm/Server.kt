package com.rompos.activator.kmm

import kotlin.Long
import kotlin.String

data class Server(
  val ID: Long,
  val title: String?,
  val url: String?,
  val token: String?
) {
  override fun toString(): String = """
  |Server [
  |  ID: $ID
  |  title: $title
  |  url: $url
  |  token: $token
  |]
  """.trimMargin()
}
