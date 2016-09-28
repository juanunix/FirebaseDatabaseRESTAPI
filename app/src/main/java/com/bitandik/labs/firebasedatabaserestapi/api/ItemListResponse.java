package com.bitandik.labs.firebasedatabaserestapi.api;

import com.bitandik.labs.firebasedatabaserestapi.model.ToDoItem;

import java.util.ArrayList;

/**
 * Created by ykro.
 */

public class ItemListResponse {
  ArrayList<ToDoItem> itemList = new ArrayList<ToDoItem>();

  public void setItemList(ArrayList<ToDoItem> itemList) {
    this.itemList = itemList;
  }

  public ArrayList<ToDoItem> getItemList(){
    return itemList;
  }
}
