package com.ansari.b21kasyntask

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener(){
            var mytask = MyTask()
            mytask.execute()
        }

    }


    inner class MyTask : AsyncTask<String,Int,String>(){

        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.visibility = View.VISIBLE

        }
        override fun doInBackground(vararg params: String?): String {
            for(i in 1..5){
                Thread.sleep(1000)
                publishProgress(i)
            }
            var res = "I have download the data"
            return res
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            var myvalue = values[0]
            textViewResult.text = myvalue.toString() + "% downloaded"
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)

            progressBar.visibility = View.GONE

            textViewResult.text = result
        }

    }
}
