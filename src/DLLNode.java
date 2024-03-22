public class DLLNode<T> {
    public T data;
    public DLLNode<T> next;
    public DLLNode<T> prev;

    public DLLNode(T data) {
        this.data = data;
        next = prev = null;
    }
    //No need for setters and getters!
}
