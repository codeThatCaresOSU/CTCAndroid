package com.example.codethatcaresandroid

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.ArrayList

val events = ArrayList<CTCEvents>()
private const val url: String = "https://us-central1-ctcios.cloudfunctions.net/getAllEvents"
private lateinit var recycler: RecyclerView
private lateinit var viewAdapter: RecyclerView.Adapter<*>
private lateinit var viewManager: RecyclerView.LayoutManager

class ListViewFragment : Fragment(), RecyclerCallbackInterface {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.calendar_view_fragment, container, false)
        viewManager = LinearLayoutManager(context)
        viewAdapter = CalendarAdapter(events, this)
        recycler = rootView.findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        getJsonData(context!!).execute(url)
        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun startActivityFromAdapter(intent: Intent) {
        startActivity(intent)
    }

    class getJsonData(val c: Context) : AsyncTask<String, Void, ArrayList<CTCEvents>>() {
        override fun onPreExecute() {

        }

        override fun doInBackground(vararg urlString: String): ArrayList<CTCEvents> {
            val url: URL
            val response = StringBuffer()
            try {
                url = URL(urlString[0])
            } catch (e: MalformedURLException) {
                throw IllegalArgumentException("invalid url")
            }

            var conn: HttpURLConnection? = null
            try {
                conn = url.openConnection() as HttpURLConnection
                conn.doOutput = false
                conn.doInput = true
                conn.useCaches = false
                conn.requestMethod = "GET"
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                val status = conn.responseCode
                if (status != 200) {
                    throw IOException("Post failed with error code $status")
                } else {
                    val input = BufferedReader(InputStreamReader(conn.inputStream))
                    for(inputLine in input.lines()) {
                        response.append(inputLine)
                    }
                    input.close()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                conn?.disconnect()
            }
            return formatToJson(response.toString())
        }

        override fun onPostExecute(eventsList: ArrayList<CTCEvents>) {
            events.clear()
            events.addAll(eventsList)
            viewAdapter.notifyDataSetChanged()
        }

        private fun formatToJson(s: String): ArrayList<CTCEvents> {
            val eventsList = ArrayList<CTCEvents>()
            try {
                val response = JSONArray(s)
                for (i in 0 until response.length()) {
                    val json = response.getJSONObject(i)
                    val ctcEvents = CTCEvents(json)
                    eventsList.add(ctcEvents)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return eventsList
        }
    }
}