package com.example.ships.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Util {
    public static final String SHIPS_URL = "https://api.spacexdata.com/v3/ships/";

    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

}
