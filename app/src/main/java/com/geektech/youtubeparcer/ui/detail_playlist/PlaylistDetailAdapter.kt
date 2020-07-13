package com.geektech.youtubeparcer.ui.detail_playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.extention.loadImage
import com.geektech.youtubeparcer.model.PlaylistItem
import kotlinx.android.synthetic.main.item_detail.view.*

class PlaylistDetailAdapter(
    private val inter: PlaylistDetailViewHolder.OnClickVideo
) :
    RecyclerView.Adapter<PlaylistDetailViewHolder>() {
    private var list = mutableListOf<PlaylistItem>()

    fun update(list: MutableList<PlaylistItem>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistDetailViewHolder {
        return PlaylistDetailViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_detail, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlaylistDetailViewHolder, position: Int) {
        holder.onBind(list[position], inter)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class PlaylistDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(item: PlaylistItem, listener: OnClickVideo) {
        itemView.detail_image.loadImage(itemView.context, item.snippet?.thumbnails?.high?.url)
        itemView.detail_video_name.text = item.snippet!!.channelTitle
        itemView.detail_time.text = item.contentDetails!!.itemCount

        itemView.setOnClickListener { listener.onClickVideo(item, adapterPosition) }
    }

    interface OnClickVideo {
        fun onClickVideo(dto: PlaylistItem, position: Int)
    }
}