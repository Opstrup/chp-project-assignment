package algorithm;

import algorithm.decoder.Decoder;
import algorithm.printer.Printer;
import algorithm.solver.Solver;

import java.io.IOException;
import java.util.*;

class main {

  public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);
      System.out.println("----------------------------------------");
      System.out.println("~~~~~~~~Welcome to the algorithm~~~~~~~~");
      System.out.println("----------------------------------------");
      System.out.println("\n");
      String filePath="";
      if(args.length > 0){
          filePath = args[0];
      }else{
          System.out.println("Enter a relativ path to the SWE file you want to decode\n");
          filePath = in.nextLine();
      }


      while(true){
          if (filePath.equals("N") || filePath.equals("n")) {
              System.out.println("Okay ~goodbye");
              break;
          }
          System.out.println("Checking file\n");
          if (Decoder.fileChecker(filePath)) {

              System.out.println("File is accepted\n");
              Solver s = new Solver();
              Hashtable<Character, String> solution = s.bruteForceSolve();

              if (solution !=null){
                  System.out.println("Found solution!");
                  Printer.printResultToFile(solution);
              }else{
                  Printer.printNoSolution();
              }
          } else {
              System.out.println("File is rejected\n");
          }
          System.out.println("Write a relativ path to a new SWE file to decode\n");
          System.out.println("Or write N if you wish to exit\n");
          filePath = in.nextLine();

      }
  }
}
