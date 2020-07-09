package com.geektech.youtubeparcer.ui.detail_playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.model.PlayList
import com.geektech.youtubeparcer.ui.playlist.PlaylistViewHolder
import kotlinx.android.synthetic.main.item_detail_playlist.view.*

class PlaylistDetailAdapter : RecyclerView.Adapter<PlaylistDetailViewHolder>() {
    private var list: MutableList<PlayList>? = null


    fun update(list: MutableList<PlayList>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistDetailViewHolder {
        return PlaylistDetailViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_detail_playlist, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlaylistDetailViewHolder, position: Int) {
        holder.onBind(list?.get(position))
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

}

class PlaylistDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(video: PlayList?) {
    itemView.tv_title_video.text = video?.kind
    }
    fun viewHoldersClick(inter: PlaylistViewHolder.OnClickVH) {
        itemView.setOnClickListener {
            inter.onClickV(adapterPosition)
        }
    }

    interface OnClickVideo {
        fun onClickVideo(position: Int)
    }


}