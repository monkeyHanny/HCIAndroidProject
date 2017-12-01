package com.hci.monkeyhanny.hciassignment;

import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class BaseActivity extends AppCompatActivity {

    private BottomBar navigation;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.custom_actionbar);


        navigation = findViewById(R.id.navigation);

        parent = findViewById(R.id.container);
        final TextView title = findViewById(getResources().getIdentifier("abText", "id", getPackageName()));
        navigation.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment f = null;


                switch (tabId) {
                    case R.id.tab_home:

                        title.setText(R.string.title_home);
                        parent.setBackgroundResource(R.drawable.bg_home);
                        f = new HomeFragment();
                        getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
                        break;
                    case R.id.tab_weekly:
                        title.setText(R.string.title_weekly_summary);
                        parent.setBackground(null);
                        f = new WeeklySummaryFragment();
                        getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
                        break;
                    case R.id.tab_meal:
                        title.setText(R.string.title_list_of_food);
                        parent.setBackground(null);
                        f = new FoodListFragment();
                        getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
                        break;
                    case R.id.tab_profile:
                        title.setText(R.string.title_edit_profile);
                        parent.setBackground(null);
                        f = new EditProfileFragment();
                        getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
                        break;


                }

            }


        });
        navigation.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Fragment f = null;
                switch (tabId) {
                    case R.id.tab_home:
                        title.setText(R.string.title_home);
                        parent.setBackgroundResource(R.drawable.bg_home);
                        f = new HomeFragment();
                        getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
                        break;
                    case R.id.tab_weekly:
                        title.setText(R.string.title_weekly_summary);
                        parent.setBackground(null);
                        f = new WeeklySummaryFragment();
                        getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
                        break;
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        TextView title = findViewById(getResources().getIdentifier("abText", "id", getPackageName()));
        switch (item.getItemId()) {
            case R.id.action_done:
                title.setText(R.string.title_home);
                parent.setBackgroundResource(R.drawable.bg_home);
                navigation.selectTabAtPosition(0);
                Fragment f = new HomeFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment, f).commit();
                return true;
        }
        return onOptionsItemSelected(item);
    }

}
