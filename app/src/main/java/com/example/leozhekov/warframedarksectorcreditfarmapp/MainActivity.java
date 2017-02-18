package com.example.leozhekov.warframedarksectorcreditfarmapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by LeoZhekov on 17.2.2017 г..
 */

public class MainActivity extends Activity {

  private Spinner darkSectors;
  private SpinAdapter adapter;
  private DarkSector selectedSector;
  private Button select;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    adapter = new SpinAdapter(MainActivity.this,
        android.R.layout.simple_spinner_dropdown_item,
        initSectors());
    darkSectors = (Spinner) findViewById(R.id.darkSectors);
    select = (Button) findViewById(R.id.selectBtn);
    darkSectors.setAdapter(adapter);
    darkSectors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view,
                                 int position, long id) {
        selectedSector = adapter.getItem(position);
        select.setEnabled(true);
      }
      @Override
      public void onNothingSelected(AdapterView<?> adapter) {  }
    });

    select.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putParcelable("DARK_SECTOR", selectedSector);
        i.putExtras(b);
        i.setClass(MainActivity.this, ActualActivity.class);
        startActivity(i);
      }
    });
  }

  private DarkSector[] initSectors() {
    ArrayList<DarkSector> sectors = new ArrayList<>();
    sectors.add(new DarkSector("Gabii, Ceres", 22400, Tier.T3));
    sectors.add(new DarkSector("Seimeni, Ceres", 22400, Tier.DEFENSE));
    sectors.add(new DarkSector("Coba, Earth", 13500, Tier.DEFENSE));
    sectors.add(new DarkSector("Tikal, Earth", 13500, Tier.T1));
    sectors.add(new DarkSector("Akkad, Eris", 22400, Tier.DEFENSE));
    sectors.add(new DarkSector("Zabala, Eris", 22400, Tier.T4));
    sectors.add(new DarkSector("Cholistan, Europa", 19200, Tier.T2));
    sectors.add(new DarkSector("Larzac, Europa", 19200, Tier.DEFENSE));
    sectors.add(new DarkSector("Cameria, Jupiter", 16900, Tier.T3));
    sectors.add(new DarkSector("Sinai, Jupiter", 16900, Tier.DEFENSE));
    sectors.add(new DarkSector("Kadesh, Mars", 15900, Tier.DEFENSE));
    sectors.add(new DarkSector("Wahiba, Mars", 15900, Tier.T2));
    sectors.add(new DarkSector("Kelashin, Neptune", 21900, Tier.T3));
    sectors.add(new DarkSector("Yursa, Neptune", 21900, Tier.DEFENSE));
    sectors.add(new DarkSector("Memphis, Phobos", 18400, Tier.DEFENSE));
    sectors.add(new DarkSector("Zeugma, Phobos", 18400, Tier.T3));
    sectors.add(new DarkSector("Hieracon, Pluto", 24400, Tier.T3));
    sectors.add(new DarkSector("Sechura, Pluto", 24400, Tier.DEFENSE));
    sectors.add(new DarkSector("Caracol, Saturn", 17500, Tier.DEFENSE));
    sectors.add(new DarkSector("Piscinas, Saturn", 17500, Tier.T3));
    sectors.add(new DarkSector("Amarna, Sedna", 20400, Tier.T3));
    sectors.add(new DarkSector("Sangeru, Sedna", 20400, Tier.DEFENSE));
    sectors.add(new DarkSector("Assur, Uranus", 19600, Tier.T3));
    sectors.add(new DarkSector("Ur, Uranus", 19600, Tier.DEFENSE));
    sectors.add(new DarkSector("Malva, Venus", 16500, Tier.T1));
    sectors.add(new DarkSector("Romula, Venus", 16500, Tier.DEFENSE));
    DarkSector[] sectorArray = new DarkSector[sectors.size()];
    for (int i = 0; i < sectors.size(); i++) {
      sectorArray[i] = sectors.get(i);
    }
    return sectorArray;
  }
}
