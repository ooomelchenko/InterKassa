package main;

import domain.Leaf;

public interface LeafList {

    Leaf getHeadLeaf();

    void setHeadLeaf(Leaf headLeaf);

    Leaf getLastLeaf();

    void setLastLeaf(Leaf lastLeaf);

    void addFirstLeaf(Leaf leaf);

    void addLastLeaf(Leaf leaf);

    int size();

    void sort();

    LeafListImpl cutOverWeightList(int maxTotalWeight);

    void joinList(LeafList leafList);
}
