package main;

import domain.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyTreeImpl implements MyTree, Iterator {

    private Node headNode;
    private int W;

    private Stack<Node> fringe = new Stack<>( );

    public MyTreeImpl(Node headNode, int W) {
        this.headNode = headNode;
        this.W = W;

        if (headNode != null) {
            fringe.push (headNode);
        }
    }

    @Override
    public int getW() {
        return W;
    }
    @Override
    public void setW(int w) {
        W = w;
    }
    @Override
    public Node getHeadNode() {
        return headNode;
    }
    @Override
    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }
    @Override
    public boolean isEmpty() {
        return headNode == null;
    }
    @Override
    public void printTree(){
        print(headNode);
    }
    @Override
    public void print(Node node) {
        System.out.println(node.toString());
        if(node.hasRight()){
            print(node.getRightNode());
        }
        if(node.hasLeft()){
            print(node.getLeftNode());
        }
    }
    @Override
    public void doTask() {
        manageLeafs(headNode, new LeafListImpl());
    }
    @Override
    public LeafList manageLeafs(Node node, LeafList residualLeafList) {
        LeafList curLeafList = node.getLeafList();
        curLeafList.joinList(residualLeafList);
        curLeafList.sort();
        LeafList offcutList = curLeafList.cutOverWeightList(W);
        if (node.hasRight()) {
            offcutList = manageLeafs(node.getRightNode(), offcutList);
        }
        if (node.hasLeft()) {
            offcutList = manageLeafs(node.getLeftNode(), offcutList);
        }
        return offcutList;
    }

    @Override
    public boolean hasNext() {
        return !fringe.empty ( );
    }

    @Override
    public Node next() {
        if (!hasNext ( )) {
            throw new NoSuchElementException("tree ran out of elements");
        }
        Node node = fringe.pop ( );

        if (node.hasRight()) {
            fringe.push (node.getRightNode());
        }
        if (node.hasLeft()) {
            fringe.push (node.getLeftNode());
        }
        return node;
    }

}