package com.example.ships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivityLauncher extends FragmentActivity {
    private Button getStartedButton;
    Fragment selectedFragment = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);
        getStartedButton = findViewById(R.id.startButton);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick: is clicked");
                selectedFragment = new MainActivity();//Parks

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_launcher, selectedFragment)
                        .commit();
                return;

//                startActivity(new Intent(MainActivityLauncher.this,MainActivity.class));


            }
        });
    }
}