package domain;

import main.LeafList;
import main.LeafListImpl;

public class Node {

    private String name;
    private Node rightNode;
    private Node leftNode;

    private LeafList leafList;

    public Node() {
        rightNode = null;
        leftNode = null;
        leafList = new LeafListImpl();
        name="unnamed";
    }
    public Node(String name) {
        this.name = name;
        leafList = new LeafListImpl();
    }
    public Node(LeafList leafList) {
        this.leafList = leafList;
    }
    public Node(String name, LeafList leafList) {
        this.name = name;
        this.leafList = leafList;
    }
    public Node(String name, Node rightNode, Node leftNode, LeafList leafList) {
        this.name=name;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
        this.leafList = leafList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Node getRightNode() {
        return rightNode;
    }
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public LeafList getLeafList() {
        return leafList;
    }
    public void setLeafList(LeafList leafList) {
        this.leafList = leafList;
    }

    public boolean hasLeft() {
        return leftNode != null;
    }
    public boolean hasRight() {
        return rightNode != null;
    }

    @Override
    public String toString() {
        return name + " {leafList: " + leafList + '}';
    }
}