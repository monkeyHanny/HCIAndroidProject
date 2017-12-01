package com.hci.monkeyhanny.hciassignment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by monkeyhanny on 1/12/2017.
 */

public class BreakfastFragment extends Fragment {
    private RecyclerView foodList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton fab;

    private int[] myDataset = new int[6];

    private static String meal;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meals, container, false);
        foodList = v.findViewById(R.id.bfList);
        fab = v.findViewById(R.id.fab);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            meal = bundle.getString("bf", "");
            if(meal.equals("hokkienmee")){
                myDataset[1]=R.drawable.item_hokkien_mee;
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        myDataset[0] = R.drawable.item_prata;

        //changes in content do not change the layout size of the RecyclerView
        foodList.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        foodList.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new FoodListAdapter(myDataset);
        foodList.setAdapter(mAdapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodListFragment f = new FoodListFragment();
                Bundle bundle = new Bundle();
                bundle.putString("meal", "breakfast");
                f.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
            }
        });

        TextView title = getActivity().findViewById(getResources().getIdentifier("abText", "id", getActivity().getPackageName()));
        title.setText(R.string.btn_breakfast);


        ConstraintLayout parent = getActivity().findViewById(R.id.container);
        parent.setBackground(null);


    }


}
