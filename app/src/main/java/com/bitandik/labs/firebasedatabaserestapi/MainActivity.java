package com.bitandik.labs.firebasedatabaserestapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bitandik.labs.firebasedatabaserestapi.api.ItemListResponse;
import com.bitandik.labs.firebasedatabaserestapi.api.NewItemResponse;
import com.bitandik.labs.firebasedatabaserestapi.api.ToDoListClient;
import com.bitandik.labs.firebasedatabaserestapi.api.ToDoListService;
import com.bitandik.labs.firebasedatabaserestapi.model.ToDoItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  public final static String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ToDoListService service = (new ToDoListClient()).getService();

    /* all items */
    Call<ItemListResponse> itemListCall = service.getItemList();
    itemListCall.enqueue(new Callback<ItemListResponse>() {

      @Override
      public void onResponse(Call<ItemListResponse> call, Response<ItemListResponse> response) {
        if (response.isSuccessful()) {
          ItemListResponse result = response.body();
          ArrayList<ToDoItem> items = result.getItemList();
          Log.i(TAG,items.toString());
        }
      }

      @Override
      public void onFailure(Call<ItemListResponse> call, Throwable t) {
        Log.e(TAG,"error " + t.getLocalizedMessage());
      }
    });

    /* one item with id -KSbb2w36G3TbE6lhwTd */
    Call<ToDoItem> oneItemCall = service.getItem("-KSbb2w36G3TbE6lhwTd");
    oneItemCall.enqueue(new Callback<ToDoItem>() {
      @Override
      public void onResponse(Call<ToDoItem> call, Response<ToDoItem> response) {
        if (response.isSuccessful()) {
          ToDoItem item = response.body();
          Log.i(TAG, item.toString());
        }
      }

      @Override
      public void onFailure(Call<ToDoItem> call, Throwable t) {
        Log.e(TAG,"error " + t.getLocalizedMessage());
      }
    });

    /* new item */
    ToDoItem newItem = new ToDoItem("new test item","@ykro");
    Call<NewItemResponse> newItemCall = service.addItem(newItem);
    newItemCall.enqueue(new Callback<NewItemResponse>() {
      @Override
      public void onResponse(Call<NewItemResponse> call, Response<NewItemResponse> response) {
        if (response.isSuccessful()) {
          Log.i(TAG, "->" + response.body().getId());
        }
      }

      @Override
      public void onFailure(Call<NewItemResponse> call, Throwable t) {
        Log.e(TAG,"error " + t.getLocalizedMessage());
      }
    });
  }
}
