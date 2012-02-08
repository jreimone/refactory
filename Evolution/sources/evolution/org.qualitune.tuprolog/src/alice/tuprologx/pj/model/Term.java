package alice.tuprologx.pj.model;

import alice.tuprologx.pj.annotations.*;

/**
 *
 * @author maurizio
 */
public abstract class Term<X extends Term<?>> {
	public abstract <Z> Z toJava();// {return null;}
	public static <Z extends Term<?>> Z fromJava(Object o) {
		if (o instanceof Integer) {
			return (Z)new Int((Integer)o);
		}
		else if (o instanceof java.lang.Double) {
			return (Z)new Double((java.lang.Double)o);
		}
		else if (o instanceof String) {
			return (Z)new Atom((String)o);
		}
		else if (o instanceof Boolean) {
			return (Z)new Bool((Boolean)o);
		}
		else if (o instanceof java.util.Collection<?>) {
			return (Z)new List<Term<?>>((java.util.Collection<?>)o);
		}
        else if (o instanceof Term<?>[]) {
			return (Z)new Cons<Term<?>, Compound<?>>("_",(Term<?>[])o);
		}
		else if (o instanceof Term<?>) {
			return (Z)o;
		}
        else if (o.getClass().isAnnotationPresent(Termifiable.class)) {
			//return (Z)new Cons(o);
            return (Z)new JavaTerm<Object>(o);
		}                
		/*else {
			throw new UnsupportedOperationException();
		}*/
        else {
            return (Z)new JavaObject<Object>(o);
        }
	}
        
    public abstract alice.tuprolog.Term marshal() /*{
            throw new UnsupportedOperationException();
        }*/;
        
    public static <Z extends Term<?>> Z unmarshal(alice.tuprolog.Term t) {
		if (Int.matches(t)) {
			return (Z)Int.unmarshal((alice.tuprolog.Int)t);
		}
		else if (Double.matches(t)) {
			return (Z)Double.unmarshal((alice.tuprolog.Double)t);
		}
        else if (JavaObject.matches(t)) {
			return (Z)JavaObject.unmarshalObject((alice.tuprolog.Struct)t);                        
		}
		else if (Atom.matches(t)) {
			return (Z)Atom.unmarshal((alice.tuprolog.Struct)t);
		}
		else if (Bool.matches(t)) {
			return (Z)Bool.unmarshal((alice.tuprolog.Struct)t);
		}
		else if (List.matches(t)) {
			return (Z)List.unmarshal((alice.tuprolog.Struct)t);
		}
        else if (JavaTerm.matches(t)) {
			return (Z)JavaTerm.unmarshalObject((alice.tuprolog.Struct)t.getTerm());
		}                
        else if (Cons.matches(t)) {
			return (Z)Cons.unmarshal((alice.tuprolog.Struct)t);                        
		}                
        else if (Var.matches(t)) {
			return (Z)Var.unmarshal((alice.tuprolog.Var)t);
		}
		else {System.out.println(t);
			throw new UnsupportedOperationException();
		}
	}
}













