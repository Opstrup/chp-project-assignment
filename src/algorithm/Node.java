package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Character subset;
    private final List<Node> children = new ArrayList<>();
    private final Node parent;
    private String value;
    public Node(){
    parent = null;
    }
    public Node(Node parent, String value, Character subset) {
          this.parent = parent;
          this.value = value;
          this.subset = subset;
    }

    public Node addChild(Node child){
        children.add(child);
        return child;
    }
    public boolean isLeaf(){
        return children.size() == 0;
    }
    public Character getSubset() {
        return subset;
    }

    public void setSubset(Character subset) {
        this.subset = subset;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }
}
