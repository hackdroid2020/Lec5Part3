package edu.tomerbu.lec5part3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentLetters f;

    int i = 0;
    String[] arr = {
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        f = new FragmentLetters();
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.frame_container, f).
                commit();

        findViewById(R.id.button_back).setOnClickListener(v -> {
            i--;
            if (i < 0) i = arr.length - 1;
            f.changeLetter(arr[i]);
        });

        findViewById(R.id.button_next).setOnClickListener(v -> {
            i++;
            if (i >= arr.length) i = 0;
            f.changeLetter(arr[i]);
        });
    }
}
