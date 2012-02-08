package alice.tuprologx.ide;

import alice.util.*;
import alice.tuprolog.*;
import alice.tuprolog.event.ExceptionEvent;
import alice.tuprolog.event.ExceptionListener;
import alice.tuprolog.event.OutputEvent;
import alice.tuprolog.event.OutputListener;
import alice.tuprolog.event.SpyEvent;
import alice.tuprolog.event.SpyListener;
import alice.tuprolog.event.WarningEvent;
import alice.tuprolog.event.WarningListener;

import java.io.*;

@SuppressWarnings("serial")
public class CUIConsole extends Automaton implements Serializable, OutputListener, SpyListener, WarningListener/*Castagna 06/2011*/, ExceptionListener/**/{

   BufferedReader  stdin;
    Prolog          engine;

    static final String incipit =
        "tuProlog " + Prolog.getVersion() + " - DEIS,  University of Bologna at Cesena \n"+
        new java.util.Date();
       
    public CUIConsole(String[] args){

        if (args.length>1){
            System.err.println("args: { theory file }");
            System.exit(-1);
        }
        
        engine = new Prolog();
        stdin = new BufferedReader(new InputStreamReader(System.in));
        engine.addWarningListener(this);
        engine.addOutputListener(this);
        engine.addSpyListener(this);
        /*Castagna 06/2011*/   
        engine.addExceptionListener(this);
        /**/
        if (args.length>0) {
            try {
                engine.setTheory(new Theory(new FileInputStream(args[0])));
            } catch (InvalidTheoryException ex){
                System.err.println("invalid theory - line: "+ex.line);
                System.exit(-1);
            } catch (Exception ex){
                System.err.println("invalid theory.");
                System.exit(-1);
            }
        }
    }

    public void boot(){
        System.out.println(incipit);
        become("goalRequest");
    }

    public void goalRequest(){
        String goal="";
        while (goal.equals("")){
            System.out.print("\n?- ");
            try {
                goal=stdin.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        solveGoal(goal);
    }

    void solveGoal(String goal){
        try {
            SolveInfo info = engine.solve(goal);
            /*Castagna 06/2011*/        	
        	//if (engine.isHalted())
        	//	System.exit(0);
            /**/
            if (!info.isSuccess()) {
            	/*Castagna 06/2011*/        		
        		if(info.isHalted())
        			System.out.println("halt.");
        		else
        		/**/ 
                System.out.println("no.");
                become("goalRequest");
            } else
                if (!engine.hasOpenAlternatives()) {
                    String binds = info.toString();
                    if (binds.equals("")) {
                        System.out.println("yes.");
                    } else {
                        System.out.println(solveInfoToString(info) + "\nyes.");
                    }
                    become("goalRequest");
                } else {
                    System.out.print(solveInfoToString(info) + " ? ");
                    become("getChoice");
                }
        } catch (MalformedGoalException ex){
            System.out.println("syntax error in goal:\n"+goal);
            become("goalRequest");
        }
    }
    
    private String solveInfoToString(SolveInfo result) {
        String s = "";
        try {
            for (Var v: result.getBindingVars()) {
                if ( !v.isAnonymous() && v.isBound() && (!(v.getTerm() instanceof Var) || (!((Var) (v.getTerm())).getName().startsWith("_")))) {
                    s += v.getName() + " / " + v.getTerm() + "\n";
                }
            }
            /*Castagna 06/2011*/
            if(s.length()>0){
            /**/
                s.substring(0,s.length()-1);    
            }
        } catch (NoSolutionException e) {}
        return s;
    }

    public void getChoice(){
        String choice="";
        try {
            while (true){
                choice = stdin.readLine();
                if (!choice.equals(";") && !choice.equals(""))
                    System.out.println("\nAction ( ';' for more choices, otherwise <return> ) ");
                else
                    break;
            }
        } catch (IOException ex){
        }
        if (!choice.equals(";")) {
            System.out.println("yes.");
            engine.solveEnd();
            become("goalRequest");
        } else {
            try {
                System.out.println();
                SolveInfo info = engine.solveNext();
                if (!info.isSuccess()){
                    System.out.println("no.");
                    become("goalRequest");
                } else {
                    System.out.print(solveInfoToString(info) + " ? ");
                    become("getChoice");
                }
            } catch (Exception ex){
                System.out.println("no.");
                become("goalRequest");
            }
        }
    }

    public void onOutput(OutputEvent e) {
        System.out.print(e.getMsg());
    }
    public void onSpy(SpyEvent e) {
        System.out.println(e.getMsg());
    }
    public void onWarning(WarningEvent e) {
        System.out.println(e.getMsg());
    }

    /*Castagna 06/2011*/  
	public void onException(ExceptionEvent e) {
    	 System.out.println(e.getMsg());
	}
	/**/
	
    public static void main(String[] args){
        new Thread(new CUIConsole(args)).start();
    }
}
