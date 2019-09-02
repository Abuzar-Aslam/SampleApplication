package com.abuzar.sampleapplication.ui.album

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.abuzar.sampleapplication.R
import com.abuzar.sampleapplication.base.BaseFragment
import com.abuzar.sampleapplication.data.model.AlbumModel
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.databinding.FragmentAlbumBinding
import com.abuzar.sampleapplication.utils.ALBUM_MODEL
import com.abuzar.sampleapplication.utils.ALBUM_NAVIGATOR
import org.koin.android.ext.android.setProperty
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ABUZAR on 9/1/2019.
 */

class AlbumFragment : BaseFragment<FragmentAlbumBinding>(), AlbumNavigator {


    lateinit var adapter: AlbumAdapter
    private var albumList: List<AlbumModel>? = null
    private val albumViewModel: AlbumViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setProperty(ALBUM_NAVIGATOR, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        albumViewModel.fetchAlbumList()
        adapter = AlbumAdapter(this, albumViewModel.getArtistModel())
        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        getBinding().albumList.addItemDecoration(itemDecoration)
        getBinding().albumList.layoutManager = GridLayoutManager(context, 2)
        getBinding().albumList.adapter = adapter

        if (savedInstanceState != null) {
            albumList = savedInstanceState.getParcelableArrayList<AlbumModel>(ALBUM_MODEL)
            if (!albumList.isNullOrEmpty()) {
                adapter.submitList(albumList)
            }
        }

    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_album
    }

    override fun getViewModel(): ViewModel {
        return albumViewModel
    }

    override fun launchTrackListFragment(albumModel: AlbumModel) {

        setProperty(ALBUM_MODEL, albumModel)
        findNavController().navigate(R.id.action_album_to_track)
    }


    override fun setAlbumList(t: ApiResponse<AlbumModel>) {
        albumList = t.dataList
        adapter.submitList(albumList)
    }

    override fun onBackButtonPressed() {
        finish()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        if (!albumList.isNullOrEmpty()) {
            savedInstanceState.putParcelableArrayList(
                ALBUM_MODEL,
                ArrayList<Parcelable>(albumList!!)
            )
        }
        super.onSaveInstanceState(savedInstanceState)
    }
}