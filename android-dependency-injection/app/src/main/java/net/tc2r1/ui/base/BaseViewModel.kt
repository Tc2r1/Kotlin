package net.tc2r1.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.tc2r1.data.repository.BaseRepository

abstract class BaseViewModel(
    private val repository: BaseRepository
) : ViewModel() {
    suspend fun logout() = withContext(Dispatchers.IO) { repository.logout() }
}