package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String subset;
    private final List<Node> children = new ArrayList<>();
    private final Node parent;
    private String value;

    public Node(Node parent) {
        this.parent = parent;
    }

    public String getSubset() {
        return subset;
    }

    public void setSubset(String subset) {
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
