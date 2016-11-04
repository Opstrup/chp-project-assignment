package algorithm.solver;

import algorithm.decoder.Decoder;
import algorithm.reducer.Reducer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solver {
    private boolean found = false;
    private Hashtable<Character,String> solution;
    private ConcurrentHashMap<Character,String> solutionCon;
    private final Node tree;
    public Solver(){
        tree = new Node();
    }

    /**
     * Method for creating a tree structure of the rSets
     * @param parent Node parent of current node
     * @param rSets HashTable with the sets to create the tree from.
     * @param rSetsKeys Character[] with the keys for the array.
     * @param rSetsIndex int index of which key/array is currently being created.
     */
    private void makeTreeRec(Node parent, Hashtable<Character, String[]> rSets, Character[] rSetsKeys, int rSetsIndex) {
        Character key = rSetsKeys[rSetsIndex];
        String[] rSet = rSets.get(key);
        if (rSetsKeys.length-1 == rSetsIndex) {//
            // Break out of recursive call
            for (String r: rSet) {
                Node child = new Node(parent, r, key);
                if (parent !=null) parent.addChild(child);
            }
        }else{
            // Take element of rSet
            // Create node from element in rSet and key to element
            // Set nodes parent
            // Make recursive call with the new node, rest of rSets and rest of subsetArray
            for (String r: rSet) {
                Node child = new Node(parent, r, key);
                if (parent !=null) parent.addChild(child);
            }
            if (parent != null) {
                for (Node n: parent.getChildren()){
                     makeTreeRec(n, rSets, rSetsKeys, rSetsIndex+1);
                }
            }
        }
    }
    private void traverseTree(Node tree, String s, Collection<String> tStrings){
        if(tree.isLeaf()&& !found){
            Hashtable<Character, String> possibleSol = new Hashtable<>();
            while(tree.getParent()!=null){
                possibleSol.put(tree.getSubset(),tree.getValue());
                tree = tree.getParent();
            }
            boolean result = checkTStrings(s,tStrings,possibleSol);
            if (result){
                found = true;
                solution = possibleSol;
            }
        }else if (!found){
            //Traverse tree mutithreaded
            tree.getChildren().parallelStream().forEach(child->traverseTree(child,s,tStrings));
            /*for(Node child:tree.getChildren()){
                traverseTree(child,s, tStrings);
            }*/
        }
    }

    public Hashtable<Character,String> bruteForceSolve() {

        String stringS = Decoder.getS();
        Collection<String> tStrings = Reducer.removeDuplicateTs(Decoder.gettStrings());
        Hashtable<Character, String[]> rSets = Reducer.removeUnused(Decoder.getS(),Decoder.getrSets());
        ArrayList<Character> rSetKeys = new ArrayList<>(Collections.list(rSets.keys()));
        makeTreeRec(tree, rSets,rSetKeys.toArray(new Character[0]),0);
        traverseTree(tree,stringS,tStrings);
        Hashtable<Character,String> unUsed = Reducer.getUnUsed();
        //Add the unused Chars to the solution.
        unUsed.forEach(solution::put);
        return solution;

    }

    private static boolean checkTStrings(String stringS, Collection<String> tStrings, Hashtable possibleSol) {
        for (String t: tStrings) {
            String subString = "";
            for (char c: t.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    subString += possibleSol.get(c);
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
