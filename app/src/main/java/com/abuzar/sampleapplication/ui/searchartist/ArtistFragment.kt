package com.abuzar.sampleapplication.ui.searchartist

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.abuzar.sampleapplication.R
import com.abuzar.sampleapplication.base.BaseFragment
import com.abuzar.sampleapplication.data.model.ApiResponse
import com.abuzar.sampleapplication.data.model.ArtistModel
import com.abuzar.sampleapplication.databinding.FragmentArtistBinding
import com.abuzar.sampleapplication.utils.ARTIST_MODEL
import com.abuzar.sampleapplication.utils.SEARCH_ARTIST_NAVIGATOR
import org.koin.android.ext.android.setProperty
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by ABUZAR on 9/1/2019.
 */

class ArtistFragment : BaseFragment<FragmentArtistBinding>(), ArtistNavigator {

    lateinit var adapter: ArtistAdapter
    private val searchArtistViewModel: ArtistViewModel by viewModel()
    private var artistList: List<ArtistModel>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setProperty(SEARCH_ARTIST_NAVIGATOR, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        searchArtistViewModel.getTidalApi("A")
        adapter = ArtistAdapter(this)
        val itemDecoration =
            DividerItemDecoration(
               context,
                DividerItemDecoration.VERTICAL
            )
        itemDecoration.setDrawable(resources.getDrawable(R.drawable.item_seperator))
        getBinding().list.addItemDecoration(itemDecoration)
        getBinding().list.setLayoutManager(LinearLayoutManager(context))
        getBinding().list.setAdapter(adapter)

        if (savedInstanceState != null) {
            artistList = savedInstanceState.getParcelableArrayList<ArtistModel>(ARTIST_MODEL)
            if (!artistList.isNullOrEmpty()) {
                adapter.submitList(artistList)
            }

        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_artist
    }

    override fun getViewModel(): ViewModel {
        return searchArtistViewModel
    }

    override fun launchAlbumFragment(artistModel: ArtistModel) {
        setProperty(ARTIST_MODEL, artistModel)
        findNavController().navigate(R.id.action_artist_to_album)
    }

    override fun setArtistList(t: ApiResponse<ArtistModel>) {
        artistList = t.dataList
        adapter.submitList(artistList)
    }

//    override fun onQueryTextChange(newText: String?): Boolean {
//        if (newText.isNullOrEmpty()) {
//            return false
//        } else {
//            queryString = newText
//            searchArtistViewModel.getTidalApi(newText)
//            return true
//        }
//    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        if (!artistList.isNullOrEmpty()) {
            savedInstanceState.putParcelableArrayList(
                ARTIST_MODEL,
                ArrayList<Parcelable>(artistList!!)
            )
        }
        super.onSaveInstanceState(savedInstanceState)
    }
}
