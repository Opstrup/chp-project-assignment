package algorithm.decoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Decoder {

    private static Hashtable<Integer, String> fileContent;
    private static Hashtable<Character, String[]> rSets;
    private static String s;
    private static String fileName;
    private static Hashtable<Integer, String> tStrings;
    private static HashSet<Character> gammaChars;
    private static Integer k;


    public static Boolean fileChecker(String filePath) throws IOException {
        fileContent = new Hashtable<>();
        rSets = new Hashtable<>();
        tStrings = new Hashtable<>();
        gammaChars = new HashSet<>();
        AtomicInteger lineNumber = new AtomicInteger(0);
        Boolean result = true;
        fileName = FileSystems.getDefault().getPath(filePath).getFileName().toString();
        // Building up the Hashtable
        Files.lines(FileSystems.getDefault().getPath(filePath), StandardCharsets.UTF_8).forEach((line)-> {
                fileContent.put(lineNumber.incrementAndGet(), line);
            }
        );
        Integer numOfSubStrings = 0;


        if (!checkForOnlyNumbers(fileContent.get(1))) {
          System.out.println("Line: 1 is wrong!");
          result = false;
        }else{
            numOfSubStrings = Integer.parseInt(fileContent.get(1));
            k = numOfSubStrings;
        }

        if (!onlyContainLowercaseLetters(fileContent.get(2))) {
          System.out.println("Line: 2 is wrong!");
          result = false;
        }else {
            //Get the string s
            s = fileContent.get(2);
        }
        //Read the r sets
        for(int i = numOfSubStrings + 3; i <= fileContent.size(); i++){
            if (!checkLine(fileContent.get(i))) {
                System.out.println("Line: " + i + "is wrong!");
                result = false;
            }else {
                //Create the rSets
                String line = fileContent.get(i);
                String[] parts = line.split(":");
                Character rName = parts[0].charAt(0);
                String [] rSet = parts[1].split(",");
                rSets.put(rName,rSet);
            }
        }
        //Add t strings
        for(int i = 3; i < (3 + numOfSubStrings); i++){
            String t = fileContent.get(i);
          if (!onlyContainLowerAndUppercaseLetters(t) || t.length() > s.length()) {
            System.out.println("Line: " + i + " is wrong!");
            result = false;
          }else{
              String line = fileContent.get(i);
              for (char c: line.toCharArray()) {
                  if(Character.isUpperCase(c) && !rSets.keySet().contains(c)){
                      System.out.println("Line: " + i + " is wrong!");
                      result = false;
                  }
              }
              tStrings.put(i-3,line);
          }
        }
        return result;
    }

    private static Boolean checkForOnlyNumbers(String line) {
      return line.matches("[0-9]+");
    }

    private static Boolean onlyContainLowerAndUppercaseLetters(String line) {
      return line.matches("[a-zA-Z]+");
    }

    private static Boolean onlyContainLowercaseLetters(String line) {
      return line.matches("[a-z]+");
    }

    private static Boolean checkLine(String line) {
      return line.matches("^[A-Z]{1}[:]{1}([a-z,])+");
    }
    public static Hashtable<Character, String[]> getrSets() {
        return rSets;
    }

    public static String getS() {
        return s;
    }

    public static Hashtable<Integer, String> gettStrings() {
        return tStrings;
    }

    public static Integer getK() {
        return k;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void runTests() {
      System.out.println("\n");
      System.out.println("\n");

      System.out.println("---------------- * Tests * ----------------");
      System.out.println("Test of onlyContainLowercaseLetters:");
      System.out.println("Expected [true, true, false, false, false, false]:");
      System.out.println(onlyContainLowercaseLetters("abc"));                // True
      System.out.println(onlyContainLowercaseLetters("aaaabbbssdcxzs"));     // True
      System.out.println(onlyContainLowercaseLetters("abc!!,ba2"));          // False
      System.out.println(onlyContainLowercaseLetters("abc vs"));             // False
      System.out.println(onlyContainLowercaseLetters("aBc"));                // False
      System.out.println(onlyContainLowercaseLetters("ab!c"));               // False
      System.out.println("\n");

      System.out.println("Test of onlyContainLowerAndUppercaseLetters:");
      System.out.println("Expected [true, true, false, false, false, false]:");
      System.out.println(onlyContainLowerAndUppercaseLetters("ABd"));        // True
      System.out.println(onlyContainLowerAndUppercaseLetters("dBAS"));       // True
      System.out.println(onlyContainLowerAndUppercaseLetters("abc!!,ba2"));  // False
      System.out.println(onlyContainLowerAndUppercaseLetters("ABs "));       // False
      System.out.println(onlyContainLowerAndUppercaseLetters("aBc:"));       // False
      System.out.println(onlyContainLowerAndUppercaseLetters("ab!c"));       // False
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
