package alice.tuprologx.pj.engine;

import alice.tuprologx.pj.model.*;
/**
 *
 * @author maurizio
 */
public class PrologArg<X extends Term<X>> {
    
    private Term<X> _theArg;
    private TermKind[] _annotations;    
    
    /** Creates a new instance of PrologArg */
    public PrologArg(Term<X> arg, TermKind[] annotations) {        
        this(annotations);
        _theArg = arg;      
    }
    
    public PrologArg(TermKind[] annotations) {     
        _annotations = annotations;
    }
    
    public boolean isInputArgument() {
        for (TermKind tk : _annotations) {
            switch (tk) {
                case INPUT : return true;
            }
        }
        return false;
    }

    public boolean isOutputArgument() {
        for (TermKind tk : _annotations) {
            switch (tk) {
                case OUTPUT : return true;
            }
        }
        return false;
    }

    public boolean isIsGround() {        
        for (TermKind tk : _annotations) {
            switch (tk) {
                case GROUND : return true;
            }
        }
        return false;
    }
    
    public boolean isIsHidden() {        
        for (TermKind tk : _annotations) {
            switch (tk) {
                case HIDE : return true;
            }
        }
        return false;
    }
    
    public Term<X> getTerm() {
        return _theArg;
    }
    
    protected void setTerm(Term<X> o) {
        _theArg = o;
    }
}
