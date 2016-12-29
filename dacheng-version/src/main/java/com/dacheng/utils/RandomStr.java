package com.dacheng.utils;

import java.io.PrintStream;
import java.util.Random;

public class RandomStr
{
  private static Random randGen = null;
  private static char[] numbersAndLetters = null;

  public static final String randomString(int length) {
    if (length < 1) {
      return null; 
    }
    if (randGen == null) {
      randGen = new Random();
      numbersAndLetters = "01234567890236985471458745651355666581256984136598745632159556369812659741668"
        .toCharArray();
    }

    char[] randBuffer = new char[length];
    for (int i = 0; i < randBuffer.length; i++) {
      randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
    }

    return new String(randBuffer);
  }

  public static void main(String[] args) {
    System.out.println(randomString(6));
  }
}