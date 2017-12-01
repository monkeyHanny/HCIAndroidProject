package com.hci.monkeyhanny.hciassignment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

/**
 * Created by monkeyhanny on 30/11/2017.
 */

public class WeeklySummaryFragment extends Fragment {
    private ImageButton barChart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weekly_summary, container, false);
        barChart = v.findViewById(R.id.btnBarChart);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        barChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DailySummaryFragment f = new DailySummaryFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
            }
        });
    }
}
