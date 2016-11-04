package algorithm.reducer;

import java.util.*;

/**
 * Small class to reduce the problem
 */
public class Reducer {
    private static HashSet<Character> ts = new HashSet<>();
    private static Hashtable<Character, String> unUsed = new Hashtable<>();

    /**
     * Small method to remove unused strings from the rSets if they do not appear as substrings in string s
     * @param s string to match
     * @param rSets Hashtable with the r sets.
     * @return a reduced Hashtable with unused instances removed.
     */
    public static Hashtable<Character,String[]> removeUnused(String s, Hashtable<Character, String[]> rSets){
        Hashtable<Character, String[]> reducedrSets = new Hashtable<>();
        Enumeration enumKeys = rSets.keys();
        while(enumKeys.hasMoreElements()){
            Character key = (Character)enumKeys.nextElement();
            String[] rSet = rSets.get(key);
            if (ts.contains(key)) {
                ArrayList<String> newrSet = new ArrayList<>();
                for (int i = 0; i < rSet.length; i++) {
                    if (s.contains(rSet[i])) newrSet.add(rSet[i]);
                }
                reducedrSets.put(key, newrSet.toArray(new String[0]));
            }else{
                //Only add the first element from sets that are not used in order to have them in the solution
                unUsed.put(key,rSet[0]);
            }

        }
        return reducedrSets;
    }

    public static HashSet<Character> getTs() {
        return ts;
    }

    public static Hashtable<Character, String> getUnUsed() {
        return unUsed;
    }

    /**
     * Small method that reduces the number of tStrings to match. Removes ruplicates and substrings.
     * @param tStrings the original hashtable input from file.
     * @return hew hashtable output with reduced number of tStrings
     */
    public static Collection<String> removeDuplicateTs(Hashtable<Integer, String> tStrings){
        Collection<String> reducedtStrings = new HashSet<>();
        for (int i = 0;i < tStrings.size();i++){
            String value = tStrings.get(i);
            for (Character c: value.toCharArray()) {
                if (Character.isUpperCase(c)) ts.add(c);
            }
            boolean containsSubstring = false;
            for (String t :reducedtStrings){
                if (t.contains(value)){
                    containsSubstring = true;
                    break;
                }else if (value.contains(t)){
                    reducedtStrings.remove(t);
                    reducedtStrings.add(value);
                    containsSubstring = true;
                    break;
                }
            }
            if(!containsSubstring) reducedtStrings.add(value);
        }
        return reducedtStrings;
    }
}
