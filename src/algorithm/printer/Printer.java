package algorithm.printer;

import algorithm.decoder.Decoder;
import algorithm.reducer.Reducer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by salik on 04-11-2016.
 */
public class Printer {

    public static void printResultToFile(Hashtable<Character, String> solution){
        String testFile = Decoder.getFileName();
        String fileName = testFile.split("\\.")[0]+".SOL";
        //Get the keys as a list to sort them alphabetically
        ArrayList<Character> sortetKeys = Collections.list(solution.keys());
        //Sort the keys to get them in order in the file.
        Collections.sort(sortetKeys);
        List<String> lines = new ArrayList<>();
        for (Character c: sortetKeys) {
            String r = solution.get(c);
            lines.add(c+":"+r);
        }
        Path file = Paths.get(fileName);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done printing to file: "+file.toAbsolutePath().toString());
    }
    public static void printNoSolution(){
        String testFile = Decoder.getFileName();
        String fileName = testFile.split("\\.")[0]+".SOL";
        List<String> lines = Arrays.asList("No Solution!");
        Path file = Paths.get(fileName);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done printing to file: "+file.toAbsolutePath().toString());
    }
}
