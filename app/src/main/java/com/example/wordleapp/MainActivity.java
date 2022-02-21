package com.example.wordleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private View viewGrid0_0, viewGrid0_1, viewGrid0_2, viewGrid0_3, viewGrid0_4, viewGrid1_0, viewGrid1_1,
            viewGrid1_2, viewGrid1_3, viewGrid1_4, viewGrid2_0, viewGrid2_1, viewGrid2_2, viewGrid2_3,
            viewGrid2_4, viewGrid3_0, viewGrid3_1, viewGrid3_2, viewGrid3_3, viewGrid3_4, viewGrid4_0,
            viewGrid4_1, viewGrid4_2, viewGrid4_3, viewGrid4_4, viewGrid5_0, viewGrid5_1, viewGrid5_2,
            viewGrid5_3, viewGrid5_4, currentView;

    private TextView textGrid0_0, textGrid0_1, textGrid0_2, textGrid0_3, textGrid0_4, textGrid1_0, textGrid1_1,
            textGrid1_2, textGrid1_3, textGrid1_4, textGrid2_0, textGrid2_1, textGrid2_2, textGrid2_3,
            textGrid2_4, textGrid3_0, textGrid3_1, textGrid3_2, textGrid3_3, textGrid3_4, textGrid4_0,
            textGrid4_1, textGrid4_2, textGrid4_3, textGrid4_4, textGrid5_0, textGrid5_1, textGrid5_2,
            textGrid5_3, textGrid5_4, currentTextView;

    boolean isRowFull = false;

    String[] keys = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h",
    "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};

    int currentColumn = 0;
    int currentRow = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// ------------------------- ENTER AND DELETE BUTTONS ------------------------------------------------------

        AppCompatButton enterButton = findViewById(R.id.enterButton);
        AppCompatButton deleteButton = findViewById(R.id.deleteButton);

// ------------------------- GRID VIEWS ------------------------------------------------------

        viewGrid0_0 = findViewById(R.id.viewGrid0_0); viewGrid0_1 = findViewById(R.id.viewGrid0_1);
        viewGrid0_2 = findViewById(R.id.viewGrid0_2); viewGrid0_3 = findViewById(R.id.viewGrid0_3);
        viewGrid0_4 = findViewById(R.id.viewGrid0_4); viewGrid1_0 = findViewById(R.id.viewGrid1_0);
        viewGrid1_1 = findViewById(R.id.viewGrid1_1); viewGrid1_2 = findViewById(R.id.viewGrid1_2);
        viewGrid1_3 = findViewById(R.id.viewGrid1_3); viewGrid1_4 = findViewById(R.id.viewGrid1_4);
        viewGrid2_0 = findViewById(R.id.viewGrid2_0); viewGrid2_1 = findViewById(R.id.viewGrid2_1);
        viewGrid2_2 = findViewById(R.id.viewGrid2_2); viewGrid2_3 = findViewById(R.id.viewGrid2_3);
        viewGrid2_4 = findViewById(R.id.viewGrid2_4); viewGrid3_0 = findViewById(R.id.viewGrid3_0);
        viewGrid3_1 = findViewById(R.id.viewGrid3_1); viewGrid3_2 = findViewById(R.id.viewGrid3_2);
        viewGrid3_3 = findViewById(R.id.viewGrid3_3); viewGrid3_4 = findViewById(R.id.viewGrid3_4);
        viewGrid4_0 = findViewById(R.id.viewGrid4_0); viewGrid4_1 = findViewById(R.id.viewGrid4_1);
        viewGrid4_2 = findViewById(R.id.viewGrid4_2); viewGrid4_3 = findViewById(R.id.viewGrid4_3);
        viewGrid4_4 = findViewById(R.id.viewGrid4_4); viewGrid5_0 = findViewById(R.id.viewGrid5_0);
        viewGrid5_1 = findViewById(R.id.viewGrid5_1); viewGrid5_2 = findViewById(R.id.viewGrid5_2);
        viewGrid5_3 = findViewById(R.id.viewGrid5_3); viewGrid5_4 = findViewById(R.id.viewGrid5_4);

// ------------------------- GRID TEXT VIEWS ------------------------------------------------------

        textGrid0_0 = findViewById(R.id.textGrid0_0); textGrid0_1 = findViewById(R.id.textGrid0_1);
        textGrid0_2 = findViewById(R.id.textGrid0_2); textGrid0_3 = findViewById(R.id.textGrid0_3);
        textGrid0_4 = findViewById(R.id.textGrid0_4); textGrid1_0 = findViewById(R.id.textGrid1_0);
        textGrid1_1 = findViewById(R.id.textGrid1_1); textGrid1_2 = findViewById(R.id.textGrid1_2);
        textGrid1_3 = findViewById(R.id.textGrid1_3); textGrid1_4 = findViewById(R.id.textGrid1_4);
        textGrid2_0 = findViewById(R.id.textGrid2_0); textGrid2_1 = findViewById(R.id.textGrid2_1);
        textGrid2_2 = findViewById(R.id.textGrid2_2); textGrid2_3 = findViewById(R.id.textGrid2_3);
        textGrid2_4 = findViewById(R.id.textGrid2_4); textGrid3_0 = findViewById(R.id.textGrid3_0);
        textGrid3_1 = findViewById(R.id.textGrid3_1); textGrid3_2 = findViewById(R.id.textGrid3_2);
        textGrid3_3 = findViewById(R.id.textGrid3_3); textGrid3_4 = findViewById(R.id.textGrid3_4);
        textGrid4_0 = findViewById(R.id.textGrid4_0); textGrid4_1 = findViewById(R.id.textGrid4_1);
        textGrid4_2 = findViewById(R.id.textGrid4_2); textGrid4_3 = findViewById(R.id.textGrid4_3);
        textGrid4_4 = findViewById(R.id.textGrid4_4); textGrid5_0 = findViewById(R.id.textGrid5_0);
        textGrid5_1 = findViewById(R.id.textGrid5_1); textGrid5_2 = findViewById(R.id.textGrid5_2);
        textGrid5_3 = findViewById(R.id.textGrid5_3); textGrid5_4 = findViewById(R.id.textGrid5_4);


// ------------------------- BUTTONS LISTENERS ------------------------------------------------------

        deleteButton.setOnClickListener(view -> {
            isRowFull = false;
            if (currentColumn != 0){
                currentColumn--;
            }
            removeLetter(currentColumn, currentRow);
        });

        enterButton.setOnClickListener(view -> {
            if (currentColumn != 5){
                Toast.makeText(MainActivity.this, "Please enter a five letter word", Toast.LENGTH_SHORT).show();
            } else{
                String[] guessedWord = getGuessedWord(currentRow);
                CompareWords compare = new CompareWords();

                Integer[] colours = compare.compareWords(guessedWord);
                displayColoursOnViews(colours, currentRow);

                currentRow++;
                currentColumn = 0;
                isRowFull = false;
            }
        });

        for (String key : keys){ // <- Setting up listeners for each keyboard button (exlcu enter and delete buttons)
            String buttonID = key + "Button";
            AppCompatButton currentButton = findViewById(getResources().getIdentifier(buttonID, "id", getPackageName()));
            currentButton.setOnClickListener(view -> generalKeyClick(key.toUpperCase(Locale.ROOT)));
        }

    }

    private void displayColoursOnViews(Integer[] colours, int currentRow){
        String currentViewID, currentTextViewID, buttonID;
        View currentView;
        TextView currentTextView;
        AppCompatButton currentButton;

        for (int i = 0; i < colours.length; i++){
            currentViewID = "viewGrid" + currentRow + "_" + i;
            currentTextViewID = "textGrid" + currentRow + "_" + i;
            currentView = findViewById(getResources().getIdentifier(currentViewID, "id", getPackageName()));
            currentTextView = findViewById(getResources().getIdentifier(currentTextViewID, "id", getPackageName()));

            buttonID = currentTextView.getText().toString().toLowerCase(Locale.ROOT) + "Button";
            currentButton = findViewById(getResources().getIdentifier(buttonID, "id", getPackageName()));

            if (colours[i] == null){
                currentView.setBackgroundColor(getResources().getColor(R.color.key_black));
                currentButton.setBackgroundResource(R.drawable.key_black_colour);
            } else if (colours[i] == 1){
                currentView.setBackgroundColor(getResources().getColor(R.color.key_green));
                currentButton.setBackgroundResource(R.drawable.key_green_colour);
            } else {
                currentView.setBackgroundColor(getResources().getColor(R.color.key_yellow));
                currentButton.setBackgroundResource(R.drawable.key_yellow_colour);
            }
        }
    }

    private String[] getGuessedWord(int currentRow){
        String[] guessedWord = new String[5];
        for (int i = 0; i < 5; i++){
            String currentTextViewID = "textGrid" + currentRow + "_" + i;
            TextView currentTextView = findViewById(getResources().getIdentifier(currentTextViewID, "id", getPackageName()));
            guessedWord[i] = (String) currentTextView.getText();
        }

        return guessedWord;
    }

    private void generalKeyClick(String letter){
        if (!isRowFull){
            if (currentColumn != 5){
                displayLetter(currentColumn, currentRow, letter);
                currentColumn++;
            } else{
                isRowFull = true;
            }
        }
    }

    private void displayLetter(int currentColumn, int currentRow, String letter){
        String currentViewID = "viewGrid" + currentRow + "_" + currentColumn;
        String currentTextViewID = "textGrid" + currentRow + "_" + currentColumn;

        currentView = findViewById(getResources().getIdentifier(currentViewID, "id", getPackageName()));
        currentTextView = findViewById(getResources().getIdentifier(currentTextViewID, "id", getPackageName()));

        currentView.setAlpha((float) 1);
        currentTextView.setText(letter);

    }

    private void removeLetter(int currentColumn, int currentRow){
        String currentViewID = "viewGrid" + currentRow + "_" + currentColumn;
        String currentTextViewID = "textGrid" + currentRow + "_" + currentColumn;

        currentView = findViewById(getResources().getIdentifier(currentViewID, "id", getPackageName()));
        currentTextView = findViewById(getResources().getIdentifier(currentTextViewID, "id", getPackageName()));

        currentView.setAlpha((float) 0.2);
        currentTextView.setText("");

    }



}