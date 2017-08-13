import domain.Leaf;
import main.LeafList;
import main.LeafListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeafListTest {
    private LeafList leafList;
    Leaf leaf1;
    Leaf leaf2;
    Leaf leaf3;

    @BeforeEach
    void init() {
        leafList = new LeafListImpl();
        leaf1 = new Leaf(1);
        leaf2 = new Leaf(2);
        leaf3 = new Leaf(3);
    }

    @Test
    public void testSize() {
        leafList.addLastLeaf(leaf1);
        leafList.addLastLeaf(leaf2);
        leafList.addLastLeaf(leaf3);
        assertEquals(3, leafList.size());
    }

    @Test
    public void testSort() {
        leafList.addLastLeaf(leaf2);
        leafList.addLastLeaf(leaf3);
        leafList.addLastLeaf(leaf1);
        leafList.sort();

        LeafList goalList = new LeafListImpl();
        goalList.addLastLeaf(leaf1);
        goalList.addLastLeaf(leaf2);
        goalList.addLastLeaf(leaf3);

        assertEquals(goalList, leafList);
    }

    @Test
    public void testAddFirstLeaf() {

        leafList.addFirstLeaf(leaf1);
        leafList.addFirstLeaf(leaf2);

        assertEquals(leaf2, leafList.getHeadLeaf());
    }

    @Test
    public void testAddLastLeaf() {

        leafList.addLastLeaf(leaf1);
        leafList.addLastLeaf(leaf2);

        assertEquals(leaf2, leafList.getLastLeaf());
    }

    @Test
    public void testJoinList() {

        LeafList leafList1 = new LeafListImpl(leaf1);
        leafList1.addLastLeaf(leaf2);
        LeafList leafList2 = new LeafListImpl(leaf3);
        leafList1.joinList(leafList2);

        leafList.addLastLeaf(leaf1);
        leafList.addLastLeaf(leaf2);
        leafList.addLastLeaf(leaf3);

        assertEquals(leafList, leafList1);
    }

    @Test
    public void testCutOverWeightList() {

        leafList.addLastLeaf(leaf1);
        leafList.addLastLeaf(leaf2);
        leafList.addLastLeaf(leaf3);
        LeafList residualLeast = leafList.cutOverWeightList(3);
        assertEquals(new LeafListImpl(leaf3), residualLeast);

    }

}