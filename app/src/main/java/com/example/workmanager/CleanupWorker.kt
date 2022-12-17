package com.example.workmanager


import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.File
private const val TAG = "CleanupWorker"

class CleanupWorker(context: Context, workerParams: WorkerParameters) :Worker(context, workerParams) {
    override fun doWork(): Result {
        // Makes a notification when the work starts and slows down the work so that
        // it's easier to see each WorkRequest start, even on emulated devices
        makeStatusNotification("Cleaning up old temporary files",applicationContext)
        sleep()
        return try {
            val outputDir=File(applicationContext.filesDir,OUTPUT_PATH)
            if (outputDir.exists()){
                val entries =outputDir.listFiles()
                if (entries !=null){
                    for (i in entries){
                        val name = i.name
                        if (name.isNotEmpty()&&name.endsWith(".png")){
                            val delete = i.delete()
                            Log.i(TAG, "Deleted $name - $delete")
                        }
                    }

                }
            }
            Result.success()
        }catch (exception: Exception) {
            exception.printStackTrace()
            Result.failure()
        }

    }
}