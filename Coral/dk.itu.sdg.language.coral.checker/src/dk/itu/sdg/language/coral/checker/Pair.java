package dk.itu.sdg.language.coral.checker;

/** @author Lu’s Cardoso - lfac@student.dei.uc.pt - http://student.dei.uc.pt/~lfac/ - Portugal*/
/** @author ropf --> applied modifications
 * 
 */
import java.io.Serializable;

public class Pair<T, K> implements Comparable<Pair<T, K>>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3512465139902557486L;
	public T fst;
	public K snd;
	
	public Pair(T fst, K snd) {
		this.fst = fst;
		this.snd = snd;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Pair)) return false;
		Pair<T, K> p = (Pair<T, K>) o;
		return p.fst.equals(fst) && p.snd.equals(snd);
	}
	
	public String toString() {
		return "<" + fst + ", " + snd + ">";
	}
	
	public int compareTo(Pair<T, K> o) {
		if (snd instanceof String) {
			String thisString = (String) snd;
			String otherString = (String) o.snd;
			return thisString.compareTo(otherString);
		} else if (snd instanceof Integer) {
			return ((Integer) snd).compareTo((Integer) o.snd);
		} else if (snd instanceof Double) {
			return ((Double) snd).compareTo((Double) o.snd);
		}
			return 0;
		}
}
