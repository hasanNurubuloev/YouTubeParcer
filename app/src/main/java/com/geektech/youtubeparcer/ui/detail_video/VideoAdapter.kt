package com.geektech.youtubeparcer.ui.detail_video

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.model.PlaylistItem
import kotlinx.android.synthetic.main.item_video.view.*

class VideoAdapter : RecyclerView.Adapter<VideoViewHolder>() {
    private var list = mutableListOf<PlaylistItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun update(list: MutableList<PlaylistItem>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

}

class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(item: PlaylistItem) {
        itemView.title_video.text = item.snippet?.title
        itemView.video_sub_title.text = item.snippet?.description

    }
}