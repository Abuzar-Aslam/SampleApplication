package com.abuzar.sampleapplication.ui.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.abuzar.sampleapplication.R
import com.abuzar.sampleapplication.data.model.AlbumModel
import com.abuzar.sampleapplication.data.model.ArtistModel
import com.squareup.picasso.Picasso

/**
 * Created by ABUZAR on 9/1/2019.
 */

class AlbumAdapter(
    private val albumNavigator: AlbumNavigator,
    private val artistModel: ArtistModel
) :
    ListAdapter<AlbumModel, AlbumAdapter.VH>(DifferentUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            artistModel,
            albumNavigator,
            LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    class VH(private val artistModel: ArtistModel, private val albumNavigator: AlbumNavigator, view: View) :
        RecyclerView.ViewHolder(view) {

        private val iv: ImageView = view.findViewById(R.id.iv)
        private val albumTitle: TextView = view.findViewById(R.id.albumTitle)
        private val artistName: TextView = view.findViewById(R.id.artistName)

        fun bind(albumModel: AlbumModel) {
            Picasso.get().load(albumModel.coverBig).into(iv)

            artistName.text = artistModel.name
            albumTitle.text = albumModel.title
            itemView.setOnClickListener {
                albumNavigator.launchTrackListFragment(albumModel = albumModel)
            }
        }

    }
}

internal object DifferentUtil : DiffUtil.ItemCallback<AlbumModel>() {
    override fun areItemsTheSame(oldItem: AlbumModel, newItem: AlbumModel) = oldItem == newItem

    override fun areContentsTheSame(oldItem: AlbumModel, newItem: AlbumModel): Boolean {
        return false
    }
}