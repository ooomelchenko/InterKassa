package main;

import domain.Node;

public interface MyTree {
    int getW();

    void setW(int w);

    Node getHeadNode();

    void setHeadNode(Node headNode);

    boolean isEmpty();

    void printTree();

    void print(Node node);

    void doTask();

    LeafList manageLeafs(Node node, LeafList residualLeafList);
}
