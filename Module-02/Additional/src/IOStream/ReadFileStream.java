package IOStream;

import java.io.*;

public class ReadFileStream {
  public static void main(String[] args) throws Exception {

    // Skip 5 Bytes
    try {
      FileInputStream fin = new FileInputStream("outputfile.txt");
      int i = 0;
      fin.skip(5);
      while ((i = fin.read()) != -1) {
        System.out.print((char) i);
      }
      System.out.println();
      fin.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // Check available bytes
    try {
      FileInputStream fin = new FileInputStream("outputfile.txt");
      BufferedInputStream bin = new BufferedInputStream(fin);
      System.out.println("Bytes available: " + bin.available());
      for (int i = 0; i < 3; i++) {
        int j = bin.read();
        System.out.print((char) j);
      }
      System.out.println();
      System.out.println("Bytes available: " + bin.available());
      bin.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
