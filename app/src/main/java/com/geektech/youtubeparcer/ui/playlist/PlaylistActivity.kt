package com.geektech.youtubeparcer.ui.playlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.model.Item
import com.geektech.youtubeparcer.ui.detail_playlist.PlaylistDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class PlaylistActivity : AppCompatActivity(), PlaylistViewHolder.OnClickVH {

    private var list = mutableListOf<Item>()
    private var adapter: PlaylistAdapter = PlaylistAdapter(list, this)
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
                list.addAll(it.items)
                adapter.update(list)
            }
        })
    }

    override fun onClickV(position: Int) {
        val intent = Intent(this, PlaylistDetailActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }
}