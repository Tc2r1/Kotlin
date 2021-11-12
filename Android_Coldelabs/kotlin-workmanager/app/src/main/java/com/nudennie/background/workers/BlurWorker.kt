package com.nudennie.background.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.nudennie.background.R

private const val TAG = "BlurWorker"

class BlurWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val appContext = applicationContext

        makeStatusNotification("Hello", appContext)

        try {
            val picture = BitmapFactory.decodeResource(
                appContext.resources,
                R.drawable.android_cupcake
            )

            val output = blurBitmap(picture, appContext)

            // Writing Bitmap to a temp file
            val picUri = writeBitmapToFile(applicationContext, output)
            makeStatusNotification("Output is $picUri", appContext)
            return Result.success()
        } catch (t: Throwable) {
            Log.e(TAG, "Error applying blur")
            return Result.failure()
        }
    }
}
