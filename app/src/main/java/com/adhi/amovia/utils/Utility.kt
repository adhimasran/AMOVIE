package com.adhi.amovia.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.adhi.amovia.utils.Constants.BASE_URL_IMG
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Utility {

    fun ImageView.loadImage(path: String) {
        Glide.with(context)
            .load("${BASE_URL_IMG}${path}")
            .transform(RoundedCorners(20))
            .into(this)
    }

    fun Int.convertToTime(): String {
        return "${if (this / 60 > 0) "${this / 60}h " else ""}${this % 60}m"
    }

    fun String.convertToDate(): String {
        val format = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
        val date = LocalDate.parse(this)
        return date.format(format)
    }

    private fun view(state: Boolean): Int {
        return if (state) View.VISIBLE else View.GONE
    }

    fun ProgressBar.loading(state: Boolean) {
        visibility = view(state)
    }
}