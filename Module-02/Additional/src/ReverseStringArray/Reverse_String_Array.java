package ReverseStringArray;

import java.util.ArrayList;
import java.util.Arrays;

public class Reverse_String_Array {
  public static void main(String[] args) {
    String[] nameStr = new String[] { "Alex", "Doby", "Jhon", "valencia" };
    System.out.println("Before Reserved: " + Arrays.toString(nameStr));

    reverseStringArray(nameStr);
  }

  static void reverseStringArray(String[] nameStr) {
    for (int i = 0; i < nameStr.length / 2; i++) {
      String strTemp = nameStr[i];
      nameStr[i] = nameStr[nameStr.length - i - 1];
      nameStr[nameStr.length - i - 1] = strTemp;
    }

    ArrayList<String> nameArr = new ArrayList<String>();
    for (int i = 0; i < nameStr.length; i++) {
      nameArr.add(nameStr[i]);
    }

    System.out.println("After Reversed: " + nameArr);
  }
}
