package com.rompos.activator.kmm.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class PluginModel(
    val id: Long,
    val title: String,
    val plugin: String,
    val status: Boolean
)