/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.nudennie.android.devbyteviewer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.nudennie.android.devbyteviewer.database.VideoDatabase
import com.nudennie.android.devbyteviewer.database.asDomainModel
import com.nudennie.android.devbyteviewer.domain.Video
import com.nudennie.android.devbyteviewer.network.Network
import com.nudennie.android.devbyteviewer.network.asDatabaseModel
import kotlinx.coroutines.*

class VideosRepository(private val database: VideoDatabase, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {

	suspend fun refreshVideos() {
		withContext(dispatcher) {
			val playList = Network.devbytes.getPlaylist().await()

			database.videoDao.insertAll(*playList.asDatabaseModel())

		}
	}

	val videos: LiveData<List<Video>> = Transformations.map(database.videoDao.getVideos()) {
		it.asDomainModel()
	}


}
