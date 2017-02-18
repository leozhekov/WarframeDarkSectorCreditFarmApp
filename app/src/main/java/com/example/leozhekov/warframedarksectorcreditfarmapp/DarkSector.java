package com.example.leozhekov.warframedarksectorcreditfarmapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by LeoZhekov on 17.2.2017 г..
 */

public class DarkSector implements Parcelable {
  private String name;
  private int reward;
  private Tier tier;

  public DarkSector(String name, int reward, Tier t) {
    this.name = name;
    this.reward = reward;
    this.tier = t;
  }

  public DarkSector() {
  }

  protected DarkSector(Parcel in) {
    name = in.readString();
    reward = in.readInt();
    tier = Tier.valueOf(in.readString());
  }

  public static final Creator<DarkSector> CREATOR = new Creator<DarkSector>() {
    @Override
    public DarkSector createFromParcel(Parcel in) {
      return new DarkSector(in);
    }

    @Override
    public DarkSector[] newArray(int size) {
      return new DarkSector[size];
    }
  };

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getReward() {
    return reward;
  }

  public void setReward(int reward) {
    this.reward = reward;
  }

  public Tier getTier() {
    return tier;
  }

  public void setTier(Tier tier) {
    this.tier = tier;
  }

  @Override
  public String toString() {
    return name + "(" + tier.name() + "): " + String.valueOf(reward) + " credits";
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeInt(reward);
    dest.writeString(tier.name());
  }
}
