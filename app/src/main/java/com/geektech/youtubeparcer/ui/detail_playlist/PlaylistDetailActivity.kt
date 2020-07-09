package com.geektech.youtubeparcer.ui.detail_playlist

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.model.Item
import kotlinx.android.synthetic.main.activity_playlist_detail.*

class PlaylistDetailActivity : AppCompatActivity() {
    var item: Item? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_detail)
        Toast.makeText(this, intent.getIntExtra("position", 0).toString(), Toast.LENGTH_SHORT ).show()
        tv_big_title.text = item?.snippet?.title

    }
}
