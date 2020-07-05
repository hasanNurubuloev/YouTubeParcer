package com.geektech.youtubeparcer.ui.playlist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.model.PlayList
import com.geektech.youtubeparcer.ui.detail_playlist.PlaylistDetailActivity
import kotlinx.android.synthetic.main.activity_main.*


class PlaylistActivity : AppCompatActivity(), PlaylistViewHolder.OnClickVH {

    var list: MutableList<PlayList> = mutableListOf()
    var adapter: PlaylistAdapter = PlaylistAdapter(list, this)
    private var viewModel: PlaylistViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(PlaylistViewModel::class.java)

        recycler_playlist.layoutManager = LinearLayoutManager(this@PlaylistActivity)
        recycler_playlist.adapter = adapter

        setupToSubscribe()
    }

    private fun setupToSubscribe() {
        viewModel?.fetchPlaylist()?.observe(this, Observer {
            if (it != null) {
                adapter.update(PlayList(it.kind))
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onClickV(position: Int) {
        val intent = Intent(this, PlaylistDetailActivity::class.java)
        intent.putExtra("pos", position)
        startActivity(intent)
    }
}

/* создать свой апи кей
добавить в класс playlist поле "items"
отрисовать всё в адаптере
сделать переход на новую активити и передаете туда id и её отображаете тостом*/
