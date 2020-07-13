package com.geektech.youtubeparcer.ui.detail_video

import android.app.Activity
import android.content.Intent
import android.text.method.ScrollingMovementMethod
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_video.*
import kotlinx.android.synthetic.main.item_video.*
import kotlinx.android.synthetic.main.playlist_detail_toolbar.view.*

class VideoActivity : BaseActivity(R.layout.activity_video) {
    private var viewModel: VideoViewModel? = null
    private val adapter = VideoAdapter()
    override fun setupUI() {
        viewModel = ViewModelProviders.of(this).get(VideoViewModel::class.java)

        //Recycler
        recycler_video_texts.layoutManager = LinearLayoutManager(this)
        recycler_video_texts.adapter = adapter

        clickBack()
    }

    override fun setupLiveData() {
        subscribeToDetailPlaylist()
    }

    private fun subscribeToDetailPlaylist() {
        videoId?.let {
            viewModel?.fetchSearchVideo(it)?.observe(this, Observer {
                if (!it?.items.isNullOrEmpty()) {
                    adapter.update(it?.items!!)
                }
            })
        }
    }
    private fun clickBack() {
        toolbar_v.back.setOnClickListener{finish()}
    }

    companion object {
        private var videoId: String? = null
        fun instance(activity: Activity?, videoId: String?, position: Int?) {
            val intent = Intent(activity, VideoActivity::class.java)
            activity?.startActivity(intent)
            this.videoId = videoId
        }
    }

}