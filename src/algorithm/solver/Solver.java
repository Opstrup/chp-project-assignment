package algorithm.solver;

import algorithm.Node;

import java.util.Collection;
import java.util.Enumeration;
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

    private void makeTreeRec(Node parent, Hashtable rSets, String[] subsetArray, Enumeration rSetsIndex) {
        if (rSets.isEmpty()) {
            // Break out of recursive call
        }

        // Take first element out of rSets
        // Take first element out of subsetArray
        // Create node from element in rSet and element in subsetArray
        // Set nodes parent
        // Make recursive call with the new node, rest of rSets and rest of subsetArray

        rSets.get(rSetsIndex);
        rSetsIndex.nextElement();

        Node myNode = new Node(parent, "", subsetArray[0]);

        makeTreeRec(myNode, rSets, subsetArray);
    }

    /*
     * Creating tree from rSets
     */
    private Node makeTree(Hashtable rSets) {
        Node treeRootNode = new Node(null, null, "root");

        Enumeration enumrKey = rSets.keys();

        while (enumrKey.hasMoreElements()) {
            Character subset = (Character) enumrKey.nextElement(); //the capital letter
            String[] rSet = (String[]) rSets.get(subset); //the lower-case letter

            for (String value: rSet) {
                Node myNode = new Node(treeRootNode, value, String.valueOf(subset));
                //treeRootNode.addChild()
            }
        }

        /*// add child to root node
        Node childNode = addChild(treeRootNode, "child-1");
        // add child to the child node created above
        addChild(childNode, "child-11");
        addChild(childNode, "child-12");


        // add child to root node
        Node child2 = addChild(treeRootNode, "child-2");
        // add child to the child node created above
        addChild(child2, "child-21");*/

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
