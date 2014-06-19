/*
 * Tokenizer.java
 *
 * Created on April 26, 2007, 3:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package alice.tuprologx.pj.annotations.parser;

import java.util.Stack;

/**
 *
 * @author maurizio
 */
public class Tokenizer {
    private Stack<Character> charBuffer;    
    private String value;    
    private Token lastToken;    
    
    Tokenizer(String s) {
        value = null;
        charBuffer = new Stack<Character>();
        char[] charArr = s.toCharArray();
        for (int i = charArr.length-1;i>=0;i--) {
            charBuffer.push(charArr[i]);
        }        
    }    
    
    public Token lastToken() {
        return lastToken;
    }
    
    public String lastValue() {
        return value;
    }
    
    boolean hasMoreTokens() {
        return !charBuffer.empty();
    }
    
    void next() {
        try {
            lastToken = TK_UNKNOWN;
            skipSpaces();
            for (Token t : tokens) {
                if (t.accept(this)) {
                    lastToken = t;                    
                    return;
                }                
            }                        
        }
        catch (Exception e) {
            throw new UnexpectedEndOfExpressionException(e);
        }
    }
    
    boolean accept(Token t) {
        return t.accept(this);
    }
            
    private void skipSpaces() {
        while(charBuffer.peek()==' ') {
            charBuffer.pop();
        }
    }
    
    public char getChar(int pos) {
        return charBuffer.get(charBuffer.size()-1-pos);
    }
    
    public char consumeChar() {
        return charBuffer.pop();
    }
    
    abstract static class Token {        

        public abstract boolean accept(Tokenizer t);

    }

    public static final Token TK_COMMA = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == ',') {
                t.charBuffer.pop();
                t.value = ",";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_PAR_OPEN = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '(') {
                t.charBuffer.pop();
                t.value = "(";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_PAR_CLOSE = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == ')') {
                t.charBuffer.pop();
                t.value = ")";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_BRA_OPEN = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '{') {
                t.charBuffer.pop();
                t.value = "{";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_BRA_CLOSE = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '}') {
                t.charBuffer.pop();
                t.value = "}";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_RET = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '-' && t.charBuffer.get(t.charBuffer.size() - 2) == '>') {
                t.charBuffer.pop();
                t.charBuffer.pop();
                t.value = "->";                
                return true;
            }
            return false;
        }
    };    

    public static final Token TK_MINUS = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '-' && t.charBuffer.get(t.charBuffer.size() - 2) != '>') {                
                t.charBuffer.pop();
                t.value = "-";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_PLUS = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '+') {
                t.charBuffer.pop();
                t.value = "+";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_AT = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '@') {
                t.charBuffer.pop();
                t.value = "@";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_INOUT = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '?') {
                t.charBuffer.pop();
                t.value = "?";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_GROUND = new Token() { 
        public boolean accept(Tokenizer t) {
            if (t.charBuffer.peek() == '!') {
                t.charBuffer.pop();
                t.value = "!";                
                return true;
            }
            return false;
        }
    };

    public static final Token TK_IDENT = new Token() {
        public boolean accept(Tokenizer t) {
            String buf = "";
            if (Character.isLetter(t.charBuffer.peek())) {                
                while (Character.isLetter(t.charBuffer.peek()) || Character.isDigit(t.charBuffer.peek())) {
                    buf+=t.charBuffer.pop();
                }                
                t.value = buf;                
            }
            return buf.length()!=0;
        }
    };

    public static final Token TK_UNKNOWN = new Token() { 
        public boolean accept(Tokenizer t) {
            return true;
        }
    };

    public static final java.util.List<Token> tokens = java.util.Arrays.asList(new Token[] {
        TK_AT,
        TK_BRA_CLOSE,
        TK_BRA_OPEN,
        TK_COMMA,
        TK_GROUND,
        TK_IDENT,
        TK_INOUT,
        TK_MINUS,
        TK_PAR_CLOSE,
        TK_PAR_OPEN,
        TK_PLUS,
        TK_RET        
    }); 
}