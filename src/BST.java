import java.util.*;
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



    public T retrieve ()
    { // still not completed it should return the key also not just the data
        return current.data;
    }

    public int size()
    { return co ; }


}
