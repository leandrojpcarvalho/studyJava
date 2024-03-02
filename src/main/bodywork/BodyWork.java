package main.bodywork;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BodyWork {
  static List<BodyWork> bodiesWork = new ArrayList<>();
  String name;

  private BodyWork(String name) {
    this.name = name;
  }
  public static @NotNull BodyWork getInstance(String name) {
    for (BodyWork bodyWork : bodiesWork) {
      if (bodyWork.name.equals(name)) {
        return bodyWork;
      }
    }
    BodyWork newBodyWork = new BodyWork(name);
    bodiesWork.add(newBodyWork);
    return newBodyWork;
  }
  public static BodyWork[] getAllInstances() {
    return bodiesWork.toArray(new BodyWork[0]);
  }

  @Override
  public String toString() {
    return  name;
  }
}