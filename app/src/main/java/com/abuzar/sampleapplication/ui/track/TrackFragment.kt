package com.abuzar.sampleapplication.ui.track

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.abuzar.sampleapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_track.*
import kotlinx.android.synthetic.main.fragment_track.artistName
import com.abuzar.sampleapplication.base.BaseFragment
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.TrackModel
import com.abuzar.sampleapplication.databinding.FragmentTrackBinding
import com.abuzar.sampleapplication.utils.TRACK_MODEL
import com.abuzar.sampleapplication.utils.TRACK_NAVIGATOR
import org.koin.android.ext.android.setProperty
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ABUZAR on 9/2/2019.
 */
class TrackFragment : BaseFragment<FragmentTrackBinding>(), TrackNavigator {


    lateinit var adapter: TrackAdapter
    private val trackViewModel: TrackViewModel by viewModel()
    private var trackList: List<TrackModel>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setProperty(TRACK_NAVIGATOR, this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trackViewModel.fetchTrackList()
        adapter = TrackAdapter(this, trackViewModel.getArtistModel())
        val itemDecoration = DividerItemDecoration(getBinding().root.context, DividerItemDecoration.VERTICAL)
        Picasso.get().load(trackViewModel.getAlbumModel().coverXl).into(iv)
        artistName.text = trackViewModel.getArtistModel().name
        albumName.text = trackViewModel.getAlbumModel().title
        getBinding().trackList.addItemDecoration(itemDecoration)
        getBinding().trackList.layoutManager = LinearLayoutManager(context)
        getBinding().trackList.adapter = adapter

        if(savedInstanceState!=null)
        {
            trackList = savedInstanceState.getParcelableArrayList<TrackModel>(TRACK_MODEL)
            if (!trackList.isNullOrEmpty()) {
                adapter.submitList(trackList)
            }
        }

    }

    override fun setTrackList(t: ApiResponse<TrackModel>) {
        trackList=t.dataList
        adapter.submitList(trackList)
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_track
    }

    override fun getViewModel(): ViewModel {
        return trackViewModel
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        if (!trackList.isNullOrEmpty()) {
            savedInstanceState.putParcelableArrayList(TRACK_MODEL, ArrayList<Parcelable>(trackList!!))
        }
        super.onSaveInstanceState(savedInstanceState)
    }
}