package com.hci.monkeyhanny.hciassignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by monkeyhanny on 1/12/2017.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {
    private int[] mDataset;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton imgBtn;

        public ViewHolder(View v) {
            super(v);
            imgBtn = v.findViewById(R.id.list_item);
        }
    }


    public FoodListAdapter(int[] myDataset) {
        this.mDataset = myDataset;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public FoodListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int imgId = mDataset[position];

        ImageButton btn = holder.imgBtn;
        btn.setBackgroundResource(imgId);
        btn.setEnabled(true);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }


}
