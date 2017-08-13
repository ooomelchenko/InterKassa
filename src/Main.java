import domain.Leaf;
import domain.Node;
import main.LeafList;
import main.LeafListImpl;
import main.MyTree;
import main.MyTreeImpl;

public class Main {

    public static void main(String[] args) {

        LeafList leafList1 = new LeafListImpl();
        leafList1.addLastLeaf(new Leaf(6));
        leafList1.addLastLeaf(new Leaf(2));
        leafList1.addLastLeaf(new Leaf(4));
        leafList1.addLastLeaf(new Leaf(8));
        leafList1.addLastLeaf(new Leaf(10));
        leafList1.addLastLeaf(new Leaf(14));
        leafList1.addLastLeaf(new Leaf(12));
        leafList1.addLastLeaf(new Leaf(16));

        LeafList leafList2 = new LeafListImpl();
        leafList2.addLastLeaf(new Leaf(7));
        leafList2.addLastLeaf(new Leaf(1));
        leafList2.addLastLeaf(new Leaf(5));
        leafList2.addLastLeaf(new Leaf(13));
        leafList2.addLastLeaf(new Leaf(3));
        leafList2.addLastLeaf(new Leaf(9));

        Node headNode=new Node("head", leafList1);
        Node node2=new Node("n2");
        Node node3=new Node("n3", leafList2);
        Node node4=new Node("n4");
        Node node5=new Node("n5");
        Node node6=new Node("n6");

        headNode.setLeftNode(node2);
        node2.setRightNode(node3);
        node2.setLeftNode(node4);
        node4.setLeftNode(node5);
        node4.setRightNode(node6);

        MyTree myTree = new MyTreeImpl(headNode, 20);

        myTree.doTask();

        myTree.printTree();

    }
}