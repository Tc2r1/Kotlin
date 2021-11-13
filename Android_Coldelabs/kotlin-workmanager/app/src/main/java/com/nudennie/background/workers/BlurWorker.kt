package com.nudennie.background.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import androidx.work.ListenableWorker.Result.*
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.nudennie.background.KEY_IMAGE_URI

private const val TAG = "BlurWorker"

class BlurWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    @Throws(IllegalArgumentException::class)
    override fun doWork(): Result {
        val appContext = applicationContext
        val resourceUri = inputData.getString(KEY_IMAGE_URI)
        makeStatusNotification("Blurring image", appContext)
        sleep()

        return try {
            if (TextUtils.isEmpty(resourceUri)) {
                Log.e(TAG, "Invalid input uri")
                throw IllegalArgumentException("Invalid Input Uri")
            }

            val resolver = appContext.contentResolver
            val picture =
                BitmapFactory.decodeStream(resolver.openInputStream(Uri.parse(resourceUri)))

            val output = blurBitmap(picture, appContext)

            // Writing Bitmap to a temp file
            val picUri = writeBitmapToFile(appContext, output)
            makeStatusNotification("Output is $picUri", appContext)

            val outputData = workDataOf(KEY_IMAGE_URI to picUri.toString())
            success(outputData)
        } catch (t: Throwable) {
            Log.e(TAG, "Error applying blur")
            t.printStackTrace()
            failure()
        }
    }
}
