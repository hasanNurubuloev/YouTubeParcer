package com.geektech.youtubeparcer.ui.playlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.model.PlaylistItem
import com.geektech.youtubeparcer.ui.detail_playlist.PlaylistDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class PlaylistActivity : AppCompatActivity(), PlaylistViewHolder.OnClickVH {

    private var list = mutableListOf<PlaylistItem>()
    private var adapter: PlaylistAdapter = PlaylistAdapter(this)
    private var viewModel: PlaylistViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_playlist.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_playlist.adapter = adapter
        viewModel = ViewModelProviders.of(this).get(PlaylistViewModel::class.java)
        setupToSubscribe()
    }

    private fun setupToSubscribe() {
        viewModel?.fetchPlaylist()?.observe(this, Observer {
            if (it != null) {
                adapter.update(it.items)
            }
        })
    }

    override fun onClickV(dto: PlaylistItem, position: Int) {
        PlaylistDetailActivity.instance(this, dto.id)
    }
}