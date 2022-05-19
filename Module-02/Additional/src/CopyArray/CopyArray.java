package CopyArray;

import java.util.Arrays;

public class CopyArray {
  public static void main(String[] args) {
    int array1[] = new int[] { 1, 2, 3, 4, 5 };
    int array2[] = new int[array1.length];

    for (int i = 0; i < array1.length; i++) {
      array2[i] = array1[i];
    }

    System.out.println(array1);
    System.out.println(array2);

    System.out.println("Array 1: ");
    for (int i = 0; i < array1.length; i++) {
      System.out.println(array1[i]);
    }

    System.out.println("Array 2: ");
    for (int i = 0; i < array1.length; i++) {
      System.out.println(array2[i]);
    }

    System.out.println("Array 1: " + Arrays.toString(array1));
    System.out.println("Array 2: " + Arrays.toString(array2));
  }
}
