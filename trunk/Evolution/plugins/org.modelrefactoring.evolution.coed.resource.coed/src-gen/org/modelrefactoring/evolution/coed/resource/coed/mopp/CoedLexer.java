// $ANTLR 3.4

	package org.modelrefactoring.evolution.coed.resource.coed.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CoedLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int FLOAT=4;
    public static final int IDENTIFIER=5;
    public static final int LINEBREAK=6;
    public static final int QUOTED_123_125=7;
    public static final int QUOTED_60_62=8;
    public static final int SL_COMMENT=9;
    public static final int WHITESPACE=10;

    	public List<RecognitionException> lexerExceptions  = new ArrayList<RecognitionException>();
    	public List<Integer> lexerExceptionPositions = new ArrayList<Integer>();
    	
    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionPositions.add(((ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CoedLexer() {} 
    public CoedLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CoedLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Coed.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:20:7: ( ':' )
            // Coed.g:20:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:21:7: ( 'CoED' )
            // Coed.g:21:9: 'CoED'
            {
            match("CoED"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:22:7: ( 'condition' )
            // Coed.g:22:9: 'condition'
            {
            match("condition"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:23:7: ( 'corefactoring' )
            // Coed.g:23:9: 'corefactoring'
            {
            match("corefactoring"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:24:7: ( 'for' )
            // Coed.g:24:9: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:25:7: ( 'import' )
            // Coed.g:25:9: 'import'
            {
            match("import"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:26:7: ( 'incoming' )
            // Coed.g:26:9: 'incoming'
            {
            match("incoming"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:27:7: ( 'outgoing' )
            // Coed.g:27:9: 'outgoing'
            {
            match("outgoing"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:28:7: ( 'refactoring' )
            // Coed.g:28:9: 'refactoring'
            {
            match("refactoring"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:29:7: ( '{' )
            // Coed.g:29:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:30:7: ( '}' )
            // Coed.g:30:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:1163:11: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '-' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' )* ) )
            // Coed.g:1164:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '-' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' )* )
            {
            // Coed.g:1164:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '-' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' )* )
            // Coed.g:1164:3: ( 'A' .. 'Z' | 'a' .. 'z' | '-' | '_' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' )*
            {
            if ( input.LA(1)=='-'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // Coed.g:1164:35: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '-' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Coed.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:1166:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Coed.g:1167:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:1170:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Coed.g:1171:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Coed.g:1171:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Coed.g:1171:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Coed.g:1171:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=2;
                }
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Coed.g:1171:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Coed.g:1171:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Coed.g:1171:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:1174:6: ( ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ ) )
            // Coed.g:1175:2: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            {
            // Coed.g:1175:2: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // Coed.g:1175:3: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // Coed.g:1175:3: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Coed.g:1175:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Coed.g:1175:9: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0 >= '1' && LA5_0 <= '9')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='0') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // Coed.g:1175:10: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Coed.g:1175:21: ( '0' .. '9' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Coed.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Coed.g:1175:35: '0'
                    {
                    match('0'); 

                    }
                    break;

            }


            match('.'); 

            // Coed.g:1175:44: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Coed.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:1178:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Coed.g:1179:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Coed.g:1179:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Coed.g:1179:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Coed.g:1179:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Coed.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "QUOTED_60_62"
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:1182:13: ( ( ( '<' ) (~ ( '>' ) )* ( '>' ) ) )
            // Coed.g:1183:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            {
            // Coed.g:1183:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Coed.g:1183:3: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Coed.g:1183:3: ( '<' )
            // Coed.g:1183:4: '<'
            {
            match('<'); 

            }


            // Coed.g:1183:8: (~ ( '>' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\u0000' && LA8_0 <= '=')||(LA8_0 >= '?' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Coed.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '=')||(input.LA(1) >= '?' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // Coed.g:1183:17: ( '>' )
            // Coed.g:1183:18: '>'
            {
            match('>'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_60_62"

    // $ANTLR start "QUOTED_123_125"
    public final void mQUOTED_123_125() throws RecognitionException {
        try {
            int _type = QUOTED_123_125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Coed.g:1185:15: ( ( ( '{' ) (~ ( '}' ) )* ( '}' ) ) )
            // Coed.g:1186:2: ( ( '{' ) (~ ( '}' ) )* ( '}' ) )
            {
            // Coed.g:1186:2: ( ( '{' ) (~ ( '}' ) )* ( '}' ) )
            // Coed.g:1186:3: ( '{' ) (~ ( '}' ) )* ( '}' )
            {
            // Coed.g:1186:3: ( '{' )
            // Coed.g:1186:4: '{'
            {
            match('{'); 

            }


            // Coed.g:1186:8: (~ ( '}' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '\u0000' && LA9_0 <= '|')||(LA9_0 >= '~' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Coed.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '|')||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // Coed.g:1186:17: ( '}' )
            // Coed.g:1186:18: '}'
            {
            match('}'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_123_125"

    public void mTokens() throws RecognitionException {
        // Coed.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | IDENTIFIER | WHITESPACE | LINEBREAK | FLOAT | SL_COMMENT | QUOTED_60_62 | QUOTED_123_125 )
        int alt10=18;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // Coed.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // Coed.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // Coed.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // Coed.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // Coed.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // Coed.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // Coed.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // Coed.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // Coed.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // Coed.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // Coed.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // Coed.g:1:76: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 13 :
                // Coed.g:1:87: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 14 :
                // Coed.g:1:98: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 15 :
                // Coed.g:1:108: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 16 :
                // Coed.g:1:114: SL_COMMENT
                {
                mSL_COMMENT(); 


                }
                break;
            case 17 :
                // Coed.g:1:125: QUOTED_60_62
                {
                mQUOTED_60_62(); 


                }
                break;
            case 18 :
                // Coed.g:1:138: QUOTED_123_125
                {
                mQUOTED_123_125(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\2\uffff\6\15\1\30\1\uffff\1\15\6\uffff\7\15\2\uffff\5\15\1\50\5"+
        "\15\1\55\2\15\1\uffff\4\15\1\uffff\10\15\1\74\5\15\1\uffff\5\15"+
        "\1\107\1\110\1\15\1\112\1\15\2\uffff\1\15\1\uffff\3\15\1\120\1\15"+
        "\1\uffff\1\122\1\uffff";
    static final String DFA10_eofS =
        "\123\uffff";
    static final String DFA10_minS =
        "\1\11\1\uffff\3\157\1\155\1\165\1\145\1\0\1\uffff\1\60\6\uffff\1"+
        "\105\1\156\1\162\1\160\1\143\1\164\1\146\2\uffff\2\56\1\104\1\144"+
        "\1\145\1\55\2\157\1\147\1\141\1\56\1\55\1\151\1\146\1\uffff\1\162"+
        "\1\155\1\157\1\143\1\uffff\1\164\1\141\1\164\2\151\1\164\1\151\1"+
        "\143\1\55\2\156\2\157\1\164\1\uffff\2\147\1\162\1\156\1\157\2\55"+
        "\1\151\1\55\1\162\2\uffff\1\156\1\uffff\1\151\1\147\1\156\1\55\1"+
        "\147\1\uffff\1\55\1\uffff";
    static final String DFA10_maxS =
        "\1\175\1\uffff\3\157\1\156\1\165\1\145\1\uffff\1\uffff\1\71\6\uffff"+
        "\1\105\2\162\1\160\1\143\1\164\1\146\2\uffff\1\71\1\56\1\104\1\144"+
        "\1\145\1\172\2\157\1\147\1\141\1\71\1\172\1\151\1\146\1\uffff\1"+
        "\162\1\155\1\157\1\143\1\uffff\1\164\1\141\1\164\2\151\1\164\1\151"+
        "\1\143\1\172\2\156\2\157\1\164\1\uffff\2\147\1\162\1\156\1\157\2"+
        "\172\1\151\1\172\1\162\2\uffff\1\156\1\uffff\1\151\1\147\1\156\1"+
        "\172\1\147\1\uffff\1\172\1\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\7\uffff\1\13\1\uffff\1\15\1\16\1\14\1\17\1\20\1\21"+
        "\7\uffff\1\12\1\22\16\uffff\1\5\4\uffff\1\2\16\uffff\1\6\12\uffff"+
        "\1\7\1\10\1\uffff\1\3\5\uffff\1\11\1\uffff\1\4";
    static final String DFA10_specialS =
        "\10\uffff\1\0\112\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\13\1\14\1\uffff\1\13\1\14\22\uffff\1\13\14\uffff\1\12\1\uffff"+
            "\1\17\12\16\1\1\1\uffff\1\20\4\uffff\2\15\1\2\27\15\4\uffff"+
            "\1\15\1\uffff\2\15\1\3\2\15\1\4\2\15\1\5\5\15\1\6\2\15\1\7\10"+
            "\15\1\10\1\uffff\1\11",
            "",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24\1\25",
            "\1\26",
            "\1\27",
            "\0\31",
            "",
            "\1\33\11\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34",
            "\1\35\3\uffff\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "",
            "",
            "\1\16\1\uffff\12\44",
            "\1\16",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\16\1\uffff\12\44",
            "\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\56",
            "\1\57",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\111",
            "\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\113",
            "",
            "",
            "\1\114",
            "",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\121",
            "",
            "\1\15\2\uffff\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | IDENTIFIER | WHITESPACE | LINEBREAK | FLOAT | SL_COMMENT | QUOTED_60_62 | QUOTED_123_125 );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_8 = input.LA(1);

                        s = -1;
                        if ( ((LA10_8 >= '\u0000' && LA10_8 <= '\uFFFF')) ) {s = 25;}

                        else s = 24;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}