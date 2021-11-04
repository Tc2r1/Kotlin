/*
 * Copyright (C) 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nudennie.kotlincoroutines.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.nudennie.kotlincoroutines.fakes.MainNetworkFake
import com.nudennie.kotlincoroutines.fakes.TitleDaoFake
import com.nudennie.kotlincoroutines.main.utils.MainCoroutineScopeRule
import com.nudennie.kotlincoroutines.main.utils.getValueForTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {
    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var subject: MainViewModel

    @Before
    fun setup() {
        subject = MainViewModel(
                TitleRepository(
                        MainNetworkFake("OK"),
                        TitleDaoFake("initial")
                ))
    }

    @Test
    fun whenMainClicked_updatesTaps() {
        subject.onMainViewClicked()
        Truth.assertThat(subject.taps.getValueForTest()).isEqualTo("0 taps")
        coroutineScope.advanceTimeBy(1_000)
        Truth.assertThat(subject.taps.getValueForTest()).isEqualTo("1 taps")
    }
}