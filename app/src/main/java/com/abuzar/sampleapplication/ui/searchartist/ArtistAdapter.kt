package com.abuzar.sampleapplication.ui.searchartist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.abuzar.sampleapplication.R
import com.abuzar.sampleapplication.data.model.ArtistModel
import com.squareup.picasso.Picasso
import com.abuzar.sampleapplication.utils.CircleImageView

/**
 * Created by ABUZAR on 9/1/2019.
 */

class ArtistAdapter(private val artistNavigator: ArtistNavigator) :
    ListAdapter<ArtistModel, ArtistAdapter.VH>(DifferentUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            artistNavigator,
            LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    class VH(private val artistNavigator: ArtistNavigator, view: View) :
        RecyclerView.ViewHolder(view) {

        private val iv: ImageView = view.findViewById(R.id.iv)
        private val name: TextView = view.findViewById(R.id.name)

        fun bind(artistModel: ArtistModel) {
            Picasso.get().load(artistModel.picture).transform(CircleImageView()).into(iv)

            name.text = artistModel.name
            itemView.setOnClickListener {
                artistNavigator.launchAlbumFragment(artistModel = artistModel)
            }
        }

    }
}

internal object DifferentUtil : DiffUtil.ItemCallback<ArtistModel>() {
    override fun areItemsTheSame(oldItem: ArtistModel, newItem: ArtistModel) = oldItem == newItem

    override fun areContentsTheSame(oldItem: ArtistModel, newItem: ArtistModel): Boolean {
        return false
    }
}