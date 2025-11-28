package com.propertopia.model;

import java.util.List;
import java.util.Random;

public class ChanceCard {
  
  private String title;
  private String description;
  private String tag;
  private static String[] titles;
  private static String[] descriptions;
  private static String[] tags;
  
  public ChanceCard() {
    Random randomNumbers = new Random();
    int x = (randomNumbers.nextInt(20) + 1);
    
  }
}
