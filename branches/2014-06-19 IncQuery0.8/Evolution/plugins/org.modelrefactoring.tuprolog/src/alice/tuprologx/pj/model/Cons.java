package alice.tuprologx.pj.model;

import java.util.*;

/**
 *
 * @author Maurizio
 */
public class Cons<H extends Term<?>, R extends Compound<?>> extends Compound<Cons<H,R>> implements Iterable<Term<?>> {
        
    
    String _theName;
    H _theHead;	
    R _theRest;

    public Cons(String name, H head) {
        _theHead = head;
        _theName = name;
        _theRest = (R)new Nil();
    }

    protected Cons(String name, java.util.List<Term<?>> termList) {
        initFromList(termList);
        _theName = name;        
    }
    
    public static <Z extends Cons<?,?>> Z make(String f, Term<?>[] termList) {        
        if (termList.length == 1)
            return (Z)new Compound1<Term<?>>(f,termList[0]);
        else if (termList.length == 2)
            return (Z)new Compound2<Term<?>, Term<?>>(f,termList[0],termList[1]);
        else if (termList.length == 3)
            return (Z)new Compound3<Term<?>, Term<?>, Term<?>>(f,termList[0],termList[1],termList[2]);
        else if (termList.length > 3)
            return (Z)new Cons<Term<?>, Compound<?>>(f,termList);
        else
            throw new UnsupportedOperationException();
    }
    /*
    Cons(Object po) {            
        try {
            java.util.Vector<Term<?>> termArr = new java.util.Vector<Term<?>>();
            java.beans.BeanInfo binfo = java.beans.Introspector.getBeanInfo(po.getClass());
            for (java.beans.PropertyDescriptor pdesc : binfo.getPropertyDescriptors()) {
                //only read-write properties are translated into a compound
                if (pdesc.getReadMethod()!=null && pdesc.getWriteMethod()!=null) { 
                    Object o = pdesc.getReadMethod().invoke(po);
                    Atom propertyName = new Atom(pdesc.getName());
                    Term<?> propertyValue = Term.fromJava(o);
                    termArr.add(new Cons<Atom,Cons<Term<?>,Nil>>("_property",new Term<?>[] {propertyName, propertyValue}));
                }
            }
            _theName = binfo.getBeanDescriptor().getBeanClass().getName();            
            initFromList(termArr);
        }              
        catch (UnsupportedOperationException e) {
            throw e;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
    public Iterator<Term<?>> iterator() {
        return new Iterator<Term<?>>() {
            Cons<?, ?> theTuple = (Cons<?,?>)Cons.this;	
            public Term<?> next() {
                if (theTuple == null) {
                    throw new java.util.NoSuchElementException();
                }
                Term<?> head = theTuple.getHead();
                theTuple=(theTuple.getRest() instanceof Cons ? (Cons<?,?>)theTuple.getRest() : null);
                return head;
            }
            public boolean hasNext() {		
                return theTuple != null;
            }
            public void remove() {throw new UnsupportedOperationException();}
        };
    }
    
    private void initFromList(java.util.List<Term<?>> termList) {
        if (!termList.isEmpty()) {
            _theHead = (H)termList.remove(0);            
            _theRest = !termList.isEmpty() ? (R)new Cons<Term<?>, Compound<?>>(null,termList) : (R)new Nil();
            return;
        }
        throw new UnsupportedOperationException(); //cannot create a 0-sized compound
    }

    public Cons(String name, Term<?>[] termArr) {
        this(name,new Vector<Term<?>>(Arrays.asList(termArr)));
    }

    public H getHead() {
        return _theHead;
    }

    public R getRest() {
        return _theRest;
    }

    public String getName() {
        return _theName;
    }


    public <Z extends Term<?>, R2 extends Cons<Z,? extends Compound<?>>> Cons<H, R2> append(Z z) {
        Term<?>[] termArr = this.toJava();
        Term<?>[] newTermArr = new Term<?>[termArr.length+1];
        System.arraycopy(termArr,0,newTermArr,0,termArr.length);
        newTermArr[termArr.length] = z;            
        return new Cons<H,R2>(_theName,newTermArr);
    }

    public int arity() {return 1+_theRest.arity();}

    public String toString() {
        String res = "Compound:'"+getName()+"'(";
        for (Term<?> t : this) {        
            res += t+",";            
        }            
        if (res.lastIndexOf(',')!=-1) {
            res = res.substring(0,res.lastIndexOf(','));
        }
        return res+")";
    }    

    static <Z extends Cons<?,?>> Z unmarshal(alice.tuprolog.Struct s) {
        if (!matches(s))
            throw new UnsupportedOperationException();
        Vector<Term<?>> termList = new Vector<Term<?>>();
        for (int i=0;i<s.getArity();i++) {       
            termList.add(Term.unmarshal(s.getArg(i)));
        }
        //return (Z)new Cons(s.getName(),termList);
        return Cons.<Z>make(s.getName(),termList.toArray(new Term<?>[termList.size()]));
    }

    static boolean matches(alice.tuprolog.Term t) {
        return (!(t instanceof alice.tuprolog.Var) && t.isCompound() && !t.isList());
    }
    
    public <Z> Z toJava() {
    /*    if (isPrologObject())
            return (Z)toPrologObject();
        else {*/
            Vector<Term<?>> _javaList = new Vector<Term<?>>();            
            for (Term<?> t : this) {
                _javaList.add(t/*((Compound<?,?>)c).getHead()*/);                
            }
            Term<?>[] termArr = new Term<?>[_javaList.size()];
            _javaList.toArray(termArr);
            return (Z)termArr;
        //}
    }

    public alice.tuprolog.Struct marshal() {
        alice.tuprolog.Term[] termArray = new alice.tuprolog.Term[arity()];
        int i = 0;
        for (Term<?> t: this) {
            termArray[i++]=t.marshal();        
        }
        return new alice.tuprolog.Struct(_theName,termArray);
    }
    /*
    private Object toPrologObject() {            
        try {                
            if (!isPrologObject())
                throw new UnsupportedOperationException();
            Class<?> cl = Class.forName(getName());
            Object po = cl.newInstance();                
            java.beans.BeanInfo binfo = java.beans.Introspector.getBeanInfo(cl);            
            for (Term t : this) {
                Cons<Atom, Cons<Term<?>, Nil>> property = (Cons<Atom, Cons<Term<?>, Nil>>)t;
                assert(property.getName().equals("_property"));
                for (java.beans.PropertyDescriptor pdesc : binfo.getPropertyDescriptors()) {
                    if (pdesc.getName().equals(property.getHead())) {
                        pdesc.getWriteMethod().invoke(po, property.getRest().getHead().toJava());                    
                    }
                }
            }            
            return po;            
        }
        catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }        
    }
    
    private boolean isPrologObject() {
        Class<?> cl = null;
        try {
            cl = Class.forName(getName());
        }
        catch (ClassNotFoundException e) {
            
        }
        if (cl==null||!cl.isAnnotationPresent(Termifiable.class))
            return false;
        else
            return true;
    }*/
}




//