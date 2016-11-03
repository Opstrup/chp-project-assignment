package algorithm.solver;

import algorithm.Node;

import java.util.Collection;
import java.util.Hashtable;

public class Solver {

    /*
    stringS = absdeds
    tStrings {
        ABC
        ABd
    }
    rSet {
        A: s, a, sd
        B: ssd, d, w
        C: e
    }
    */


    private Node makeTree(Hashtable rSets) {
        Node treeRootNode = new Node(null);
        treeRootNode.setSubset("root");



        return treeRootNode;
    }

    public void bruteForceSolve(String stringS, Hashtable rSets, Hashtable tStrings) {

        /*Hashtable<Character,String> possibleSol = new Hashtable<>();
        Enumeration enumrKey = rSets.keys();
        while (enumrKey.hasMoreElements()) {
            Character key = (Character) enumrKey.nextElement();
            String[] rSet = (String[]) rSets.get(key);
            String lastVal = rSet[rSet.length-1];
            possibleSol.put(key,lastVal);

        }

        if (!checkTStrings(stringS, tStrings, possibleSol)){
            //No solution to problem
        }*/


    }

    private boolean checkTStrings(String stringS, Hashtable tStrings, Hashtable possibleSub) {
        Collection<String> ts = tStrings.values();

        for (String t: ts) {
            String subString = "";
            for (char c: t.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    subString += possibleSub.get(c);
                } else {
                    subString += c;
                }
            }
            if (!stringS.contains(subString)) {
                return false;
            }
        }

        return true;
    }

}
