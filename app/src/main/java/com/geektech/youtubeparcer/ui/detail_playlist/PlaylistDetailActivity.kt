package com.geektech.youtubeparcer.ui.detail_playlist

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.base.BaseActivity
import com.geektech.youtubeparcer.model.PlaylistItem
import com.geektech.youtubeparcer.ui.detail_video.VideoActivity
import kotlinx.android.synthetic.main.activity_playlist_detail.*

class PlaylistDetailActivity : BaseActivity(R.layout.activity_playlist_detail),
    PlaylistDetailViewHolder.OnClickVideo {

    private lateinit var viewModel: PlaylistDetailViewModel
    private var adapter = PlaylistDetailAdapter(this)

    override fun setupUI() {
        viewModel = ViewModelProviders.of(this).get(PlaylistDetailViewModel::class.java)
        setupAdapter()
    }

    override fun setupLiveData() {
        subscribeToDetailPlaylist()
    }

    private fun setupAdapter() {
        detail_recycler.layoutManager = LinearLayoutManager(applicationContext)
        detail_recycler.adapter = adapter
    }

    private fun subscribeToDetailPlaylist() {
        id?.let {
            viewModel.fetchDetailPlaylist(it).observe(this, Observer {
                adapter.update(it?.items!!)
            })
        }
    }

    companion object {
        private var id: String? = null
        fun instance(activity: Activity?, id: String?) {
            val intent = Intent(activity, PlaylistDetailActivity::class.java)
            activity?.startActivity(intent)
            this.id = id
        }
    }

    override fun onClickVideo(dto: PlaylistItem, position: Int) {
        VideoActivity.instance(this, dto.snippet?.resourceId?.videoId, position)
    }
}
