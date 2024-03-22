public class DLLCompImp<T> implements DLLComp<T extends Comparable<T>> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public boolean last() {
        return false;
    }

    @Override
    public boolean first() {
        return false;
    }

    @Override
    public void findFirst() {

    }

    @Override
    public void findNext() {

    }

    @Override
    public void findPrevious() {

    }

    @Override
    public T retrieve() {
        return null;
    }

    @Override
    public void update(T val) {

    }

    @Override
    public void insert(T val) {

    }

    @Override
    public void remove() {

    }

    @Override
    public void sort(boolean increasing) {

    }

    @Override
    public T getMax() {
        return null;
    }

    @Override
    public T getMin() {
        return null;
    }
}
