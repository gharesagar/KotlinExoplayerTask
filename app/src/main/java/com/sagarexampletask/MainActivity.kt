package com.sagarexampletask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.sagarexampletask.models.Movie
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieRecyclerview: VideoPlayerRecyclerView
   // private lateinit var movieRecyclerview: TestRecyclerview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieRecyclerview = findViewById(R.id.movieRecyclerview)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        movieRecyclerview.setLayoutManager(layoutManager)
        val itemDecorator = VerticalSpacingItemDecorator(10)
        movieRecyclerview.addItemDecoration(itemDecorator)

        val getVideos = getVideos()
        movieRecyclerview.setMovieObjects(getVideos)
        val adapter = VideoPlayerRecyclerAdapter(getVideos, initGlide())
        movieRecyclerview.setAdapter(adapter)
    }

    private fun initGlide(): RequestManager {
        val options = RequestOptions()
            .placeholder(R.drawable.white_background)
            .error(R.drawable.white_background);

        return Glide.with(this)
            .setDefaultRequestOptions(options);
    }

    private fun getVideos(): ArrayList<Movie> {
        val moviesList: ArrayList<Movie> = ArrayList()

        moviesList.add( Movie("Sending Data to a New Activity with Intent Extras",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.png",
            "Description for media object #1", "trailer"))
        moviesList.add( Movie("REST API, Retrofit2, MVVM Course SUMMARY",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API+Retrofit+MVVM+Course+Summary.mp4",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API%2C+Retrofit2%2C+MVVM+Course+SUMMARY.png",
            "Description for media object #2", "teaser"))
        moviesList.add( Movie("MVVM and LiveData",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/MVVM+and+LiveData+for+youtube.mp4",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/mvvm+and+livedata.png",
            "Description for media object #3","trailer"))
        moviesList.add( Movie("Swiping Views with a ViewPager",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/SwipingViewPager+Tutorial.mp4",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Swiping+Views+with+a+ViewPager.png",
            "Description for media object #4","trailer"))


        return moviesList
    }

    override fun onStop() {
        if (movieRecyclerview != null) movieRecyclerview.releasePlayer()
        super.onStop()
    }

 /*   override fun onDestroy() {
        if (movieRecyclerview != null) movieRecyclerview.releasePlayer()
        super.onDestroy()
    }*/


}