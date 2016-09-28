package com.bitandik.labs.firebasedatabaserestapi.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ykro.
 */

public class NewItemResponse {
  @SerializedName("name")
  String id;

  public String getId() {
    return id;
  }
}
