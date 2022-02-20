package com.example.wordleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton qButton, wButton, eButton, rButton, tButton, yButton, uButton, iButton, oButton,
            pButton, aButton, sButton, dButton, fButton, gButton, hButton, jButton, kButton, lButton,
            zButton, xButton, cButton, vButton, bButton, nButton, mButton, enterButton, deleteButton;

    private View viewGrid0_0, viewGrid0_1, viewGrid0_2, viewGrid0_3, viewGrid0_4, viewGrid1_0, viewGrid1_1,
            viewGrid1_2, viewGrid1_3, viewGrid1_4, viewGrid2_0, viewGrid2_1, viewGrid2_2, viewGrid2_3,
            viewGrid2_4, viewGrid3_0, viewGrid3_1, viewGrid3_2, viewGrid3_3, viewGrid3_4, viewGrid4_0,
            viewGrid4_1, viewGrid4_2, viewGrid4_3, viewGrid4_4, viewGrid5_0, viewGrid5_1, viewGrid5_2,
            viewGrid5_3, viewGrid5_4;

    private TextView textGrid0_0, textGrid0_1, textGrid0_2, textGrid0_3, textGrid0_4, textGrid1_0, textGrid1_1,
            textGrid1_2, textGrid1_3, textGrid1_4, textGrid2_0, textGrid2_1, textGrid2_2, textGrid2_3,
            textGrid2_4, textGrid3_0, textGrid3_1, textGrid3_2, textGrid3_3, textGrid3_4, textGrid4_0,
            textGrid4_1, textGrid4_2, textGrid4_3, textGrid4_4, textGrid5_0, textGrid5_1, textGrid5_2,
            textGrid5_3, textGrid5_4;

    View[][] views;
    TextView[][] textViews;

    int currentColumn = 0;
    int currentRow = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// ------------------------- KEYBOARD BUTTONS ------------------------------------------------------

        qButton = findViewById(R.id.qButton); wButton = findViewById(R.id.wButton); eButton =
                findViewById(R.id.eButton); rButton = findViewById(R.id.rButton); tButton =
                findViewById(R.id.tButton); yButton = findViewById(R.id.yButton); uButton =
                findViewById(R.id.uButton); iButton = findViewById(R.id.iButton); oButton =
                findViewById(R.id.oButton); pButton = findViewById(R.id.pButton); aButton =
                findViewById(R.id.aButton); sButton = findViewById(R.id.sButton); dButton =
                findViewById(R.id.dButton); fButton = findViewById(R.id.fButton); gButton =
                findViewById(R.id.gButton); hButton = findViewById(R.id.hButton); jButton =
                findViewById(R.id.jButton); kButton = findViewById(R.id.kButton); lButton =
                findViewById(R.id.lButton); zButton = findViewById(R.id.zButton); xButton =
                findViewById(R.id.xButton); cButton = findViewById(R.id.cButton); vButton =
                findViewById(R.id.vButton); bButton = findViewById(R.id.bButton); nButton =
                findViewById(R.id.nButton); mButton = findViewById(R.id.mButton); enterButton =
                findViewById(R.id.enterButton); deleteButton = findViewById(R.id.deleteButton);

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

    }

    private void displayLetter(int currentColumn, int currentRow){
        String currentGridViewID = "viewGrid" + currentRow + "_" + currentRow;

    }

}