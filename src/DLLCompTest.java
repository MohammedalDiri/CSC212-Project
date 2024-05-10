public class DLLCompTest {
    public static void main(String[] args) {

        DLLCompImp<Integer> d1 = new DLLCompImp<Integer>();
        d1.insert(70);
        d1.insert(30);
        d1.insert(10);
        d1.insert(60);
        d1.insert(20);
        d1.insert(50);
        d1.insert(40);
        DLLImp.display(d1);
        System.out.println("---------removing first---------");
        d1.findFirst();
        d1.remove();
        DLLImp.display(d1);
        System.out.println("---------removing third---------");
        d1.findFirst();
        d1.findNext();
        d1.findNext();
        d1.remove();
        DLLImp.display(d1);
        System.out.println("---------min, max, and sorting---------");


        DLLCompImp<Integer> d2 = new DLLCompImp<Integer>();
        d2.insert(70);
        d2.insert(30);
        d2.insert(10);
        d2.insert(60);
        d2.insert(20);
        d2.insert(50);
        d2.insert(40);
        DLLImp.display(d2);
        System.out.println("min=" + d2.getMin());
        System.out.println("max=" + d2.getMax());
        System.out.println("sorted increasing");
        d2.sort(true);
        DLLImp.display(d2);
        System.out.println("sorted decreasing");
        d2.sort(false);
        DLLImp.display(d2);
    }

}
