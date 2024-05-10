public class BSTTest {

    public static void main(String[] args) {


        BST<Double, String> bt = new BST<Double, String>();
        System.out.println("num of elements=" + bt.size());
        System.out.println("is empty ? :" + bt.empty());
        System.out.println("---------------------------------------------");
        System.out.println("inserting 11 nodes");
        bt.insert(35.0, "A");
        bt.insert(14.0, "B");
        bt.insert(5.0, "B");
        bt.insert(33.0, "D");
        bt.insert(53.0, "E");
        bt.insert(50.0, "C");
        bt.insert(44.0, "F");
        bt.insert(40.0, "G");
        bt.insert(58.0, "H");
        bt.insert(55.0, "I");
        bt.insert(56.0, "I");
        System.out.println("all nodes are ");
        bt.displayAllNodesInOrder();
        System.out.println("------------------getkeys---------------------");
        System.out.println("all keys are ");
        DLLComp<Double> d1 = bt.getKeys();
        DLLImp.display(d1);

        System.out.println("------------------nbKeyComp---------------------");
        System.out.println("bt.nbKeyComp(35.0): " + bt.nbKeyComp(35.0));
        System.out.println("bt.nbKeyComp(5.0): " + bt.nbKeyComp(5.0));
        System.out.println("bt.nbKeyComp(4.0): " + bt.nbKeyComp(4.0));
        System.out.println("bt.nbKeyComp(40.0): " + bt.nbKeyComp(40.0));
        System.out.println("bt.nbKeyComp(56.0): " + bt.nbKeyComp(56.0));
        System.out.println("bt.nbKeyComp(57.0): " + bt.nbKeyComp(57.0));
        System.out.println("bt.nbKeyComp(59.0): " + bt.nbKeyComp(59.0));
        System.out.println("-------------------removing---------------------");
        System.out.println("all nodes are ");
        bt.displayAllNodesInOrder();
        System.out.println("removing 35");
        bt.remove(35.0);
        bt.displayAllNodesInOrder();
        System.out.println("removing 53");
        bt.remove(53.0);
        bt.displayAllNodesInOrder();
        System.out.println("removing 50");
        bt.remove(50.0);
        bt.displayAllNodesInOrder();
        System.out.println("----------find size,empty,update,retrieve---------");
        System.out.println("bt.find(13.0) :" + bt.find(13.0));
        System.out.println("bt.find(2.7) :" + bt.find(2.7));
        System.out.println("bt.find(50.0) :" + bt.find(50.0));
        System.out.println("bt.find(55.0) :" + bt.find(55.0));
        System.out.println("num of elements=" + bt.size());
        System.out.println("is empty ? :" + bt.empty());
        System.out.println("current exist at " + bt.retrieve());
        bt.update("KK");
        System.out.println("after update current exist at " + bt.retrieve());
        bt.displayAllNodesInOrder();


    }
}


