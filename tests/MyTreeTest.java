import domain.Leaf;
import domain.Node;
import main.LeafList;
import main.LeafListImpl;
import main.MyTree;
import main.MyTreeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTreeTest {
    private MyTree myTree;
    private LeafList leafList;
    Leaf leaf1 = new Leaf(1);
    Leaf leaf2 = new Leaf(2);
    Leaf leaf3 = new Leaf(3);
    Leaf leaf4 = new Leaf(4);
    Leaf leaf5 = new Leaf(5);

    @BeforeEach
    void init() {
        leaf1 = new Leaf(1);
        leaf2 = new Leaf(2);
        leaf3 = new Leaf(3);
        leaf4 = new Leaf(4);
        leaf5 = new Leaf(5);
        leafList = new LeafListImpl();

        myTree = new MyTreeImpl(5);

    }

    @Test
    public void testManageLeafs() {

        leafList.addLastLeaf(leaf1);
        leafList.addLastLeaf(leaf3);
        leafList.addLastLeaf(leaf4);

        LeafList tempList = new LeafListImpl(leaf2);
        tempList.addLastLeaf(leaf5);

        LeafList goalList = new LeafListImpl();
        goalList.addLastLeaf(leaf3);
        goalList.addLastLeaf(leaf4);
        goalList.addLastLeaf(leaf5);

        assertEquals(goalList, myTree.manageLeafs(new Node(leafList), tempList));

    }
}
