// Generated from C:/Code/IdeaProjects/ComplierForMIDL/src/G4/MIDLGrammar.g4 by ANTLR 4.13.1
package G4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MIDLGrammar extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MODULE=1, STRUCT=2, BOOLEAN=3, SHORT=4, LONG=5, UNSIGNED=6, INT8=7, INT16=8, 
		INT32=9, INT64=10, UINT8=11, UINT16=12, UINT32=13, UINT64=14, CHAR=15, 
		STRING=16, FLOAT=17, DOUBLE=18, LBRACE_OPEN=19, LBRACE_CLOSE=20, BRACKET_OPEN=21, 
		BRACKET_CLOSE=22, SEMICOLON=23, COMMA=24, PLUS=25, MINUS=26, DIVISION=27, 
		MULTIPLICATION=28, ROUNDING=29, EQUAL=30, OSTREAM=31, ISTREAM=32, XOR=33, 
		AND=34, OR=35, NOR=36, COLON=37, DOUBLE_COLON=38, BOOLEANRegular=39, TRUE=40, 
		FALSE=41, ID=42, INTEGER=43, FLOATING_PT=44, CHARRegular=45, STRINGRegular=46, 
		WS=47;
	public static final int
		RULE_specification = 0, RULE_definition = 1, RULE_module = 2, RULE_type_decl = 3, 
		RULE_struct_type = 4, RULE_member_list = 5, RULE_type_spec = 6, RULE_scoped_name = 7, 
		RULE_base_type_spec = 8, RULE_floating_pt_type = 9, RULE_integer_type = 10, 
		RULE_signed_int = 11, RULE_unsigned_int = 12, RULE_declarators = 13, RULE_declarator = 14, 
		RULE_simple_declarator = 15, RULE_array_declarator = 16, RULE_exp_list = 17, 
		RULE_or_expr = 18, RULE_xor_expr = 19, RULE_and_expr = 20, RULE_shift_expr = 21, 
		RULE_add_expr = 22, RULE_mult_expr = 23, RULE_unary_expr = 24, RULE_literal = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"specification", "definition", "module", "type_decl", "struct_type", 
			"member_list", "type_spec", "scoped_name", "base_type_spec", "floating_pt_type", 
			"integer_type", "signed_int", "unsigned_int", "declarators", "declarator", 
			"simple_declarator", "array_declarator", "exp_list", "or_expr", "xor_expr", 
			"and_expr", "shift_expr", "add_expr", "mult_expr", "unary_expr", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "'{'", "'}'", "'['", "']'", 
			"';'", "','", "'+'", "'-'", "'/'", "'*'", "'%'", "'='", "'<<'", "'>>'", 
			"'^'", "'&'", "'|'", "'~'", "':'", "'::'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MODULE", "STRUCT", "BOOLEAN", "SHORT", "LONG", "UNSIGNED", "INT8", 
			"INT16", "INT32", "INT64", "UINT8", "UINT16", "UINT32", "UINT64", "CHAR", 
			"STRING", "FLOAT", "DOUBLE", "LBRACE_OPEN", "LBRACE_CLOSE", "BRACKET_OPEN", 
			"BRACKET_CLOSE", "SEMICOLON", "COMMA", "PLUS", "MINUS", "DIVISION", "MULTIPLICATION", 
			"ROUNDING", "EQUAL", "OSTREAM", "ISTREAM", "XOR", "AND", "OR", "NOR", 
			"COLON", "DOUBLE_COLON", "BOOLEANRegular", "TRUE", "FALSE", "ID", "INTEGER", 
			"FLOATING_PT", "CHARRegular", "STRINGRegular", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MIDLGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MIDLGrammar(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecificationContext extends ParserRuleContext {
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificationContext specification() throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				definition();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MODULE || _la==STRUCT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public Type_declContext type_decl() {
			return getRuleContext(Type_declContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MIDLGrammar.SEMICOLON, 0); }
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				type_decl();
				setState(58);
				match(SEMICOLON);
				}
				break;
			case MODULE:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				module();
				setState(61);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(MIDLGrammar.MODULE, 0); }
		public TerminalNode ID() { return getToken(MIDLGrammar.ID, 0); }
		public TerminalNode LBRACE_OPEN() { return getToken(MIDLGrammar.LBRACE_OPEN, 0); }
		public TerminalNode LBRACE_CLOSE() { return getToken(MIDLGrammar.LBRACE_CLOSE, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(MODULE);
			setState(66);
			match(ID);
			setState(67);
			match(LBRACE_OPEN);
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				definition();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MODULE || _la==STRUCT );
			setState(73);
			match(LBRACE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_declContext extends ParserRuleContext {
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public TerminalNode STRUCT() { return getToken(MIDLGrammar.STRUCT, 0); }
		public TerminalNode ID() { return getToken(MIDLGrammar.ID, 0); }
		public Type_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterType_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitType_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitType_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_declContext type_decl() throws RecognitionException {
		Type_declContext _localctx = new Type_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_decl);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				struct_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(STRUCT);
				setState(77);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_typeContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(MIDLGrammar.STRUCT, 0); }
		public TerminalNode ID() { return getToken(MIDLGrammar.ID, 0); }
		public TerminalNode LBRACE_OPEN() { return getToken(MIDLGrammar.LBRACE_OPEN, 0); }
		public Member_listContext member_list() {
			return getRuleContext(Member_listContext.class,0);
		}
		public TerminalNode LBRACE_CLOSE() { return getToken(MIDLGrammar.LBRACE_CLOSE, 0); }
		public Struct_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterStruct_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitStruct_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitStruct_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_typeContext struct_type() throws RecognitionException {
		Struct_typeContext _localctx = new Struct_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_struct_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(STRUCT);
			setState(81);
			match(ID);
			setState(82);
			match(LBRACE_OPEN);
			setState(83);
			member_list();
			setState(84);
			match(LBRACE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Member_listContext extends ParserRuleContext {
		public List<Type_specContext> type_spec() {
			return getRuleContexts(Type_specContext.class);
		}
		public Type_specContext type_spec(int i) {
			return getRuleContext(Type_specContext.class,i);
		}
		public List<DeclaratorsContext> declarators() {
			return getRuleContexts(DeclaratorsContext.class);
		}
		public DeclaratorsContext declarators(int i) {
			return getRuleContext(DeclaratorsContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MIDLGrammar.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MIDLGrammar.SEMICOLON, i);
		}
		public Member_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterMember_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitMember_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitMember_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_listContext member_list() throws RecognitionException {
		Member_listContext _localctx = new Member_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_member_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4672924942332L) != 0)) {
				{
				{
				setState(86);
				type_spec();
				setState(87);
				declarators();
				setState(88);
				match(SEMICOLON);
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Base_type_specContext base_type_spec() {
			return getRuleContext(Base_type_specContext.class,0);
		}
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitType_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitType_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type_spec);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				scoped_name();
				}
				break;
			case BOOLEAN:
			case SHORT:
			case LONG:
			case UNSIGNED:
			case INT8:
			case INT16:
			case INT32:
			case INT64:
			case UINT8:
			case UINT16:
			case UINT32:
			case UINT64:
			case CHAR:
			case STRING:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				base_type_spec();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				struct_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scoped_nameContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLE_COLON() { return getTokens(MIDLGrammar.DOUBLE_COLON); }
		public TerminalNode DOUBLE_COLON(int i) {
			return getToken(MIDLGrammar.DOUBLE_COLON, i);
		}
		public List<TerminalNode> ID() { return getTokens(MIDLGrammar.ID); }
		public TerminalNode ID(int i) {
			return getToken(MIDLGrammar.ID, i);
		}
		public Scoped_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scoped_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterScoped_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitScoped_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitScoped_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scoped_nameContext scoped_name() throws RecognitionException {
		Scoped_nameContext _localctx = new Scoped_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_scoped_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
				{
				setState(100);
				match(DOUBLE_COLON);
				setState(101);
				match(ID);
				}
				break;
			case ID:
				{
				setState(102);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLE_COLON) {
				{
				{
				setState(105);
				match(DOUBLE_COLON);
				setState(106);
				match(ID);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Base_type_specContext extends ParserRuleContext {
		public Floating_pt_typeContext floating_pt_type() {
			return getRuleContext(Floating_pt_typeContext.class,0);
		}
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public TerminalNode CHAR() { return getToken(MIDLGrammar.CHAR, 0); }
		public TerminalNode STRING() { return getToken(MIDLGrammar.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(MIDLGrammar.BOOLEAN, 0); }
		public Base_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterBase_type_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitBase_type_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitBase_type_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_type_specContext base_type_spec() throws RecognitionException {
		Base_type_specContext _localctx = new Base_type_specContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_base_type_spec);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				floating_pt_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				integer_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				match(CHAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(116);
				match(BOOLEAN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Floating_pt_typeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(MIDLGrammar.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(MIDLGrammar.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(MIDLGrammar.LONG, 0); }
		public Floating_pt_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floating_pt_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterFloating_pt_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitFloating_pt_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitFloating_pt_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Floating_pt_typeContext floating_pt_type() throws RecognitionException {
		Floating_pt_typeContext _localctx = new Floating_pt_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_floating_pt_type);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(DOUBLE);
				}
				break;
			case LONG:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(LONG);
				setState(122);
				match(DOUBLE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Integer_typeContext extends ParserRuleContext {
		public Signed_intContext signed_int() {
			return getRuleContext(Signed_intContext.class,0);
		}
		public Unsigned_intContext unsigned_int() {
			return getRuleContext(Unsigned_intContext.class,0);
		}
		public Integer_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterInteger_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitInteger_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitInteger_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_typeContext integer_type() throws RecognitionException {
		Integer_typeContext _localctx = new Integer_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_integer_type);
		try {
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHORT:
			case LONG:
			case INT8:
			case INT16:
			case INT32:
			case INT64:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				signed_int();
				}
				break;
			case UNSIGNED:
			case UINT8:
			case UINT16:
			case UINT32:
			case UINT64:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				unsigned_int();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signed_intContext extends ParserRuleContext {
		public TerminalNode SHORT() { return getToken(MIDLGrammar.SHORT, 0); }
		public TerminalNode INT16() { return getToken(MIDLGrammar.INT16, 0); }
		public List<TerminalNode> LONG() { return getTokens(MIDLGrammar.LONG); }
		public TerminalNode LONG(int i) {
			return getToken(MIDLGrammar.LONG, i);
		}
		public TerminalNode INT32() { return getToken(MIDLGrammar.INT32, 0); }
		public TerminalNode INT64() { return getToken(MIDLGrammar.INT64, 0); }
		public TerminalNode INT8() { return getToken(MIDLGrammar.INT8, 0); }
		public Signed_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterSigned_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitSigned_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitSigned_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_intContext signed_int() throws RecognitionException {
		Signed_intContext _localctx = new Signed_intContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_signed_int);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(SHORT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(INT16);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(LONG);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(INT32);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(LONG);
				setState(134);
				match(LONG);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(135);
				match(INT64);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(136);
				match(INT8);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unsigned_intContext extends ParserRuleContext {
		public TerminalNode UNSIGNED() { return getToken(MIDLGrammar.UNSIGNED, 0); }
		public TerminalNode SHORT() { return getToken(MIDLGrammar.SHORT, 0); }
		public List<TerminalNode> LONG() { return getTokens(MIDLGrammar.LONG); }
		public TerminalNode LONG(int i) {
			return getToken(MIDLGrammar.LONG, i);
		}
		public TerminalNode UINT8() { return getToken(MIDLGrammar.UINT8, 0); }
		public TerminalNode UINT16() { return getToken(MIDLGrammar.UINT16, 0); }
		public TerminalNode UINT32() { return getToken(MIDLGrammar.UINT32, 0); }
		public TerminalNode UINT64() { return getToken(MIDLGrammar.UINT64, 0); }
		public Unsigned_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterUnsigned_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitUnsigned_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitUnsigned_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unsigned_intContext unsigned_int() throws RecognitionException {
		Unsigned_intContext _localctx = new Unsigned_intContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_unsigned_int);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(UNSIGNED);
				setState(140);
				match(SHORT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(UNSIGNED);
				setState(142);
				match(LONG);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				match(UNSIGNED);
				setState(144);
				match(LONG);
				setState(145);
				match(LONG);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				match(UINT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				match(UINT16);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				match(UINT32);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(149);
				match(UINT64);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorsContext extends ParserRuleContext {
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MIDLGrammar.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MIDLGrammar.COMMA, i);
		}
		public DeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitDeclarators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitDeclarators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorsContext declarators() throws RecognitionException {
		DeclaratorsContext _localctx = new DeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			declarator();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(153);
				match(COMMA);
				setState(154);
				declarator();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Array_declaratorContext array_declarator() {
			return getRuleContext(Array_declaratorContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declarator);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				simple_declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				array_declarator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_declaratorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MIDLGrammar.ID, 0); }
		public TerminalNode EQUAL() { return getToken(MIDLGrammar.EQUAL, 0); }
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public Simple_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterSimple_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitSimple_declarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitSimple_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_declaratorContext simple_declarator() throws RecognitionException {
		Simple_declaratorContext _localctx = new Simple_declaratorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_simple_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(ID);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(165);
				match(EQUAL);
				setState(166);
				or_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_declaratorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MIDLGrammar.ID, 0); }
		public TerminalNode BRACKET_OPEN() { return getToken(MIDLGrammar.BRACKET_OPEN, 0); }
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public TerminalNode BRACKET_CLOSE() { return getToken(MIDLGrammar.BRACKET_CLOSE, 0); }
		public TerminalNode EQUAL() { return getToken(MIDLGrammar.EQUAL, 0); }
		public Exp_listContext exp_list() {
			return getRuleContext(Exp_listContext.class,0);
		}
		public Array_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterArray_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitArray_declarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitArray_declarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_declaratorContext array_declarator() throws RecognitionException {
		Array_declaratorContext _localctx = new Array_declaratorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_array_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(ID);
			setState(170);
			match(BRACKET_OPEN);
			setState(171);
			or_expr();
			setState(172);
			match(BRACKET_CLOSE);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(173);
				match(EQUAL);
				setState(174);
				exp_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exp_listContext extends ParserRuleContext {
		public TerminalNode BRACKET_OPEN() { return getToken(MIDLGrammar.BRACKET_OPEN, 0); }
		public List<Or_exprContext> or_expr() {
			return getRuleContexts(Or_exprContext.class);
		}
		public Or_exprContext or_expr(int i) {
			return getRuleContext(Or_exprContext.class,i);
		}
		public TerminalNode BRACKET_CLOSE() { return getToken(MIDLGrammar.BRACKET_CLOSE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MIDLGrammar.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MIDLGrammar.COMMA, i);
		}
		public Exp_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterExp_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitExp_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitExp_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_listContext exp_list() throws RecognitionException {
		Exp_listContext _localctx = new Exp_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_exp_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(BRACKET_OPEN);
			setState(178);
			or_expr();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(179);
				match(COMMA);
				setState(180);
				or_expr();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
			match(BRACKET_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Or_exprContext extends ParserRuleContext {
		public List<Xor_exprContext> xor_expr() {
			return getRuleContexts(Xor_exprContext.class);
		}
		public Xor_exprContext xor_expr(int i) {
			return getRuleContext(Xor_exprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(MIDLGrammar.OR); }
		public TerminalNode OR(int i) {
			return getToken(MIDLGrammar.OR, i);
		}
		public Or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterOr_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitOr_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitOr_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_exprContext or_expr() throws RecognitionException {
		Or_exprContext _localctx = new Or_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			xor_expr();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(189);
				match(OR);
				setState(190);
				xor_expr();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Xor_exprContext extends ParserRuleContext {
		public List<And_exprContext> and_expr() {
			return getRuleContexts(And_exprContext.class);
		}
		public And_exprContext and_expr(int i) {
			return getRuleContext(And_exprContext.class,i);
		}
		public List<TerminalNode> XOR() { return getTokens(MIDLGrammar.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(MIDLGrammar.XOR, i);
		}
		public Xor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterXor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitXor_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitXor_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Xor_exprContext xor_expr() throws RecognitionException {
		Xor_exprContext _localctx = new Xor_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_xor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			and_expr();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==XOR) {
				{
				{
				setState(197);
				match(XOR);
				setState(198);
				and_expr();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class And_exprContext extends ParserRuleContext {
		public List<Shift_exprContext> shift_expr() {
			return getRuleContexts(Shift_exprContext.class);
		}
		public Shift_exprContext shift_expr(int i) {
			return getRuleContext(Shift_exprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MIDLGrammar.AND); }
		public TerminalNode AND(int i) {
			return getToken(MIDLGrammar.AND, i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterAnd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitAnd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			shift_expr();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(205);
				match(AND);
				setState(206);
				shift_expr();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Shift_exprContext extends ParserRuleContext {
		public List<Add_exprContext> add_expr() {
			return getRuleContexts(Add_exprContext.class);
		}
		public Add_exprContext add_expr(int i) {
			return getRuleContext(Add_exprContext.class,i);
		}
		public List<TerminalNode> OSTREAM() { return getTokens(MIDLGrammar.OSTREAM); }
		public TerminalNode OSTREAM(int i) {
			return getToken(MIDLGrammar.OSTREAM, i);
		}
		public List<TerminalNode> ISTREAM() { return getTokens(MIDLGrammar.ISTREAM); }
		public TerminalNode ISTREAM(int i) {
			return getToken(MIDLGrammar.ISTREAM, i);
		}
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterShift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitShift_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitShift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_shift_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			add_expr();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OSTREAM || _la==ISTREAM) {
				{
				{
				setState(213);
				_la = _input.LA(1);
				if ( !(_la==OSTREAM || _la==ISTREAM) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(214);
				add_expr();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Add_exprContext extends ParserRuleContext {
		public List<Mult_exprContext> mult_expr() {
			return getRuleContexts(Mult_exprContext.class);
		}
		public Mult_exprContext mult_expr(int i) {
			return getRuleContext(Mult_exprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(MIDLGrammar.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(MIDLGrammar.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(MIDLGrammar.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(MIDLGrammar.MINUS, i);
		}
		public Add_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterAdd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitAdd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitAdd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_exprContext add_expr() throws RecognitionException {
		Add_exprContext _localctx = new Add_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_add_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			mult_expr();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(221);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(222);
				mult_expr();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mult_exprContext extends ParserRuleContext {
		public List<Unary_exprContext> unary_expr() {
			return getRuleContexts(Unary_exprContext.class);
		}
		public Unary_exprContext unary_expr(int i) {
			return getRuleContext(Unary_exprContext.class,i);
		}
		public List<TerminalNode> MULTIPLICATION() { return getTokens(MIDLGrammar.MULTIPLICATION); }
		public TerminalNode MULTIPLICATION(int i) {
			return getToken(MIDLGrammar.MULTIPLICATION, i);
		}
		public List<TerminalNode> DIVISION() { return getTokens(MIDLGrammar.DIVISION); }
		public TerminalNode DIVISION(int i) {
			return getToken(MIDLGrammar.DIVISION, i);
		}
		public List<TerminalNode> ROUNDING() { return getTokens(MIDLGrammar.ROUNDING); }
		public TerminalNode ROUNDING(int i) {
			return getToken(MIDLGrammar.ROUNDING, i);
		}
		public Mult_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterMult_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitMult_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitMult_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mult_exprContext mult_expr() throws RecognitionException {
		Mult_exprContext _localctx = new Mult_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mult_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			unary_expr();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) {
				{
				{
				setState(229);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(230);
				unary_expr();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_exprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(MIDLGrammar.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(MIDLGrammar.PLUS, 0); }
		public TerminalNode NOR() { return getToken(MIDLGrammar.NOR, 0); }
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitUnary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unary_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68820140032L) != 0)) {
				{
				setState(236);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68820140032L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(239);
			literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MIDLGrammar.INTEGER, 0); }
		public TerminalNode FLOATING_PT() { return getToken(MIDLGrammar.FLOATING_PT, 0); }
		public TerminalNode CHARRegular() { return getToken(MIDLGrammar.CHARRegular, 0); }
		public TerminalNode BOOLEANRegular() { return getToken(MIDLGrammar.BOOLEANRegular, 0); }
		public TerminalNode STRINGRegular() { return getToken(MIDLGrammar.STRINGRegular, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MIDLGrammarListener ) ((MIDLGrammarListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MIDLGrammarVisitor ) return ((MIDLGrammarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132491151147008L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u00f4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0004\u00006\b\u0000\u000b\u0000"+
		"\f\u00007\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001@\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0004\u0002F\b\u0002\u000b\u0002\f\u0002G\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005[\b\u0005\n\u0005"+
		"\f\u0005^\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006c\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007h\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007l\b\u0007\n\u0007\f\u0007o\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\bv\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t|\b\t\u0001\n\u0001\n\u0003\n\u0080\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u008a\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0097\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u009c\b\r\n\r\f\r\u009f\t\r\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00a3\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00a8\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00b0\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00b6\b\u0011\n\u0011\f\u0011\u00b9\t\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00c0"+
		"\b\u0012\n\u0012\f\u0012\u00c3\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u00c8\b\u0013\n\u0013\f\u0013\u00cb\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u00d0\b\u0014\n\u0014\f\u0014\u00d3\t\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00d8\b\u0015\n\u0015"+
		"\f\u0015\u00db\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u00e0\b\u0016\n\u0016\f\u0016\u00e3\t\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u00e8\b\u0017\n\u0017\f\u0017\u00eb\t\u0017\u0001\u0018"+
		"\u0003\u0018\u00ee\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0000\u0000\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000\u0005\u0001"+
		"\u0000\u001f \u0001\u0000\u0019\u001a\u0001\u0000\u001b\u001d\u0002\u0000"+
		"\u0019\u001a$$\u0002\u0000\'\'+.\u0101\u00005\u0001\u0000\u0000\u0000"+
		"\u0002?\u0001\u0000\u0000\u0000\u0004A\u0001\u0000\u0000\u0000\u0006N"+
		"\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\n\\\u0001\u0000\u0000"+
		"\u0000\fb\u0001\u0000\u0000\u0000\u000eg\u0001\u0000\u0000\u0000\u0010"+
		"u\u0001\u0000\u0000\u0000\u0012{\u0001\u0000\u0000\u0000\u0014\u007f\u0001"+
		"\u0000\u0000\u0000\u0016\u0089\u0001\u0000\u0000\u0000\u0018\u0096\u0001"+
		"\u0000\u0000\u0000\u001a\u0098\u0001\u0000\u0000\u0000\u001c\u00a2\u0001"+
		"\u0000\u0000\u0000\u001e\u00a4\u0001\u0000\u0000\u0000 \u00a9\u0001\u0000"+
		"\u0000\u0000\"\u00b1\u0001\u0000\u0000\u0000$\u00bc\u0001\u0000\u0000"+
		"\u0000&\u00c4\u0001\u0000\u0000\u0000(\u00cc\u0001\u0000\u0000\u0000*"+
		"\u00d4\u0001\u0000\u0000\u0000,\u00dc\u0001\u0000\u0000\u0000.\u00e4\u0001"+
		"\u0000\u0000\u00000\u00ed\u0001\u0000\u0000\u00002\u00f1\u0001\u0000\u0000"+
		"\u000046\u0003\u0002\u0001\u000054\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008\u0001"+
		"\u0001\u0000\u0000\u00009:\u0003\u0006\u0003\u0000:;\u0005\u0017\u0000"+
		"\u0000;@\u0001\u0000\u0000\u0000<=\u0003\u0004\u0002\u0000=>\u0005\u0017"+
		"\u0000\u0000>@\u0001\u0000\u0000\u0000?9\u0001\u0000\u0000\u0000?<\u0001"+
		"\u0000\u0000\u0000@\u0003\u0001\u0000\u0000\u0000AB\u0005\u0001\u0000"+
		"\u0000BC\u0005*\u0000\u0000CE\u0005\u0013\u0000\u0000DF\u0003\u0002\u0001"+
		"\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005"+
		"\u0014\u0000\u0000J\u0005\u0001\u0000\u0000\u0000KO\u0003\b\u0004\u0000"+
		"LM\u0005\u0002\u0000\u0000MO\u0005*\u0000\u0000NK\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000O\u0007\u0001\u0000\u0000\u0000PQ\u0005\u0002"+
		"\u0000\u0000QR\u0005*\u0000\u0000RS\u0005\u0013\u0000\u0000ST\u0003\n"+
		"\u0005\u0000TU\u0005\u0014\u0000\u0000U\t\u0001\u0000\u0000\u0000VW\u0003"+
		"\f\u0006\u0000WX\u0003\u001a\r\u0000XY\u0005\u0017\u0000\u0000Y[\u0001"+
		"\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u000b\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000_c\u0003\u000e\u0007\u0000`c\u0003"+
		"\u0010\b\u0000ac\u0003\b\u0004\u0000b_\u0001\u0000\u0000\u0000b`\u0001"+
		"\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000c\r\u0001\u0000\u0000\u0000"+
		"de\u0005&\u0000\u0000eh\u0005*\u0000\u0000fh\u0005*\u0000\u0000gd\u0001"+
		"\u0000\u0000\u0000gf\u0001\u0000\u0000\u0000hm\u0001\u0000\u0000\u0000"+
		"ij\u0005&\u0000\u0000jl\u0005*\u0000\u0000ki\u0001\u0000\u0000\u0000l"+
		"o\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000n\u000f\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pv\u0003"+
		"\u0012\t\u0000qv\u0003\u0014\n\u0000rv\u0005\u000f\u0000\u0000sv\u0005"+
		"\u0010\u0000\u0000tv\u0005\u0003\u0000\u0000up\u0001\u0000\u0000\u0000"+
		"uq\u0001\u0000\u0000\u0000ur\u0001\u0000\u0000\u0000us\u0001\u0000\u0000"+
		"\u0000ut\u0001\u0000\u0000\u0000v\u0011\u0001\u0000\u0000\u0000w|\u0005"+
		"\u0011\u0000\u0000x|\u0005\u0012\u0000\u0000yz\u0005\u0005\u0000\u0000"+
		"z|\u0005\u0012\u0000\u0000{w\u0001\u0000\u0000\u0000{x\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000|\u0013\u0001\u0000\u0000\u0000}\u0080"+
		"\u0003\u0016\u000b\u0000~\u0080\u0003\u0018\f\u0000\u007f}\u0001\u0000"+
		"\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0015\u0001\u0000\u0000"+
		"\u0000\u0081\u008a\u0005\u0004\u0000\u0000\u0082\u008a\u0005\b\u0000\u0000"+
		"\u0083\u008a\u0005\u0005\u0000\u0000\u0084\u008a\u0005\t\u0000\u0000\u0085"+
		"\u0086\u0005\u0005\u0000\u0000\u0086\u008a\u0005\u0005\u0000\u0000\u0087"+
		"\u008a\u0005\n\u0000\u0000\u0088\u008a\u0005\u0007\u0000\u0000\u0089\u0081"+
		"\u0001\u0000\u0000\u0000\u0089\u0082\u0001\u0000\u0000\u0000\u0089\u0083"+
		"\u0001\u0000\u0000\u0000\u0089\u0084\u0001\u0000\u0000\u0000\u0089\u0085"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088"+
		"\u0001\u0000\u0000\u0000\u008a\u0017\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0005\u0006\u0000\u0000\u008c\u0097\u0005\u0004\u0000\u0000\u008d\u008e"+
		"\u0005\u0006\u0000\u0000\u008e\u0097\u0005\u0005\u0000\u0000\u008f\u0090"+
		"\u0005\u0006\u0000\u0000\u0090\u0091\u0005\u0005\u0000\u0000\u0091\u0097"+
		"\u0005\u0005\u0000\u0000\u0092\u0097\u0005\u000b\u0000\u0000\u0093\u0097"+
		"\u0005\f\u0000\u0000\u0094\u0097\u0005\r\u0000\u0000\u0095\u0097\u0005"+
		"\u000e\u0000\u0000\u0096\u008b\u0001\u0000\u0000\u0000\u0096\u008d\u0001"+
		"\u0000\u0000\u0000\u0096\u008f\u0001\u0000\u0000\u0000\u0096\u0092\u0001"+
		"\u0000\u0000\u0000\u0096\u0093\u0001\u0000\u0000\u0000\u0096\u0094\u0001"+
		"\u0000\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0019\u0001"+
		"\u0000\u0000\u0000\u0098\u009d\u0003\u001c\u000e\u0000\u0099\u009a\u0005"+
		"\u0018\u0000\u0000\u009a\u009c\u0003\u001c\u000e\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000\u0000\u009d\u009b\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u001b\u0001"+
		"\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a3\u0003"+
		"\u001e\u000f\u0000\u00a1\u00a3\u0003 \u0010\u0000\u00a2\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u001d\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a7\u0005*\u0000\u0000\u00a5\u00a6\u0005\u001e\u0000"+
		"\u0000\u00a6\u00a8\u0003$\u0012\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u001f\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0005*\u0000\u0000\u00aa\u00ab\u0005\u0015\u0000\u0000\u00ab"+
		"\u00ac\u0003$\u0012\u0000\u00ac\u00af\u0005\u0016\u0000\u0000\u00ad\u00ae"+
		"\u0005\u001e\u0000\u0000\u00ae\u00b0\u0003\"\u0011\u0000\u00af\u00ad\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0!\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0005\u0015\u0000\u0000\u00b2\u00b7\u0003$\u0012"+
		"\u0000\u00b3\u00b4\u0005\u0018\u0000\u0000\u00b4\u00b6\u0003$\u0012\u0000"+
		"\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0005\u0016\u0000\u0000\u00bb#\u0001\u0000\u0000\u0000\u00bc"+
		"\u00c1\u0003&\u0013\u0000\u00bd\u00be\u0005#\u0000\u0000\u00be\u00c0\u0003"+
		"&\u0013\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2%\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c9\u0003(\u0014\u0000\u00c5\u00c6\u0005!\u0000\u0000\u00c6"+
		"\u00c8\u0003(\u0014\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00cb"+
		"\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\'\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cc\u00d1\u0003*\u0015\u0000\u00cd\u00ce\u0005\""+
		"\u0000\u0000\u00ce\u00d0\u0003*\u0015\u0000\u00cf\u00cd\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2)\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d9\u0003,\u0016\u0000\u00d5"+
		"\u00d6\u0007\u0000\u0000\u0000\u00d6\u00d8\u0003,\u0016\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da+\u0001"+
		"\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00e1\u0003"+
		".\u0017\u0000\u00dd\u00de\u0007\u0001\u0000\u0000\u00de\u00e0\u0003.\u0017"+
		"\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e2-\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e9\u00030\u0018\u0000\u00e5\u00e6\u0007\u0002\u0000\u0000\u00e6"+
		"\u00e8\u00030\u0018\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00eb"+
		"\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ea/\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ee\u0007\u0003\u0000\u0000\u00ed\u00ec\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u00032\u0019\u0000\u00f01\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f2\u0007\u0004\u0000\u0000\u00f23\u0001\u0000\u0000\u0000"+
		"\u00197?GN\\bgmu{\u007f\u0089\u0096\u009d\u00a2\u00a7\u00af\u00b7\u00c1"+
		"\u00c9\u00d1\u00d9\u00e1\u00e9\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}