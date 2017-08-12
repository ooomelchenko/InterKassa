package domain;

public class Leaf implements Comparable{
    private int weight;
    private Leaf next;

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Leaf getNext() {
        return next;
    }
    public void setNext(Leaf nextLeaf) {
        this.next = nextLeaf;
    }

    public boolean hasNext(){
        return next != null;
    }

    public Leaf() {
    }
    public Leaf(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object obj) {
        Leaf el = (Leaf) (obj);
        if (this.weight - el.getWeight() < 0)
            return -1;
        else if (this.weight - el.getWeight() > 0)
            return 1;
        else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leaf leaf = (Leaf) o;

        return weight == leaf.weight;
    }

    @Override
    public int hashCode() {
        return weight;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "weight=" + weight +
                '}';
    }
}