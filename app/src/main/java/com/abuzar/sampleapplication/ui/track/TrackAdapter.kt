package com.abuzar.sampleapplication.ui.track

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abuzar.sampleapplication.R
import com.abuzar.sampleapplication.data.model.ArtistModel
import com.abuzar.sampleapplication.data.model.TrackModel

/**
 * Created by ABUZAR on 9/2/2019.
 */

class TrackAdapter(
    private val trackNavigator: TrackNavigator,
    private val artistModel: ArtistModel
) :
    ListAdapter<TrackModel, TrackAdapter.VH>(DifferentUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            artistModel,
            trackNavigator,
            LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    class VH(private val artistModel: ArtistModel, private val trackNavigator: TrackNavigator, view: View) :
        RecyclerView.ViewHolder(view) {

        private val trackName: TextView = view.findViewById(R.id.trackName)
        private val artistName: TextView = view.findViewById(R.id.artistName)
        private val count: TextView = view.findViewById(R.id.count)

        fun bind(trackModel: TrackModel) {

            trackName.text = trackModel.title
            artistName.text = artistModel.name
            count.text = trackModel.trackPosition
        }

    }
}

internal object DifferentUtil : DiffUtil.ItemCallback<TrackModel>() {
    override fun areItemsTheSame(oldItem: TrackModel, newItem: TrackModel) = oldItem == newItem

    override fun areContentsTheSame(oldItem: TrackModel, newItem: TrackModel): Boolean {
        return false
    }
}