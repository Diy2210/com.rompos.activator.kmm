package com.rompos.activator.kmm.shared.model

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import com.rompos.activator.kmm.Server

@Parcelize
data class ServerViewModel(
    var ID: Long? = null,
    var title: String? = null,
    var url: String? = null,
    var token: String? = null
): ViewModel(), Parcelable {

    fun setModel(server: Server) : ServerViewModel {
        ID = server.ID
        title = server.title.toString()
        url = server.url.toString()
        token = server.token.toString()

        return this
    }
}