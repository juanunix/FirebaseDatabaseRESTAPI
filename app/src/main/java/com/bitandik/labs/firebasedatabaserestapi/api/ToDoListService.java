package com.bitandik.labs.firebasedatabaserestapi.api;

import com.bitandik.labs.firebasedatabaserestapi.model.ToDoItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ykro.
 */

public interface ToDoListService {
  @GET("items.json")
  Call<ItemListResponse> getItemList();

  @GET("items/{item_id}.json")
  Call<ToDoItem> getItem(@Path("item_id") String itemId);

  @POST("items.json")
  Call<NewItemResponse> addItem(@Body ToDoItem item);
}
