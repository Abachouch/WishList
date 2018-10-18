package io.github.abachouch.wishlist.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.github.abachouch.wishlist.R;
import io.github.abachouch.wishlist.data.Wish;
import io.github.abachouch.wishlist.data.WishService;


public class WichListFragment extends Fragment {



    private final String TAG = "WichListFragment-Yucef";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Wish> myDataset = new ArrayList<>();


    public WichListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        WishService ser = new WishService(this.getContext()) ;
        myDataset = ser.getAllWichs();

        View newView = inflater.inflate(R.layout.fragment_wich_list, container, false);
        mRecyclerView = (RecyclerView) newView.findViewById(R.id.recyclerViewWishList);

        Log.e(TAG, "onCreateView: the view we create is "+mRecyclerView);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(newView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
//
        mAdapter = new WishListAdapter(this ,myDataset);
        mRecyclerView.setAdapter(mAdapter);

        return newView;



    }

}
