package com.hci.monkeyhanny.hciassignment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.anastr.speedviewlib.Gauge;
import com.github.anastr.speedviewlib.Speedometer;
import com.github.anastr.speedviewlib.TubeSpeedometer;
import com.github.anastr.speedviewlib.util.OnPrintTickLabel;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    boolean ifMan = true;
    int weight = 46;
    int height = 158;
    int age = 25;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Log.d("home", "testing");
                    break;
                case R.id.navigation_weekly:
                    break;
                case R.id.navigation_food_list:
                    break;
                case R.id.navigation_profile:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        TubeSpeedometer tubeSpeedometer = findViewById(R.id.dailyCalorieMeter);

        ifMan = false;
        double bmr = Utility.getBMR(ifMan, height, weight, age);

        // change MAX calorie intake based on user profile
        tubeSpeedometer.setMaxSpeed((int) (bmr / 0.75));
        // change calorie to current intake
        tubeSpeedometer.speedTo(1450);




    }

}
