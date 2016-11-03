package algorithm;

import algorithm.decoder.Decoder;
import algorithm.reducer.Reducer;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class main {

  public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);
      Decoder decoder = new Decoder();
      String decodeMore = "Y";

      System.out.println("----------------------------------------");
      System.out.println("~~~~~~~~ Welcome to the algorithm.decoder ~~~~~~~~");
      System.out.println("----------------------------------------");
      System.out.println("\n");
      System.out.println("Enter a relativ path to the SWE file you want to decode\n");
      String filePath = in.nextLine();

      System.out.println("Checking file\n");
      if (decoder.fileChecker(filePath)) {
          System.out.println("File is accepted\n");
          Hashtable tStrings = Reducer.removeDuplicateTs(Decoder.gettStrings());
          Hashtable rSets = Reducer.removeUnused(Decoder.getS(),Decoder.getrSets());
          System.out.println(rSets);
      } else {
          System.out.println("File is rejected\n");
      }

      while (true) {
        System.out.println("Write a relativ path to a new SWE file to decode\n");
        System.out.println("Or write N if you wish to exit\n");

        decodeMore = in.nextLine();
        if (decodeMore.equals("N") || decodeMore.equals("n")) {
          System.out.println("Okay ~goodbye");
          break;
        } else {
          if (decoder.fileChecker(decodeMore)) {
              System.out.println("File is accepted\n");
          } else {
              System.out.println("File is rejected\n");
          }
        }
      }
  }
}
