/*
 * List.java
 *
 * Created on March 8, 2007, 5:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package alice.tuprologx.pj.model;
import java.util.*;
/**
 *
 * @author maurizio
 */
public class List<X extends Term<?>> extends Term<List<X>> implements Iterable<X> {
//public class List<X extends Term<?>> extends Compound<List<X>> {
	protected java.util.Vector<X> _theList;
        
        public final static List<?> NIL = new List<Term<?>>(new Vector<Term<?>>());
        
        List(Vector<X> lt) {
		_theList = lt;		
	}
        
	public <Z> List(Collection<Z> cz) {
		_theList = new Vector<X>(cz.size());
		for (Z z : cz) {
			_theList.add(Term.<X>fromJava(z));
		}
	}
	
	public <Z> Z/*Collection<Z>*/ toJava() {
		Vector<Z> _javaList = new Vector<Z>(_theList.size());
		for (Term<?> t : _theList) {
			_javaList.add((Z)t.toJava());
		}
		return (Z)_javaList;	
	}

	public String toString() {
		return "List"+_theList;
	}
        
        public X getHead() {
            return _theList.get(0);
        }
        
        public List<X> getTail() {
            Vector<X> tail = (Vector<X>)_theList.clone();
            tail.remove(0);
            return new List<X>(tail);
        }
        
        public alice.tuprolog.Struct marshal() {
            alice.tuprolog.Term[] termArray = new alice.tuprolog.Term[_theList.size()];
            int i=0;
            for (Term<?> t : _theList) {
                termArray[i++]=t.marshal();
            }
            return new alice.tuprolog.Struct(termArray);
        }
        
        static <Z extends Term<?>> List<Z> unmarshal(alice.tuprolog.Struct s) {
            if (!matches(s))
                throw new UnsupportedOperationException();
            Iterator<? extends alice.tuprolog.Term> listIt = s.listIterator();
            Vector<Term<?>> termList = new Vector<Term<?>>();
            while (listIt.hasNext())
                termList.add(Term.unmarshal(listIt.next()));
            return new List<Z>(termList);
        }
        
        static boolean matches(alice.tuprolog.Term t) {
            return (!(t instanceof alice.tuprolog.Var) && t.isList() && t instanceof alice.tuprolog.Struct);
        }

        public Iterator<X> iterator() {
            return _theList.iterator();
        }
        
        public static List<Atom> tokenize(java.util.StringTokenizer stok) {            
            java.util.Vector<String> tokens = new java.util.Vector<String>();      
            while (stok.hasMoreTokens()) {
                tokens.add(stok.nextToken());
            }
            return new List<Atom>(tokens);
        }
}