// Class used to store a pair of elements that is comparable on the second element.
/*
In this class, we have two generics U and V, V extends Comparable so in any instance of this class its V is comparable.
And also the whole entire class is comparable, so if I made an object of this class I can compare it to other objects of this class.
 */
public class CompPair<U, V extends Comparable<V>> extends Pair<U, V> implements Comparable<CompPair<U, V>> {
	public CompPair(U first, V second) {
		super(first, second);
	}

	@Override
	public int compareTo(CompPair<U, V> other) { // In this method V is being compared to another V.
		return this.second.compareTo(other.second);
	}
}
