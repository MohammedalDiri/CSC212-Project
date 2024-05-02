// Class used to store a pair of elements.
public class Pair<U, V> { // This class stores two generic types.
	public U first; // So is I made an object with reference to this class the object will have access to two generic types.
	public V second;

	public Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return first.toString() + "," + second.toString();
	}
}