package main;

import domain.Node;

public class MyTreeImpl implements MyTree {

    private Node headNode;
    private int W;

    public MyTreeImpl() {
    }
    public MyTreeImpl(Node headNode, int W) {
        this.headNode = headNode;
        this.W = W;
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
    public void doTest() {
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

}
