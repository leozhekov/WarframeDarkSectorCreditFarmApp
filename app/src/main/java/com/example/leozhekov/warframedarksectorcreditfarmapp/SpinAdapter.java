package com.example.leozhekov.warframedarksectorcreditfarmapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by LeoZhekov on 18.2.2017 г..
 */

public class SpinAdapter extends ArrayAdapter<DarkSector> {

  private Context context;
  private DarkSector[] values;

  public SpinAdapter(Context context, int textViewResourceId, DarkSector[] values) {
    super(context, textViewResourceId, values);
    this.context = context;
    this.values = values;
  }

  public int getCount() {
    return values.length;
  }

  public DarkSector getItem(int position) {
    return values[position];
  }

  public long getItemId(int position) {
    return position;
  }

  @NonNull
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    TextView label = new TextView(context);
    label.setTextColor(Color.BLACK);
    label.setPadding(50, 15, 20, 15);
    label.setTextSize(24);
    label.setText(values[position].getName() + ": " + values[position].getReward() + " credits");
    return label;
  }

  @Override
  public View getDropDownView(int position, View convertView, ViewGroup parent) {
    TextView label = new TextView(context);
    label.setTextColor(Color.BLACK);
    label.setPadding(50, 30, 50, 30);
    label.setTextSize(24);
    label.setText(values[position].getName() + ": " + values[position].getReward() + " credits");
    return label;
  }
}