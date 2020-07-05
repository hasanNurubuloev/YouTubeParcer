package com.geektech.youtubeparcer.ui.detail_playlist

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.youtubeparcer.R

class PlaylistDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist_detail)

        val intent = intent
        if (intent.extras != null) {
            val position: String? = intent.getStringExtra("pos")
            println(position)
            Toast.makeText(this, position, Toast.LENGTH_LONG).show()
        }
    }
}
