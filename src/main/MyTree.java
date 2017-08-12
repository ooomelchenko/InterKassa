package main;

import domain.Node;

/**
 * Created by HP-PC on 12/08/2017.
 */
public interface MyTree {
    int getW();

    void setW(int w);

    Node getHeadNode();

    void setHeadNode(Node headNode);

    boolean isEmpty();

    void printTree();

    void print(Node node);

    void doTest();

    LeafList manageLeafs(Node node, LeafList residualLeafList);
}
