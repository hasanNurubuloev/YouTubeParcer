package com.geektech.youtubeparcer.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.model.Item
import kotlinx.android.synthetic.main.item_playlist.view.*

class PlaylistAdapter(//    var list: MutableList<PlayList>? = null
    var list: MutableList<Item>,
    var listener: PlaylistViewHolder.OnClickVH
) : RecyclerView.Adapter<PlaylistViewHolder>() {

    fun update(elements: MutableList<Item>) {
        list.addAll(elements)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.viewHoldersClick(listener)
    }

    override fun getItemCount(): Int {
        return list.size

    }
}

class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(items: Item) {
        Glide.with(itemView.context).load(items.snippet.thumbnails.default.url).into(itemView.img_playlist)
        itemView.tv_title_playlist.text = items.snippet.title
        itemView.tv_video_amount.text = items.contentDetails.itemCount.toString() + " video series"
    }

    fun viewHoldersClick(inter: OnClickVH) {
        itemView.setOnClickListener {
            inter.onClickV(adapterPosition)
        }
    }

    interface OnClickVH {
        fun onClickV(position: Int)
    }
}
