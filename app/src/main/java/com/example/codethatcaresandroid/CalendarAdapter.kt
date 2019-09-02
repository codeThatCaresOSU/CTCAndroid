package com.example.codethatcaresandroid

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.ctc_event_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*

const val MINS_TO_MS: Long = 60000L

class CalendarAdapter(private val ctcEvents: ArrayList<CTCEvents>, private val callback: RecyclerCallbackInterface) : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tz = Calendar.getInstance().timeZone

        val monthInYearFormatter = SimpleDateFormat("LLL", Locale.ENGLISH)
        monthInYearFormatter.timeZone = tz
        val dayInMonthFormatter = SimpleDateFormat("d", Locale.ENGLISH)
        dayInMonthFormatter.timeZone = tz
        val timeFormatter = SimpleDateFormat("H", Locale.ENGLISH)
        timeFormatter.timeZone = tz
        val minuteFormatter = SimpleDateFormat("mm", Locale.ENGLISH)
        minuteFormatter.timeZone = tz
        val utc = ctcEvents[position].startTime

        val monthString = monthInYearFormatter.format(Date(utc * 1000))
        val dayString = dayInMonthFormatter.format(Date(utc * 1000))
        var timeString = timeFormatter.format(Date(utc * 1000))
        val minuteString = minuteFormatter.format(Date(utc * 1000))
        var amPm = "am"
        if(Integer.parseInt(timeString) > 12) {
            timeString = (Integer.parseInt(timeString) - 12).toString()
            amPm = "pm"
        }
        timeString = timeString + ":" + minuteString + " " + amPm

        holder.time.text = timeString
        holder.month.text = monthString
        holder.day.text = dayString
        holder.title.text = ctcEvents[position].title
        holder.details.text = ctcEvents[position].detail
        holder.location.text = ctcEvents[position].location
        try {
            holder.leftCalendarContainer.setBackgroundColor(Color.parseColor(ctcEvents[position].displayColor))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        holder.addToCal.setOnClickListener {

            val intent = Intent(Intent.ACTION_EDIT)
            intent.type = "vnd.android.cursor.item/event"
            intent.putExtra("title", ctcEvents[position].title)
            intent.putExtra("beginTime", ctcEvents[position].startTime * 1000L)
            intent.putExtra("endTime", (ctcEvents[position].startTime * 1000L) + (ctcEvents[position].duration * MINS_TO_MS))
            try {
                callback.startActivityFromAdapter(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(it.context, it.context.getString(R.string.no_activity_found), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ctc_event_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return ctcEvents.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.ctc_event_list_item
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val day = view.day_text_view
        val month = view.month_text_view
        val time = view.time_text_view
        val title = view.title_text_view
        val details = view.details_text_view
        val location = view.location_text_view
        val addToCal = view.add_to_calendar
        val leftCalendarContainer = view.left_calendar_view_container
    }

}

