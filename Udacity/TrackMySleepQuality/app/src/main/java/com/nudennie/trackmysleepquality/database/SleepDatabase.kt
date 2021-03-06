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
 */

package com.nudennie.trackmysleepquality.database

import android.content.Context
import androidx.room.*

/**
 * A database that stores SleepNight information.
 * And a global method to get access to the database.
 *
 * This pattern is pretty much the same for any database,
 * so you can reuse it.
 */
@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    /**
     * Connects the database to the DAO
     * */
    abstract val sleepDatabaseDao : SleepDatabaseDao

    /**
     * By designing a companion object, this allows me to add functions to the SleepDatabase class.
     *
     * For example, clients can call 'SleepDatabase.getInstance(context)' to instantiate a new
     * SleepDatabase.
     * */
    companion object {

        /**
         * INSTANCE will keep a reference to any database returned via getInstance.
         *
         * This will help avoid repeatedly initializing the database, which is expensive.
         *
         * The value of a volatile variable will never be cashed, and all writes and reads will
         * be done to and from the main memory. It means that changes made by one thread to shared
         * data are visible to other threads.
         * */
        @Volatile
        private var INSTANCE : SleepDatabase? = null

        /**
         * Helper function to get the database.
         *
         * If a database has already been retrieved, the previous database will be returned.
         * Otherwise, create a new one.
         *
         * This function is threadsafe, and callers should cache the result for
         * multiple database calls to avoid overhead.
         *
         * This is an example of a simple Singleton pattern that takes another Singleton as an argument
         * in Kotlin.
         *
         * @param context The application context Singleton, used to get access to the filesystem.*/

        fun getInstance(context : Context) : SleepDatabase {

            /**
             * Multiple threads can ask for the database at the same time, ensure I only initialize
             * it once by using synchronized. Only one thread may enter a synchronized block at a
             * time.
             * */
            synchronized(this) {
                // Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
                // Smart cast is only available to local variables.
                var instance = INSTANCE
                // If Instance is null, make a new database Instance.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SleepDatabase::class.java,
                        "sleep_history_database"
                    )

                        // Wipes and rebuilds instead of migrating if no Migration object.
                        .fallbackToDestructiveMigration()
                        .build()

                    // Assign INSTANCE to the newly created database.
                    INSTANCE = instance
                }
                // Return instance; smart cast to be non-null.
                return instance
            }
        }

    }
}