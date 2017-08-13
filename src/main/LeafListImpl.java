package main;

import domain.Leaf;

public class LeafListImpl implements LeafList {

    private Leaf headLeaf;
    private Leaf lastLeaf;

    public LeafListImpl() {
        headLeaf = null;
    }
    public LeafListImpl(Leaf headLeaf) {
        this.headLeaf = headLeaf;
        this.lastLeaf = headLeaf;
    }

    @Override
    public Leaf getHeadLeaf() {
        return headLeaf;
    }
    @Override
    public void setHeadLeaf(Leaf headLeaf) {
        this.headLeaf = headLeaf;
    }
    @Override
    public Leaf getLastLeaf() {
        return lastLeaf;
    }
    @Override
    public void setLastLeaf(Leaf lastLeaf) {
        this.lastLeaf = lastLeaf;
    }
    @Override
    public void addFirstLeaf(Leaf leaf) {
        if(leaf==null){
            return;
        }
        if (headLeaf != null) {
            leaf.setNext(headLeaf);
            headLeaf = leaf;
        } else {
            headLeaf = leaf;
            lastLeaf = leaf;
        }
    }
    @Override
    public void addLastLeaf(Leaf leaf) {
        if(leaf==null){
            return;
        }
        if (headLeaf != null) {
            lastLeaf.setNext(leaf);
            lastLeaf = leaf;
        } else {
            headLeaf = leaf;
            lastLeaf = leaf;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeafListImpl leafList = (LeafListImpl) o;

        return (headLeaf != null ? headLeaf.equals(leafList.headLeaf) : leafList.headLeaf == null) && (lastLeaf != null ? lastLeaf.equals(leafList.lastLeaf) : leafList.lastLeaf == null);
    }
    @Override
    public int hashCode() {
        int result = headLeaf != null ? headLeaf.hashCode() : 0;
        result = 31 * result + (lastLeaf != null ? lastLeaf.hashCode() : 0);
        return result;
    }

    @Override
    public int size() {
        if (headLeaf == null) {
            return 0;
        }
        int size = 1;
        Leaf last = headLeaf;
        while (last.hasNext()) {
            last = last.getNext();
            size++;
        }
        return size;
    }
    @Override
    public void sort() {
        if (size() < 2)
            return;
            for (int i = 0; i < size() - 1; i++) {
                Leaf current = headLeaf;
                Leaf prev = null;
                while (current.hasNext()) {
                    Leaf next = current.getNext();

                    if (current.compareTo(next) == 1) {

                        if (prev != null) {
                            prev.setNext(next);
                        } else
                            headLeaf = next;

                            current.setNext(next.getNext());
                            next.setNext(current);

                    }
                    prev = current;
                    current = next;
                }
                lastLeaf=current;
            }
    }
    @Override
    public String toString() {
        if (headLeaf == null) {
            return "empty list";
        }

        Leaf last = headLeaf;
        String rez = headLeaf.toString();
        while (last.getNext() != null) {
            rez += last.getNext();
            last = last.getNext();
        }
        return rez;
    }
    @Override
    public LeafListImpl cutOverWeightList(int maxTotalWeight) {
        if (headLeaf == null) {
            return null;
        } else if (headLeaf.getWeight() > maxTotalWeight) {
            LeafListImpl l= new LeafListImpl(headLeaf);
            l.setLastLeaf(lastLeaf);
            return l;
        }
        else {
            Leaf current = headLeaf;

            maxTotalWeight-=headLeaf.getWeight();

            while (current.hasNext()) {
                maxTotalWeight-=current.getNext().getWeight();

                if (maxTotalWeight < 0) {
                    Leaf newHeadLeaf = current.getNext();
                    Leaf newLastLeaf = lastLeaf;
                    lastLeaf = current;
                    lastLeaf.setNext(null);

                    LeafListImpl l= new LeafListImpl(newHeadLeaf);
                    l.setLastLeaf(newLastLeaf);
                    return l;
                }
                current = current.getNext();
            }
        }
        return null;
    }
    @Override
    public void joinList(LeafList leafList) {
        if (headLeaf == null && leafList != null) {
            headLeaf = leafList.getHeadLeaf();
            lastLeaf = leafList.getLastLeaf();
        } else if (leafList != null) {
            this.lastLeaf.setNext(leafList.getHeadLeaf());
            this.lastLeaf = leafList.getLastLeaf();
        }
    }

}