package com.sagarexampletask

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.sagarexampletask.models.Movie

class VideoPlayerViewHolder(var parent: View) : RecyclerView.ViewHolder(parent) {
    var media_container: FrameLayout
    var title: TextView
    var thumbnail: ImageView
    var volumeControl: ImageView
    var progressBar: ProgressBar
    var requestManager: RequestManager? = null

    fun onBind(movie: Movie, requestManager: RequestManager?) {
        this.requestManager = requestManager
        parent.tag = this
        title.text = movie.title
        this.requestManager?.load(movie.thumbnail)
            ?.into(thumbnail)
    }

    init {
        media_container = parent.findViewById(R.id.media_container)
        thumbnail = parent.findViewById(R.id.thumbnail)
        title = parent.findViewById(R.id.title)
        progressBar = parent.findViewById(R.id.progressBar)
        volumeControl = parent.findViewById(R.id.volume_control)
    }
}