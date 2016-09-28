package com.bitandik.labs.firebasedatabaserestapi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ykro.
 */

public class ToDoListClient {
  private Retrofit retrofit;
  private final static String BASE_URL = "https://android-to-do-list.firebaseio.com/";

  public ToDoListClient() {
    Gson gson = new GsonBuilder()
        .registerTypeAdapter(ItemListResponse.class, new ItemListResponseTypeAdapter())
        .create();
    retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
  }

  public ToDoListService getService() {
    return retrofit.create(ToDoListService.class);
  }
}
