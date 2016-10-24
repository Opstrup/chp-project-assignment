import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Scanner;

public class Decoder {

    public static Boolean fileChecker(String filePath) throws IOException {
        Hashtable<Integer, String> fileContent = new Hashtable<>();
        AtomicInteger lineNumber = new AtomicInteger(0);
        Boolean result = true;

        // Building up the Hashtable
        Files.lines(FileSystems.getDefault().getPath(filePath), StandardCharsets.UTF_8).forEach((line)-> {
                fileContent.put(lineNumber.incrementAndGet(), line);
            }
        );

        Integer numOfSubStrings = Integer.parseInt(fileContent.get(1));

        if (!checkForOnlyNumbers(fileContent.get(1))) {
          System.out.println("Line: 1 is wrong!");
          result = false;
        }

        if (!onlyContrainLowerAndUppercaseLetters(fileContent.get(2))) {
          System.out.println("Line: 2 is wrong!");
          result = false;
        }

        for(int i = 3; i < (3 + numOfSubStrings); i++){
          if (!onlyContrainLowerAndUppercaseLetters(fileContent.get(i))) {
            System.out.println("Line: " + i + "is wrong!");
            result = false;
          }
        }

        for(int i = numOfSubStrings + 3; i < fileContent.size(); i++){
            if (!checkLine(fileContent.get(i))) {
              System.out.println("Line: " + i + "is wrong!");
              result = false;
            }
        }

        return result;
    }

    private static Boolean checkForOnlyNumbers(String line) {
      return line.matches("[0-9]+");
    }

    private static Boolean onlyContrainLowerAndUppercaseLetters(String line) {
      return line.matches("[a-zA-Z]+");
    }

    private static Boolean onlyContrainLowercaseLetters(String line) {
      return line.matches("[a-z]+");
    }

    private static Boolean checkLine(String line) {
      return line.matches("^[A-Z]{1}[:]{1}([a-z,])+");
    }

    public static void runTests() {
      System.out.println("\n");
      System.out.println("\n");

      System.out.println("---------------- * Tests * ----------------");
      System.out.println("Test of onlyContrainLowercaseLetters:");
      System.out.println("Expected [true, true, false, false, false, false]:");
      System.out.println(onlyContrainLowercaseLetters("abc"));                // True
      System.out.println(onlyContrainLowercaseLetters("aaaabbbssdcxzs"));     // True
      System.out.println(onlyContrainLowercaseLetters("abc!!,ba2"));          // False
      System.out.println(onlyContrainLowercaseLetters("abc vs"));             // False
      System.out.println(onlyContrainLowercaseLetters("aBc"));                // False
      System.out.println(onlyContrainLowercaseLetters("ab!c"));               // False
      System.out.println("\n");

      System.out.println("Test of onlyContrainLowerAndUppercaseLetters:");
      System.out.println("Expected [true, true, false, false, false, false]:");
      System.out.println(onlyContrainLowerAndUppercaseLetters("ABd"));        // True
      System.out.println(onlyContrainLowerAndUppercaseLetters("dBAS"));       // True
      System.out.println(onlyContrainLowerAndUppercaseLetters("abc!!,ba2"));  // False
      System.out.println(onlyContrainLowerAndUppercaseLetters("ABs "));       // False
      System.out.println(onlyContrainLowerAndUppercaseLetters("aBc:"));       // False
      System.out.println(onlyContrainLowerAndUppercaseLetters("ab!c"));       // False
      System.out.println("\n");

      System.out.println("Test of checkLine:");
      System.out.println("Expected [true, true, true, false, false, false]:");
      System.out.println(checkLine("A:a,b,c,d,e,f,dd"));                      // True
      System.out.println(checkLine("C:sdasa,gv,e,f,d"));                      // True
      System.out.println(checkLine("A:a"));                                   // True
      System.out.println(checkLine("a,b"));                                   // False
      System.out.println(checkLine(":A,"));                                   // False
      System.out.println(checkLine(":A,a,s,1"));                              // False
      System.out.println("\n");
    }
}
