package com.bitandik.labs.firebasedatabaserestapi.api;

import com.bitandik.labs.firebasedatabaserestapi.model.ToDoItem;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ykro.
 */
public class ItemListResponseTypeAdapter extends TypeAdapter {
  @Override
  public void write(JsonWriter out, Object value) throws IOException {

  }

  @Override
  public ItemListResponse read(JsonReader in) throws IOException {
    final ItemListResponse response = new ItemListResponse();
    ArrayList<ToDoItem> itemList = new ArrayList<ToDoItem>();
    in.beginObject();
    while (in.hasNext()) {
      ToDoItem item = readItem(in);
      itemList.add(item);
    }

    in.endObject();
    response.setItemList(itemList);
    return response;
  }


  public ToDoItem readItem(JsonReader reader) throws IOException {
    ToDoItem item = new ToDoItem();
    reader.nextName();
    reader.beginObject();
    while (reader.hasNext()) {
      String next = reader.nextName();
      switch (next) {
        case "completed":
          item.setCompleted(reader.nextBoolean());
          break;
        case "item":
          item.setItem(reader.nextString());
          break;
        case "username":
          item.setUsername(reader.nextString());
          break;
      }
    }

    reader.endObject();
    return item;
  }
}
