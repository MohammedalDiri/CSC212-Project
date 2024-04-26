import org.w3c.dom.Node;

public class BST<T> implements Map{
    BSTNode<T> root ;
    BSTNode<T>  current ;


    public BST()
    {
        root = current = null;
    }

    public boolean empty()
    {
        return root == null;
    } // no need for explanation

    @Override
    public void clear()
    {root = null ;} // this will simple clear the whole tree , garbage collector will clean up these unreferenced nodes


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

    public int size() // will return the size of the tree
    { return HelperCounter(root) ; }

  private int HelperCounter(BSTNode<T> node) //this method is going to count each node in the tree
  {
    if(node == null)
        return 0;
    int left = HelperCounter(node.left) ;
    int right = HelperCounter(node.right) ;
     return 1 + left + right ;
  }



}
