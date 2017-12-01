package com.hci.monkeyhanny.hciassignment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.anastr.speedviewlib.TubeSpeedometer;

/**
 * Created by monkeyhanny on 30/11/2017.
 */

public class HomeFragment extends Fragment {
    boolean ifMan = true;
    int weight = 46;
    int height = 158;
    int age = 25;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        TubeSpeedometer tubeSpeedometer = v.findViewById(R.id.dailyCalorieMeter);

        ifMan = false;
        double bmr = Utility.getBMR(ifMan, height, weight, age);

        // change MAX calorie intake based on user profile
        tubeSpeedometer.setMaxSpeed(1800);
        // change calorie to current intake
        tubeSpeedometer.speedTo(1450.67f);

        Button btnBf = v.findViewById(R.id.btn_breakfast);
        btnBf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BreakfastFragment f = new BreakfastFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
            }
        });

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
