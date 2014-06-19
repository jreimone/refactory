package alice.tuprologx.pj.engine;

import alice.tuprologx.pj.annotations.*;
import alice.tuprologx.pj.annotations.parser.*;
import alice.tuprologx.pj.annotations.parser.PrologTree.*;
import alice.tuprologx.pj.model.*;

import java.lang.reflect.*;
import java.util.*;


/**
 *
 * @author maurizio
 */
public class PrologInvocationContext {    
    
    private String predicateName;
    private Vector<String> variableNames;
    private Vector<String> inputVariables;
    private Vector<String> outputVariables;
    private boolean multipleResult;        
    private boolean exceptionOnFailure;
    private boolean keepSubstitutions;
    private boolean trace;
    
    /** Creates a new instance of InvocationObject */
    public PrologInvocationContext(Method m, Object[] args) {        
        PrologMethod pann = (PrologMethod)m.getAnnotation(PrologMethod.class);
        assert (pann != null);         
        keepSubstitutions = pann.keepSubstitutions();// || pann.signature().equals("");
        initPredicateName(m,pann);
        initVariableNames(m,pann);
        initInputVariables(m,pann);
        initOutputVariables(m,pann);                
        exceptionOnFailure = pann.exceptionOnFailure();                                                
        trace = m.isAnnotationPresent(TRACE.class);            
    }
    
    public Term<?> buildGoal(Object[] args) throws Exception {        
        Term<?>[] tlist = new Term<?>[variableNames.size()];
        int i = 0;
        int pos;
        for (String name : variableNames) {
            if ((pos = inputVariables.indexOf(name)) != -1) {
                tlist[i] = (Term<?>)args[pos];
            }
            i++;
        }
        for (i=0;i<tlist.length;i++) {
            if (tlist[i] == null) {
                tlist[i] = new Var<Term<?>>("PJVAR"+i);
            }
        }
        return Cons.make(predicateName,tlist);        
    }
    
    private void initPredicateName(Method m, PrologMethod pm) {
        if (pm.predicate().equals("")) {
            predicateName = m.getName();
        }
        else {
            Parser p = new Parser(pm.predicate());        
            predicateName = p.parsePredicate().name;
        }
    }
    
    private void initVariableNames(Method m, PrologMethod pm) {
        variableNames = new Vector<String>();
        if (pm.predicate().equals("")) {
            for (TypeVariable<?> tv : m.getTypeParameters()) {                
                if (tv.getName().startsWith("$")) {
                    variableNames.add(tv.getName());
                }
            }
        }
        else {
            Parser p = new Parser(pm.predicate());        
            java.util.List<VariableExpr> variables = p.parsePredicate().variables;            
            for (VariableExpr v : variables) {
                variableNames.add(v.name);
            }
        }
    }
    
    private void initInputVariables(Method m, PrologMethod pm) {
        inputVariables = new Vector<String>();
        if (pm.signature().equals("")) {
            for (Type t : m.getGenericParameterTypes()) {
                if (t instanceof TypeVariable<?>) {                    
                    inputVariables.add(((TypeVariable<?>)t).getName());                    
                }
            }
        }
        else {
            Parser p = new Parser(pm.signature());        
            java.util.List<VariableExpr> variables = p.parseSignature().inputTree.variables;            
            for (VariableExpr v : variables) {
                inputVariables.add(v.name);
            }
        }
    }
    
    private void initOutputVariables(Method m, PrologMethod pm) {
        outputVariables = new Vector<String>();        
        if (pm.signature().equals("")) {
            Type returnType = m.getGenericReturnType();
            if (Iterable.class.equals(m.getReturnType())) {
                multipleResult = true;
                returnType = ((ParameterizedType)returnType).getActualTypeArguments()[0];
            }
            else {
                multipleResult = false;
            }
            if (returnType instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType)returnType;
                if (Cons.class.equals((Class<?>)pt.getRawType())) {//Cons<Cons<Cons ...
                    Type t = pt;
                    while (Nil.class.isAssignableFrom((Class<?>)pt.getRawType())) {
                        pt = (ParameterizedType)t;
                        Type head = pt.getActualTypeArguments()[0];
                        outputVariables.add(((TypeVariable<?>)head).getName());
                        t = pt.getActualTypeArguments()[1];
                    }
                }
                else {//Compound1, Compound2
                    for (Type t : pt.getActualTypeArguments()) {
                        outputVariables.add(((TypeVariable<?>)t).getName());
                    }
                }
            }  
            else if(returnType.equals(Boolean.class)) {
                return;
            }
            else {
                outputVariables.add(((TypeVariable<?>)returnType).getName());
            }
            for (String s : outputVariables) {
                if (inputVariables.contains(s)) {
                    keepSubstitutions = true;
                }
            }
        }
        else {
            Parser p = new Parser(pm.signature());        
            SignatureExpr signature = p.parseSignature();
            java.util.List<VariableExpr> variables = signature.outputTree.variables;            
            for (VariableExpr v : variables) {
                outputVariables.add(v.name);
            }        
            multipleResult = signature.multipleResult;
        }
    }
    
    
    
    
    public Object dispatch(alice.tuprologx.pj.engine.PJProlog _engine, Object[] args) throws NoSolutionException {
	try {                            
            Term<?> theGoal = buildGoal(args);  
            if (trace) {
                System.out.println("theory = "+_engine.getTheory());
                System.out.println("goal = "+theGoal.marshal());
            }
            return buildSolution(theGoal ,_engine);
        }
	catch (Exception e) {e.printStackTrace();return null;}
    }
    
    /*
     * unused
     *
    private Object buildSolution2(Term<?> theGoal, PJProlog _engine) throws NoSolutionException {
        try {                    
            if (multipleResult) {
                Iterable<? extends PrologSolution<?,Cons<?,?>>> answer = _engine.solveAll(theGoal);                            
                Vector<Object> resultList = new Vector<Object>();
                if (!answer.iterator().hasNext() && exceptionOnFailure) {
                    throw new NoSolutionException();
                }
                else if (!answer.iterator().hasNext() && !exceptionOnFailure) {
                    return (outputVariables.size()==0) ? Boolean.FALSE : null;
                }
                
                for (PrologSolution<?, Cons<?, ?>> si : answer) {                        
                    Cons<?,?> res = si.getSolution();
                    int size = outputVariables.size();                    
                    if (size == 0) {
                        resultList.add(si.isSuccess() ? Boolean.TRUE : Boolean.FALSE);   
                    }
                    else {
                        Term<?>[] termList = new Term<?>[size];
                        int i = 0;
                        int pos;
                        for (Term<?> t : res) {
                            if ((pos = outputVariables.indexOf(variableNames.get(i)))!=-1) {
                                termList[pos] = formatTerm(t);
                            }
                            i++;
                        }
                        if (termList.length > 1) {
                            resultList.add(Cons.make(res.getName(),termList));                              
                        }
                        else {
                            resultList.add(termList[0]);                              
                        }
                    }                    
                }                                
                return resultList;
            }        
            else { //single solution
                PrologSolution<?,? extends Cons<?,?>> si = _engine.solve(theGoal);                            
                if (!si.isSuccess() && exceptionOnFailure) {
                    throw new NoSolutionException();
                }
                else if (!si.isSuccess() && !exceptionOnFailure) {
                    return (outputVariables.size()==0) ? Boolean.FALSE : null;
                }
                Object result = null;
                if (!si.isSuccess() && exceptionOnFailure) {
                    throw new NoSolutionException();
                }                                
                Cons<?,?> res = si.getSolution();
                int size = outputVariables.size();                
                if (size == 0) {
                    result = si.isSuccess() ? Boolean.TRUE : Boolean.FALSE;
                }
                else {
                    Term<?>[] termList = new Term<?>[size];
                    int i = 0;
                    int pos = 0;
                    for (Term<?> t : res) {
                        if ((pos = outputVariables.indexOf(variableNames.get(i)))!=-1) {
                            termList[pos] = formatTerm(t);
                        }
                        i++;
                    }
                    if (termList.length > 1) {
                            result = Cons.make(res.getName(),termList);                              
                        }
                        else {
                            result = termList[0];                              
                        }
                }                                    
                return result;
            }
        }
        catch (alice.tuprolog.PrologException ex) {
            return null;
        }
    }
    */
    
    private Object buildSolution(Term<?> theGoal, PJProlog _engine) throws NoSolutionException {
        try {                    
            if (multipleResult) {
                final Iterable<? extends PrologSolution<?,Cons<?,?>>> answer = _engine.solveAll(theGoal);                            
                //Vector<Object> resultList = new Vector<Object>();
                final Iterator<? extends PrologSolution<?,Cons<?,?>>> _result = answer.iterator();
                if (!_result.hasNext() && exceptionOnFailure) {
                    throw new NoSolutionException();
                }
                else if (!_result.hasNext() && !exceptionOnFailure) {
                    return (outputVariables.size()==0) ? Boolean.FALSE : null;
                }
                class SolutionIterator implements Iterator<Object> {
                    
                    public void remove() {throw new UnsupportedOperationException();}
                    public Object next() {
                        PrologSolution<?,Cons<?,?>> si = _result.next(); 
                        Cons<?,?> res = null;
                        try {
                             res = si.getSolution();
                        }
                        catch (Exception e) {
                            throw new UnsupportedOperationException(e);
                        }
                        int size = outputVariables.size();                    
                        if (size == 0) {
                            return si.isSuccess() ? Boolean.TRUE : Boolean.FALSE;   
                        }
                        else {
                            Term<?>[] termList = new Term<?>[size];
                            int i = 0;
                            int pos;
                            for (Term<?> t : res) {
                                if ((pos = outputVariables.indexOf(variableNames.get(i)))!=-1) {
                                    termList[pos] = formatTerm(t);
                                }
                                i++;
                            }
                            if (termList.length > 1) {
                                return Cons.make(res.getName(),termList);                              
                            }
                            else {
                                return termList[0];                              
                            }
                        }
                    }
                    public boolean hasNext() {
                        return _result.hasNext();
                    }
                }
                return new Iterable<Object>() {
                    public Iterator<Object> iterator() {return new SolutionIterator();}
                };                
            }        
            else { //single solution
                PrologSolution<?,? extends Cons<?,?>> si = _engine.solve(theGoal);                            
                if (!si.isSuccess() && exceptionOnFailure) {
                    throw new NoSolutionException();
                }
                else if (!si.isSuccess() && !exceptionOnFailure) {
                    return (outputVariables.size()==0) ? Boolean.FALSE : null;
                }
                Object result = null;
                if (!si.isSuccess() && exceptionOnFailure) {
                    throw new NoSolutionException();
                }                                
                Cons<?,?> res = si.getSolution();
                int size = outputVariables.size();                
                if (size == 0) {
                    result = si.isSuccess() ? Boolean.TRUE : Boolean.FALSE;
                }
                else {
                    Term<?>[] termList = new Term<?>[size];
                    int i = 0;
                    int pos = 0;
                    for (Term<?> t : res) {
                        if ((pos = outputVariables.indexOf(variableNames.get(i)))!=-1) {
                            termList[pos] = formatTerm(t);
                        }
                        i++;
                    }
                    if (termList.length > 1) {
                            result = Cons.make(res.getName(),termList);                              
                        }
                        else {
                            result = termList[0];                              
                        }
                }                                    
                return result;
            }
        }
        catch (alice.tuprolog.PrologException ex) {
            return null;
        }
    }
    
    private Term<?> formatTerm(Term<?> t) {
        if (t instanceof Var<?> && !keepSubstitutions)
            return ((Var<?>)t).getValue();
        else
            return t;
    }
}
