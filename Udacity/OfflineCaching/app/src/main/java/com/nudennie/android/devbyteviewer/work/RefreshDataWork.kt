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

package com.nudennie.android.devbyteviewer.work

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker.Result.Retry
import androidx.work.ListenableWorker.Result.Success
import androidx.work.WorkerParameters
import com.nudennie.android.devbyteviewer.database.getDatabase
import com.nudennie.android.devbyteviewer.repository.VideosRepository
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {

	companion object {
		const val WORK_NAME = "RefreshDataWorker"
	}

	@SuppressLint("RestrictedApi")
	override suspend fun doWork(): Result {
		val database = getDatabase(applicationContext)
		val repository = VideosRepository(database)

		return try {
			repository.refreshVideos()
			Success()
		} catch(exception: HttpException) {
			Retry()
		}
	}
}
