package algorithm.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

class Node {
    private Character subset;
    private final List<Node> children = new ArrayList<>();
    private final Node parent;
    private String value;

    Node(){
    parent = null;
    }
    Node(Node parent, String value, Character subset) {
          this.parent = parent;
          this.value = value;
          this.subset = subset;
    }

    void addChild(Node child){
        children.add(child);
    }
    boolean isLeaf(){
        return children.size() == 0;
    }
    Character getSubset() {
        return subset;
    }

    String getValue() {
        return this.value;
    }

    List<Node> getChildren() {
        return children;
    }
    Node getParent() {
        return parent;
    }

}
