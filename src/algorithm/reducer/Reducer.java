package algorithm.reducer;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Small class to reduce the problem
 */
public class Reducer {
    private static HashSet<Character> ts = new HashSet<>();

    /**
     * Small method to remove unused strings from the rSets if they do not appear as substrings in string s
     * @param s string to match
     * @param rSets Hashtable with the r sets.
     * @return a reduced Hashtable with unused instances removed.
     */
    public static Hashtable removeUnused(String s, Hashtable<Character, String[]> rSets){
        Hashtable<Character, String[]> reducedrSets = new Hashtable<>();
        Enumeration enumKeys = rSets.keys();
        while(enumKeys.hasMoreElements()){
            Character key = (Character)enumKeys.nextElement();

            if (ts.contains(key)){
                String[] rSet = rSets.get(key);
                ArrayList<String> newrSet = new ArrayList<>();
                for (int i = 0; i < rSet.length;i++ ){
                    if(s.contains(rSet[i])) newrSet.add(rSet[i]);
                }
                reducedrSets.put(key, newrSet.toArray(new String[0]));
            }

        }
        return reducedrSets;
    }

    public static HashSet<Character> getTs() {
        return ts;
    }

    /**
     * Small method that reduces the number of tStrings to match. Removes ruplicates and substrings.
     * @param tStrings the original hashtable input from file.
     * @return hew hashtable output with reduced number of tStrings
     */
    public static Hashtable removeDuplicateTs(Hashtable<Integer, String> tStrings){
        Hashtable<Integer, String> reducedtStrings = new Hashtable<>();
        for (int i = 0;i < tStrings.size();i++){
            String value = tStrings.get(i);
            for (Character c: value.toCharArray()) {
                if (Character.isUpperCase(c)) ts.add(c);
            }
            boolean containsSubstring = false;
            for (String t :reducedtStrings.values()){
                if (t.contains(value)){
                    containsSubstring = true;
                    break;
                }else if (value.contains(t)){
                    reducedtStrings.values().remove(t);
                    reducedtStrings.put(i,value);
                    containsSubstring = true;
                    break;
                }
            }
            if(!containsSubstring) reducedtStrings.put(i, value);
        }
        return reducedtStrings;
    }
}
