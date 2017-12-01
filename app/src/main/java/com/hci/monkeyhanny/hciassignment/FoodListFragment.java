package com.hci.monkeyhanny.hciassignment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by monkeyhanny on 1/12/2017.
 */

public class FoodListFragment extends Fragment {
    private RecyclerView foodList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int[] myDataset = {R.drawable.item_hokkien_mee, R.drawable.item_lays, R.drawable.item_mee_rebus, R.drawable.item_prata,
            R.drawable.item_veggie, R.drawable.item_juice};
    private ImageButton btnPopup;

    private static String meal = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_food_list, container, false);
        foodList = v.findViewById(R.id.foodList);
        btnPopup = v.findViewById(R.id.btn_popup);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            meal = bundle.getString("meal", "");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //changes in content do not change the layout size of the RecyclerView
        foodList.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        foodList.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new FoodListAdapter(myDataset);
        foodList.setAdapter(mAdapter);

        foodList.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), foodList, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (position == 0) {
                            if (meal != null) {
                                if (meal.equals("breakfast")) {
                                    meal = null;
                                    BreakfastFragment f = new BreakfastFragment();
                                    Bundle b = new Bundle();
                                    b.putString("bf", "hokkienmee");
                                    f.setArguments(b);
                                    getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
                                }
                            } else {
                                btnPopup.setBackgroundResource(R.drawable.dialogbox_mee);
                                btnPopup.setVisibility(View.VISIBLE);
                            }


                        } else if (position == 1) {
                            if (meal != null) {
                                if (meal.equals("breakfast")) {

                                }
                            } else {
                                btnPopup.setBackgroundResource(R.drawable.dialogbox_chips);
                                btnPopup.setVisibility(View.VISIBLE);
                            }


                        }

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
            }
        });

    }
}
