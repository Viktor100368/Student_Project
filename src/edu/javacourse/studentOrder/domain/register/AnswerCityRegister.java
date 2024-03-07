package edu.javacourse.studentOrder.domain.register;

import java.util.ArrayList;
import java.util.List;

public class AnswerCityRegister {
  List<AnswerCityRegisterItem> items;

  public void addItem(AnswerCityRegisterItem item){
    if(items == null) {
      items = new ArrayList<>();
    }
    items.add(item);
  }
  public List<AnswerCityRegisterItem> getItems() {
    return items;
  }
}
