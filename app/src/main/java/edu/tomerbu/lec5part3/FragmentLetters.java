package edu.tomerbu.lec5part3;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLetters extends Fragment {

    TextToSpeech tts;
    private TextView tvLetter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.letters_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvLetter = view.findViewById(R.id.textView);

        tts = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    //choose the language:
                    int ttsLang = tts.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(getContext(), "Language Not supported", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Ready", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void changeLetter(String letter) {
        tvLetter.setText(letter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(letter, TextToSpeech.QUEUE_FLUSH, null, letter + "ID");
        }else {
            tts.speak(letter, TextToSpeech.QUEUE_FLUSH, null);
        }

    }
}
