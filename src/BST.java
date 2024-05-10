public class BST<K extends Comparable<K>, T> implements Map<K, T> {
    private BSTNode<K,T> root ;
    private BSTNode<K,T>  current ;
    private int size ;


    public BST()
    {
        root = current = null;
        size = 0 ;
    }



    public boolean empty()
    {
        return root == null;
    } // no need for explanation

    @Override
    public void clear()
    {root = null ;} // this will simple clear the whole tree , garbage collector will clean up these unreferenced nodes


    public T retrieve ()
    { // return the Key and Value of the Node this is why i used Pair


        if (current != null) {
            return current.data;
        }
        return null;  // or throw an exception if 'current' being null is unexpected

    }

    @Override
    public void update(T e)
    {
        current.data = e; // normal update
    }

    @Override
    public boolean find(K key)
    { // normal Find method except that the compareTo method will return 0 if the objects are equal -1 if p.key is bigger and 1 if the key is bigger
        BSTNode<K,T> p = root;
        while (p != null)
        {
            int cmp = key.compareTo(p.key);
            if (cmp == 0)
            {
                // Key found update 'current' and return true
                current = p;
                return true;
            } else if (cmp < 0)
            {
                // Key is smaller than current key search left subtree
                p = p.left;
            } else
            {
                // Key is greater than current key search right subtree
                p = p.right;
            }
        }
        // Key not found
        return false;
    }

    @Override
    public int nbKeyComp(K key)
    {
// this method works same as find() except that it counts how many nodes it has visited before finding the key starting from root key
        // and important note that it does not move the current
        // compareTo() was explained above in Find()
        BSTNode<K,T> p = root;
        int count = 0;
        while (p != null)
        {
            count++;
            int cmp = key.compareTo(p.key);
            if (cmp == 0)
            {
                return count;  // Key found
            } else if (cmp < 0) {
                p = p.left;
            } else
            {
                p = p.right;
            }
        }
        return count;
    }

    @Override
    public boolean insert(K key, T data)
    { // p was defined to keep the current original place after using find()
        BSTNode<K,T> p = current ;
        if(Helper_find(key))
        {
            current = p ;
            return false ;
        }
        BSTNode<K,T> q = new BSTNode<K,T>(key , data) ;
        if(empty())
        {
            root = current = q ;
            size++ ;
            return true ;
        }
        int cmp = key.compareTo(current.key);
        if(cmp < 0)
        { current.left = q ;
            size++ ;
            return true ;
        }
        else if(cmp > 0)
        {
            current.right = q;
            size++ ;
            return true ;
        } // no need to handle the 0 case because its an impossible case
        return false;
    }
    private boolean Helper_find(K key) // Helper method for the insert.
    { // normal Find method except that the compareTo method will return 0 if the objects are equal -1 if p.key is bigger and 1 if the key is bigger
        BSTNode<K,T> p = root;
        while (p != null)
        {
            int cmp = key.compareTo(p.key);
            if (cmp == 0)
            {
                // Key found update 'current' and return true
                current = p;
                return true;
            } else if (cmp < 0)
            {
                // Key is smaller than current key search left subtree
                current = p;
                p = p.left;
            } else
            {
                // Key is greater than current key search right subtree
                current = p; //
                p = p.right;
            }
        }
        // Key not found
        return false;
    }

    @Override
    public boolean remove(K key)
    { // this was written by bader

        boolean[] removed = new boolean[1];
        removed[0] = false; // This array is made to pass "removed" by reference not value.
        BSTNode<K,T> p;
        p = helper_remove(key, root, removed); //here we used array to modify the value in the helper method
        root = p;
        return removed[0];
    }

    @Override
    public DLLComp<K> getKeys()
    {
        // getting all keys in BST
    DLLComp<K> tmp = new DLLCompImp<>();
        HelperInserter(root , tmp);
        return tmp ;
    }

    public int size() // will return the size of the tree
    { return size ; }


    private void HelperInserter(BSTNode<K, T> node, DLLComp<K> tmp)
    {
        // this method will insert all keys in increasing order because we are going in " IN ORDER " and BST is always sorted in insertion
        if (node == null)
        {
            return;
        }
        HelperInserter(node.left, tmp);  // this call will handle all left subtree
        tmp.insert(node.key);           //  insert the current key
        HelperInserter(node.right, tmp); // handling right subtree
    }

    private BSTNode<K,T> Helperfind_min(BSTNode<K,T> p)
    { // this was written by bader
        // helper method to find the minimum value
        if(p == null)
            return null;

        while(p.left != null)
        {
            p = p.left;
        }

        return p;
    }

    public BSTNode<K,T> find_min()
    {return Helperfind_min(root);}

    private BSTNode<K,T> Helperfind_max(BSTNode<K,T> p)
    {
        if(p == null)
            return null;

        while(p.right != null)
        {
            p = p.right;
        }

        return p;
    }
    public BSTNode<K,T> find_max()
    {return Helperfind_max(root);}

    private BSTNode<K,T> helper_remove(K key, BSTNode<K, T> p, boolean[] flag)
    { // this was written by bader
        // this helper method to handle all three cases and remove the key and modify the tree if needed
        BSTNode<K, T> q, child = null;
        if(p == null)
            return null;
        if(key.compareTo(p.key) < 0)
            p.left = helper_remove(key, p.left, flag); //go left
        else if(key.compareTo(p.key) > 0)
            p.right = helper_remove(key, p.right, flag); //go right
        else {
            size-- ;
            flag[0] = true;
            if (p.left != null && p.right != null)
            { //two children
                q = Helperfind_min(p.right);
                p.key = q.key;
                p.data = q.data;
                p.right = helper_remove(q.key, p.right, flag);
            }
            else
            {
                if (p.right == null) //one child
                    child = p.left;
                else if (p.left == null) //one child
                    child = p.right;
                return child;
            }
        }
        return p;
    }
    public DLLImp<T> getData(){ // This method should help with the get data points method.
        DLLImp<T> SortedPoints = new DLLImp<>();
        getDataHelper( root, SortedPoints);
        return SortedPoints;
    }
    private void getDataHelper( BSTNode<K,T> t, DLLImp<T> L){
        if(t == null)
            return;
        else{
            getDataHelper(t.left, L);
            L.insert(t.data);
            getDataHelper(t.right, L);
        }
    }

}
