package com.geektech.youtubeparcer.ui.playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtubeparcer.R
import com.geektech.youtubeparcer.model.PlayList

class PlaylistAdapter(//    var list: MutableList<PlayList>? = null
    var list: MutableList<PlayList>,
    var listener: PlaylistViewHolder.OnClickVH
) : RecyclerView.Adapter<PlaylistViewHolder>() {

    fun update(element: PlayList) {
        list.add(element)
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
    var image: ImageView = itemView.findViewById(R.id.img_playlist)
    var tvTitle: TextView = itemView.findViewById(R.id.tv_title_playlist)
    var tvAmount: TextView = itemView.findViewById(R.id.tv_video_amount)

    fun onBind(video: PlayList) {
        tvTitle.text = video.kind
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
