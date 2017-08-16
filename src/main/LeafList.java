package main;

import domain.Leaf;

public interface LeafList {

    static LeafList getRandomList(int size, int maxLeafWeight){
        LeafList leafList = new LeafListImpl();
        while(size>0){
            leafList.addLastLeaf(new Leaf(1 + (int)(Math.random() * ((maxLeafWeight - 1) + 1))));
            size--;
        }
        return leafList;
    }

    Leaf getHeadLeaf();

    void setHeadLeaf(Leaf headLeaf);

    Leaf getLastLeaf();

    void setLastLeaf(Leaf lastLeaf);

    void addFirstLeaf(Leaf leaf);

    void addLastLeaf(Leaf leaf);

    boolean isEmpty();

    int size();

    int totalWeight();

    void sort();

    LeafListImpl cutOverWeightList(int maxTotalWeight);

    void joinList(LeafList leafList);
}
