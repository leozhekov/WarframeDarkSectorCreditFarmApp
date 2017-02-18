package com.example.leozhekov.warframedarksectorcreditfarmapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class ActualActivity extends Activity {
  private CheckBox boosted;
  private Button missionCount;
  private TextView missionCountText;
  private Button m400Endo;
  private Button m15Endo;
  private Button m50Endo;
  private Button m80Endo;
  private Button m500Credit;
  private Button m1kCredit;
  private Button m1k5Credit;
  private Button m2kCredit;
  private Button m2k5Credit;
  private Button m3kCredit;
  private EditText missionCreditText;
  private Button missionCredit;
  private TextView totalEndo;
  private TextView selectedSectorView;
  private TextView totalCredits;
  private TextView missionReward;
  private Button back;
  private Button reset;
  private int totalCreditsInt;
  private int totalEndoInt;
  private int missionCountInt;
  private int reward;
  private DarkSector selectedSector;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_actual);
    Bundle b = this.getIntent().getExtras();

    boosted = (CheckBox) findViewById(R.id.boosted);
    missionCount = (Button) findViewById(R.id.missionCount);
    // endo
    m400Endo = (Button) findViewById(R.id.m400Endo);
    m15Endo = (Button) findViewById(R.id.m15Endo);
    m50Endo = (Button) findViewById(R.id.m50Endo);
    m80Endo = (Button) findViewById(R.id.m80Endo);
    // credits
    m500Credit = (Button) findViewById(R.id.m500Credit);
    m1kCredit = (Button) findViewById(R.id.m1kCredit);
    m1k5Credit = (Button) findViewById(R.id.m1k5Credit);
    m2kCredit = (Button) findViewById(R.id.m2kCredit);
    m2k5Credit = (Button) findViewById(R.id.m2k5Credit);
    m3kCredit = (Button) findViewById(R.id.m3kCredit);

    reset = (Button) findViewById(R.id.reset);
    back = (Button) findViewById(R.id.back);
    missionCredit = (Button) findViewById(R.id.missionCredit);
    totalEndo = (TextView) findViewById(R.id.totalEndo);
    missionCountText = (TextView) findViewById(R.id.missionCountText);
    totalCredits = (TextView) findViewById(R.id.totalCredits);
    missionCreditText = (EditText) findViewById(R.id.missionCreditText);
    selectedSectorView = (TextView) findViewById(R.id.selectedSectorView);
    missionReward = (TextView) findViewById(R.id.missionReward);
    totalCreditsInt = 0;
    totalEndoInt = 0;
    missionCountInt = 0;

    if (b != null) {
      selectedSector = b.getParcelable("DARK_SECTOR");
      if (selectedSector != null) {
        reward = selectedSector.getReward();
        missionReward.setText(String.format(getString(R.string.mission_reward), reward));
        selectedSectorView.setText(selectedSector.toString());
        switch (selectedSector.getTier()) {
          case T1: {
            m500Credit.setVisibility(View.VISIBLE);
            m1kCredit.setVisibility(View.VISIBLE);
            m1k5Credit.setVisibility(View.VISIBLE);
            m2kCredit.setVisibility(View.VISIBLE);
            m2k5Credit.setVisibility(View.GONE);
            m3kCredit.setVisibility(View.GONE);

            m400Endo.setVisibility(View.GONE);
            m15Endo.setVisibility(View.VISIBLE);
            m50Endo.setVisibility(View.VISIBLE);
            m80Endo.setVisibility(View.VISIBLE);
          }
          break;
          case T2: {
            m500Credit.setVisibility(View.GONE);
            m1kCredit.setVisibility(View.VISIBLE);
            m1k5Credit.setVisibility(View.VISIBLE);
            m2kCredit.setVisibility(View.VISIBLE);
            m2k5Credit.setVisibility(View.GONE);
            m3kCredit.setVisibility(View.GONE);

            m400Endo.setVisibility(View.GONE);
            m15Endo.setVisibility(View.VISIBLE);
            m50Endo.setVisibility(View.VISIBLE);
            m80Endo.setVisibility(View.VISIBLE);
          }
          break;
          case T3:
          case T4: {
            m500Credit.setVisibility(View.GONE);
            m1kCredit.setVisibility(View.GONE);
            m1k5Credit.setVisibility(View.GONE);
            m2kCredit.setVisibility(View.VISIBLE);
            m2k5Credit.setVisibility(View.VISIBLE);
            m3kCredit.setVisibility(View.VISIBLE);

            m400Endo.setVisibility(View.VISIBLE);
            m15Endo.setVisibility(View.GONE);
            m50Endo.setVisibility(View.GONE);
            m80Endo.setVisibility(View.GONE);
          }
          break;
          case DEFENSE: {
            m500Credit.setVisibility(View.GONE);
            m1kCredit.setVisibility(View.GONE);
            m1k5Credit.setVisibility(View.GONE);
            m2kCredit.setVisibility(View.GONE);
            m2k5Credit.setVisibility(View.GONE);
            m3kCredit.setVisibility(View.GONE);

            m400Endo.setVisibility(View.GONE);
            m15Endo.setVisibility(View.GONE);
            m50Endo.setVisibility(View.GONE);
            m80Endo.setVisibility(View.GONE);
          }
          break;
        }
      }
    }
    missionCount.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ++missionCountInt;
        if (boosted.isChecked()) {
          totalCreditsInt += reward * 2;
        } else {
          totalCreditsInt += reward;
        }
        totalCredits.setText(String.valueOf(totalCreditsInt));
        missionCountText.setText(String.valueOf(missionCountInt));
      }
    });
    boosted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
          missionReward.setText(String.format(getString(R.string.mission_reward), reward * 2));
        } else {
          missionReward.setText(String.format(getString(R.string.mission_reward), reward));
        }
      }
    });
    // credits
    m500Credit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 500;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });
    m1kCredit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 1000;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });
    m1k5Credit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 1500;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });
    m2kCredit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 2000;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });
    m2k5Credit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 2500;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });
    m3kCredit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalCreditsInt += 3000;
        totalCredits.setText(String.valueOf(totalCreditsInt));
      }
    });

    // endo
    m400Endo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalEndoInt += 400;
        totalEndo.setText(String.valueOf(totalEndoInt));
      }
    });
    m15Endo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalEndoInt += 15;
        totalEndo.setText(String.valueOf(totalEndoInt));
      }
    });
    m50Endo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalEndoInt += 50;
        totalEndo.setText(String.valueOf(totalEndoInt));
      }
    });
    m80Endo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        totalEndoInt += 80;
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
        reset();
      }
    });
    back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        reset();
        back();
      }
    });

  }

  public void reset() {
    boosted.setChecked(false);
    totalCreditsInt = 0;
    totalEndoInt = 0;
    missionCountInt = 0;
    totalCredits.setText(String.valueOf(0));
    totalEndo.setText(String.valueOf(0));
    missionCountText.setText(String.valueOf(0));
  }

  public void back() {
    Intent i = new Intent();
    i.setClass(ActualActivity.this, MainActivity.class);
    startActivity(i);
  }
}
