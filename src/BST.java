public class BST<T> implements Map{
    BSTNode<T> root ;
    BSTNode<T>  current ;
    private int co = 0 ;

    public BST()
    {
        root = current = null;
    }

    public boolean empty()
    {
        return root == null;
    }

    @Override
    public void clear() {

    }


    public T retrieve ()
    { // still not completed it should return the key also not just the data
        return current.data;
    }

    @Override
    public void update(Object e) {

    }

    @Override
    public boolean find(Comparable key) {
        return false;
    }

    @Override
    public int nbKeyComp(Comparable key) {
        return 0;
    }

    @Override
    public boolean insert(Comparable key, Object data) {
        return false;
    }

    @Override
    public boolean remove(Comparable key) {
        return false;
    }

    @Override
    public DLLComp getKeys() {
        return null;
    }

    public int size()
    { return co ; }



}
