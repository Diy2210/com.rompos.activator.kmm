package com.rompos.activator.kmm.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class PluginResponseModel(
    val success: Boolean,
    val data: List<PluginModel>
)
