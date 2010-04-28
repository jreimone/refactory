// $ANTLR ${project.version} ${buildNumber}

	package org.emftext.refactoring.tests.properties.resource.properties.mopp;


import org.antlr.runtime3_2_0.*;

public class PropertiesLexer extends Lexer {
    public static final int INTEGER=9;
    public static final int QUOTED_91_93=4;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int TEXT=5;
    public static final int FLOAT=10;
    public static final int LINEBREAK=12;
    public static final int COMMENT=8;
    public static final int QUOTED_60_62=6;
    public static final int QUOTED_34_34=7;
    public static final int WHITESPACE=11;

    	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
    	public java.util.List<java.lang.Integer> lexerExceptionsPosition = new java.util.ArrayList<java.lang.Integer>();
    	
    	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators

    public PropertiesLexer() {;} 
    public PropertiesLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PropertiesLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Properties.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:16:7: ( '=' )
            // Properties.g:16:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:974:8: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Properties.g:975:2: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 

            // Properties.g:975:6: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Properties.g:975:7: ~ ( '\\n' | '\\r' | '\\uffff' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:978:8: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-'||(LA4_0>='1' && LA4_0<='9')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='0') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // Properties.g:979:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Properties.g:979:2: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // Properties.g:979:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // Properties.g:979:8: ( '1' .. '9' )
                    // Properties.g:979:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // Properties.g:979:18: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Properties.g:979:19: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Properties.g:979:30: '0'
                    {
                    match('0'); 
                     _channel = 99; 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:981:6: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // Properties.g:982:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // Properties.g:982:2: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Properties.g:982:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // Properties.g:982:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='1' && LA7_0<='9')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='0') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // Properties.g:982:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Properties.g:982:9: ( '1' .. '9' )
                    // Properties.g:982:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // Properties.g:982:20: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Properties.g:982:21: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Properties.g:982:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // Properties.g:982:43: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Properties.g:982:44: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:984:5: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Properties.g:985:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Properties.g:985:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='-'||(LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Properties.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:986:11: ( ( ' ' | '\\t' | '\\f' ) )
            // Properties.g:987:2: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:990:10: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Properties.g:991:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Properties.g:991:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1=='\n') ) {
                    alt10=1;
                }
                else {
                    alt10=2;}
            }
            else if ( (LA10_0=='\n') ) {
                alt10=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // Properties.g:991:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // Properties.g:991:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Properties.g:991:19: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_91_93"
    public final void mQUOTED_91_93() throws RecognitionException {
        try {
            int _type = QUOTED_91_93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:994:13: ( ( '[' ) (~ ( ']' ) )* ( ']' ) )
            // Properties.g:995:2: ( '[' ) (~ ( ']' ) )* ( ']' )
            {
            // Properties.g:995:2: ( '[' )
            // Properties.g:995:3: '['
            {
            match('['); 

            }

            // Properties.g:995:7: (~ ( ']' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\\')||(LA11_0>='^' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Properties.g:995:8: ~ ( ']' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\\')||(input.LA(1)>='^' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // Properties.g:995:16: ( ']' )
            // Properties.g:995:17: ']'
            {
            match(']'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_91_93"

    // $ANTLR start "QUOTED_60_62"
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:997:13: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Properties.g:998:2: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Properties.g:998:2: ( '<' )
            // Properties.g:998:3: '<'
            {
            match('<'); 

            }

            // Properties.g:998:7: (~ ( '>' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='=')||(LA12_0>='?' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Properties.g:998:8: ~ ( '>' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // Properties.g:998:16: ( '>' )
            // Properties.g:998:17: '>'
            {
            match('>'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_60_62"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Properties.g:1000:13: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Properties.g:1001:2: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Properties.g:1001:2: ( '\"' )
            // Properties.g:1001:3: '\"'
            {
            match('\"'); 

            }

            // Properties.g:1001:7: (~ ( '\"' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Properties.g:1001:8: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // Properties.g:1001:16: ( '\"' )
            // Properties.g:1001:17: '\"'
            {
            match('\"'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // Properties.g:1:8: ( T__13 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK | QUOTED_91_93 | QUOTED_60_62 | QUOTED_34_34 )
        int alt14=10;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // Properties.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // Properties.g:1:16: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 3 :
                // Properties.g:1:24: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 4 :
                // Properties.g:1:32: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 5 :
                // Properties.g:1:38: TEXT
                {
                mTEXT(); 

                }
                break;
            case 6 :
                // Properties.g:1:43: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 7 :
                // Properties.g:1:54: LINEBREAK
                {
                mLINEBREAK(); 

                }
                break;
            case 8 :
                // Properties.g:1:64: QUOTED_91_93
                {
                mQUOTED_91_93(); 

                }
                break;
            case 9 :
                // Properties.g:1:77: QUOTED_60_62
                {
                mQUOTED_60_62(); 

                }
                break;
            case 10 :
                // Properties.g:1:90: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\3\uffff\1\6\2\15\6\uffff\1\6\1\uffff\1\15\1\uffff";
    static final String DFA14_eofS =
        "\20\uffff";
    static final String DFA14_minS =
        "\1\11\2\uffff\1\60\2\55\6\uffff\1\56\1\uffff\1\55\1\uffff";
    static final String DFA14_maxS =
        "\1\172\2\uffff\1\71\2\172\6\uffff\1\56\1\uffff\1\172\1\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\uffff\1\3"+
        "\1\uffff\1\4";
    static final String DFA14_specialS =
        "\20\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\7\1\10\1\uffff\1\7\1\10\22\uffff\1\7\1\uffff\1\13\12\uffff"+
            "\1\3\1\uffff\1\2\1\5\11\4\2\uffff\1\12\1\1\3\uffff\32\6\1\11"+
            "\3\uffff\1\6\1\uffff\32\6",
            "",
            "",
            "\1\14\11\4",
            "\1\6\1\17\1\uffff\12\16\7\uffff\32\6\4\uffff\1\6\1\uffff\32"+
            "\6",
            "\1\6\1\17\1\uffff\12\6\7\uffff\32\6\4\uffff\1\6\1\uffff\32"+
            "\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17",
            "",
            "\1\6\1\17\1\uffff\12\16\7\uffff\32\6\4\uffff\1\6\1\uffff\32"+
            "\6",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK | QUOTED_91_93 | QUOTED_60_62 | QUOTED_34_34 );";
        }
    }
 

}