package com.example.leozhekov.warframedarksectorcreditfarmapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

  private CheckBox boosted;
  private Button missionCount;
  private TextView missionCountText;
  private Button endo;
  private Button lowCredit;
  private Button medCredit;
  private Button highCredit;
  private EditText missionCreditText;
  private Button missionCredit;
  private TextView totalEndo;
  private TextView totalCredits;
  private Button reset;
  private int totalCreditsInt;
  private int totalEndoInt;
  private int missionCountInt;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    boosted = (CheckBox) findViewById(R.id.boosted);
    missionCount = (Button) findViewById(R.id.missionCount);
    endo = (Button) findViewById(R.id.endo);
    lowCredit = (Button) findViewById(R.id.lowCredit);
    medCredit = (Button) findViewById(R.id.medCredit);
    highCredit = (Button) findViewById(R.id.highCredit);
    reset = (Button) findViewById(R.id.reset);
    missionCredit = (Button) findViewById(R.id.missionCredit);
    totalEndo = (TextView) findViewById(R.id.totalEndo);
    missionCountText = (TextView) findViewById(R.id.missionCountText);
    totalCredits = (TextView) findViewById(R.id.totalCredits);
    missionCreditText = (EditText) findViewById(R.id.missionCreditText);
    totalCreditsInt = 0;
    totalEndoInt = 0;
    missionCountInt = 0;
    missionCount.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ++missionCountInt;
        if (boosted.isChecked()) {
          totalCreditsInt += 48800;
        } else {
          totalCreditsInt += 24400;
        }
        totalCredits.setText(String.valueOf(totalCreditsInt));
        missionCountText.setText(String.valueOf(missionCountInt));
      }
    });
    lowCredit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 2000;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });
    medCredit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 2500;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });
    highCredit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 3000;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });
    endo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalEndoInt += 400;
        totalEndo.setText(String.valueOf(totalEndoInt));
      }
    });
    missionCredit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int missionCredits = Integer.valueOf(missionCreditText.getText().toString());
        totalCreditsInt += missionCredits;
        totalCredits.setText(String.valueOf(totalCreditsInt));
        missionCreditText.setText("");
      }
    });
    reset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt = 0;
        totalEndoInt = 0;
        missionCountInt = 0;
        totalCredits.setText(String.valueOf(0));
        totalEndo.setText(String.valueOf(0));
        missionCountText.setText(String.valueOf(0));
      }
    });
  }
}
