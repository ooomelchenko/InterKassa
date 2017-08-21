import domain.Node;
import main.LeafList;
import main.MyTreeImpl;

public class Main {

    public static void main(String[] args) {

        Node head= new Node("head", LeafList.getRandomList(3, 10));
        Node a= new Node("a");
        Node a1= new Node("a1", LeafList.getRandomList(3, 5));
        Node a2= new Node("a2", LeafList.getRandomList(3, 10));
        Node a3= new Node("a3");
        Node b= new Node("b", LeafList.getRandomList(3, 5));
        Node b1= new Node("b1", LeafList.getRandomList(3, 5));
        Node b2= new Node("b2", LeafList.getRandomList(3, 5));
        Node b3= new Node("b3");
        Node c= new Node("c", LeafList.getRandomList(3, 5));
        Node c1= new Node("c1", LeafList.getRandomList(3, 3));
        Node c2= new Node("c2", LeafList.getRandomList(3, 5));
        Node c3= new Node("c3");

        head.setLeftNode(a);
        a.setRightNode(b);
        b.setRightNode(c);

        a.setLeftNode(a1);
        a1.setRightNode(a2);
        a2.setRightNode(a3);

        b.setLeftNode(b1);
        b1.setRightNode(b2);
        b2.setRightNode(b3);

        c.setLeftNode(c1);
        c1.setRightNode(c2);
        c2.setRightNode(c3);

        MyTreeImpl myTree = new MyTreeImpl(head, 5);
        myTree.setHeadNode(head);
        myTree.doTask();

        System.out.println("-------------- After Sort ----------------");
        while(myTree.hasNext()){
            System.out.println(myTree.next());
        }
    }
}