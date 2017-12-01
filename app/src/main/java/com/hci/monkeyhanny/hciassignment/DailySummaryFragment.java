package com.hci.monkeyhanny.hciassignment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class DailySummaryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_daily_summary, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView title = getActivity().findViewById(getResources().getIdentifier("abText", "id", getActivity().getPackageName()));
        title.setText(R.string.title_daily_summary);
        setHasOptionsMenu(true);
    }
}
