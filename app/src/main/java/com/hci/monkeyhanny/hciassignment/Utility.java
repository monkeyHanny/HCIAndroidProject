package com.hci.monkeyhanny.hciassignment;

import android.graphics.Color;

/**
 * Created by monkeyhanny on 23/11/2017.
 */

public class Utility {
    //Mifflin St. Jeor Equation for Basal Metabolic Rate
    public static double getBMR(boolean ifMan, int height, int weight, int age) {
        double bmr = 10 * weight + 6.25 * height - 5 * age;

        if (ifMan)
            bmr += 5;
        else
            bmr -= 161;

        return bmr;
    }


}
