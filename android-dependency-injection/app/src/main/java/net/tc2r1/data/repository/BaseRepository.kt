package net.tc2r1.data.repository

import net.tc2r1.data.network.BaseApi
import net.tc2r1.data.network.SafeApiCall

abstract class BaseRepository(private val api: BaseApi) : SafeApiCall {

    suspend fun logout() = safeApiCall {
        api.logout()
    }
}