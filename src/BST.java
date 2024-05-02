import org.w3c.dom.Node;

public class BST<K extends Comparable<K>, T> implements Map<K, T> {
    BSTNode<K,T> root ;
    BSTNode<K,T>  current ;


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
    { // dont know how it can return the KEY  and data at same time >> should it return the node ???
        return current.data;
    }

    @Override
    public void update(T e) {

    }

    @Override
    public boolean find(K key) { // normal Find method except that the compareTo method will return 0 if the objects are equal -1 if p.key is bigger and 1 if the key is bigger
        BSTNode<K,T> p = root;
        while (p != null) {
            int cmp = key.compareTo(p.key);
            if (cmp == 0) {
                // Key found, update 'current' and return true
                current = p;
                return true;
            } else if (cmp < 0)
            {
                // Key is smaller than current node's key, search left subtree
                p = p.left;
            } else
            {
                // Key is greater than current node's key, search right subtree
                p = p.right;
            }
        }
        // Key not found
        return false;
    }

    @Override
    public int nbKeyComp(K key) {
        return 0;
    }

    @Override
    public boolean insert(K key, T data) {
        BSTNode<K,T> p = current ;
        if(find(key))
        {
            current = p ;
            return false ;
        }
        BSTNode<K,T> q = new BSTNode<K,T>(key , data) ;
        return false;
    }

    @Override
    public boolean remove(K key) {

        return false;
    }

    @Override
    public DLLComp getKeys() {

        return null;
    }

    public int size() // will return the size of the tree
    { return HelperCounter(root) ; }

  private int HelperCounter(BSTNode<K,T> node) //this method is going to count each node in the tree
  {
    if(node == null)
        return 0;
    int left = HelperCounter(node.left) ;
    int right = HelperCounter(node.right) ;
     return 1 + left + right ;
  }



}
