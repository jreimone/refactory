/*
 * Bool.java
 *
 * Created on March 8, 2007, 5:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package alice.tuprologx.pj.model;

/**
 *
 * @author maurizio
 */
public class Bool extends Term<Bool> {
	Boolean _theBool;        
        
	public Boolean toJava() { return _theBool; }
	
	public Bool (Boolean b) {_theBool = b;}
        
        public alice.tuprolog.Term marshal() {
            return _theBool.booleanValue() ? alice.tuprolog.Struct.TRUE : alice.tuprolog.Struct.FALSE;
        }
        
        static Bool unmarshal(alice.tuprolog.Struct b) {
            if (!matches(b))
                throw new UnsupportedOperationException();
            if (b.isEqual(alice.tuprolog.Struct.TRUE))
                return new Bool(Boolean.TRUE);
            else 
                return new Bool(Boolean.FALSE);
        }
        
        static boolean matches(alice.tuprolog.Term t) {            
            return (!(t instanceof alice.tuprolog.Var) && (t.isEqual(alice.tuprolog.Struct.TRUE) || t.isEqual(alice.tuprolog.Struct.FALSE)));
        }
        
	public String toString() {
		return "Bool("+_theBool+")";
	}

}