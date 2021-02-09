package com.rompos.activator.kmm.shared.api

import com.rompos.activator.kmm.Server
import com.rompos.activator.kmm.shared.model.PluginModel
import io.ktor.client.request.forms.submitForm
import io.ktor.http.Parameters
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

class PluginActivatorApi {
    private val client = HttpClient()
//    private val client = HttpClient() {
//        install(JsonFeature) {
//            val json = Json { ignoreUnknownKeys = true }
//            serializer = KotlinxSerializer(json)
//        }
//    }

    suspend fun getPluginsList(server: Server): String {
        return client.get("${server.url}/wp-json/deactivator/v1/list?token=${server.token}")
    }

    suspend fun updatePluginStatus(server: Server, pluginModel: PluginModel, state: Boolean): String {
        var status = "deactivate"
            if (state) {
                status = "activate"
            }
        val params = Parameters.build {
            append("token", server.token.toString())
            append("id", pluginModel.plugin)
            append("status", status)
        }

        println(params.toString())
        return client.submitForm("${server.url}/wp-json/deactivator/v1/update", params)
    }
}