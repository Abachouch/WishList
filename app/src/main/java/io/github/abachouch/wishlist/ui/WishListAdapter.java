package io.github.abachouch.wishlist.ui;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.abachouch.wishlist.R;
import io.github.abachouch.wishlist.data.Wish;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.MyViewHolder> {


    ConstraintLayout selectedView;
    private ArrayList<Wish> mDataset;
    Fragment parentFragment ;
    int myExpandedPosition ;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mItemLayout;

        public MyViewHolder(View v) {
            super(v);

            mItemLayout = v;
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public WishListAdapter(Fragment parentFragment , ArrayList<Wish> myDataset) {
        mDataset = myDataset;
        this.parentFragment = parentFragment ;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public WishListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wish_list_recycler_view_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Wish w = mDataset.get(position);
        final ConstraintLayout cl = (ConstraintLayout) holder.mItemLayout;




        // button Delete
        ImageButton delete = (ImageButton) cl.getViewById(R.id.wishListItemBtnDelete);
        delete.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {

            }
        });
        // button Update
        ImageButton update = (ImageButton) cl.getViewById(R.id.wishListItemBtnEdit);
        update.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                update( ) ;

            }
        });


        // layout event
         boolean isExpanded =  position == myExpandedPosition ;




        cl.getViewById(R.id.wishListItemInfo).setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        cl.getViewById(R.id.wishListItemBtnEdit).setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        cl.getViewById(R.id.wishListItemBtnDelete).setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        cl.setActivated(isExpanded );

        //toggle(cl , isExpanded);


        cl.setOnClickListener( (v) -> {
            myExpandedPosition = isExpanded ? -1 : position ;
            TransitionManager.beginDelayedTransition(cl);
            notifyDataSetChanged();
        });





        //close(cl);
        ((TextView) cl.getViewById(R.id.wishListItemTitle)).setText(w.getTitle());
        ((TextView) cl.getViewById(R.id.wishListItemCost)).setText(Float.toString(w.getCost()));
        ((TextView) cl.getViewById(R.id.wishListItemInfo)).setText(w.getInfo());


    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    /**
     *
     *
     *
     *
     *
     *  --- CUSTOM FUNCTIONS ---
     *
     *
     *
     *
     *
     */


    void update(){
        Wish o = mDataset.get(1);
        mDataset.set(1 , o) ;


        EditDialog e = new EditDialog() ;
        e.getShowsDialog( );
        //e.show( parentFragment.getActivity(), "Error de conexión al servidor");
        e.show(parentFragment.getFragmentManager() , "hellp"); ;
        notifyDataSetChanged();

    }



}
