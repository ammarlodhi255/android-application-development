package com.example.workmanagermiddleobservation

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.work.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actClass.actRef=this
    }

    fun increment(v: View)
    {

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val request : OneTimeWorkRequest =OneTimeWorkRequest.Builder(TestWorker::class.java)
            .setConstraints(constraints)
            .build()

        val workManager: WorkManager = WorkManager.getInstance(this)

        workManager.enqueueUniqueWork("dummy",ExistingWorkPolicy.REPLACE,request)

        WorkManager.getInstance(this).getWorkInfosForUniqueWorkLiveData("dummy")
            .observe(this) { workInfo ->

                Log.d("WorkInfo object..","Size is :"+workInfo.size);

                if(workInfo[0].state == WorkInfo.State.SUCCEEDED) {
                    val handler= Handler(Looper.getMainLooper())

                    handler.post {
                        Toast.makeText(this,"SUCCEEDED",Toast.LENGTH_LONG).show()
                    }
                }

                else if(workInfo[0].state == WorkInfo.State.ENQUEUED)
                {
                    val handler= Handler(Looper.getMainLooper())
                    handler.post {
                        Toast.makeText(this,"ENQUEUED BUT HAS NOT SUCCEEDED",Toast.LENGTH_LONG).show()
                    }
                }

            }
    }

    class TestWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams){
        val cont = context
        override fun doWork(): Result {

            val pb:ProgressBar = actClass.actRef!!.findViewById(R.id.progressBar)
            pb.progress+=10

            return Result.success()
        }

    }}
class actClass{

    companion object{
        var actRef: Activity?=null
    }
}