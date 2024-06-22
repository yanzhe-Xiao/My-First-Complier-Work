lexer grammar MIDLLexer;

// 定义关键字
MODULE: [mM] [oO] [dD] [uU] [lL] [eE];
STRUCT: [sS] [tT] [rR] [uU] [cC] [tT];
BOOLEAN: [bB] [oO] [oO] [lL] [eE] [aA] [nN];
SHORT: [sS] [hH] [oO] [rR] [tT];
LONG: [lL] [oO] [nN] [gG];
UNSIGNED: [uU] [nN] [sS] [iI] [gG] [nN] [eE] [dD];
INT8: [iI] [nN] [tT] [8];
INT16: [iI] [nN] [tT] [1I][6];
INT32: [iI] [nN] [tT] [3I][2];
INT64: [iI] [nN] [tT] [6I][4];
UINT8: [uU] [iI] [nN] [tT] [8];
UINT16: [uU] [iI] [nN] [tT] [1I][6];
UINT32: [uU] [iI] [nN] [tT] [3I][2];
UINT64: [uU] [iI] [nN] [tT] [6I][4];
CHAR: [cC] [hH] [aA] [rR];
STRING: [sS] [tT] [rR] [iI] [nN] [gG];
FLOAT: [fF] [lL] [oO] [aA] [tT];
DOUBLE: [dD] [oO] [uU] [bB] [lL] [eE];



// 定义语言专用符号
LBRACE_OPEN: '{' ;
LBRACE_CLOSE: '}' ;
BRACKET_OPEN: '[' ;
BRACKET_CLOSE: ']' ;
SEMICOLON: ';' ;
COMMA: ',' ;
PLUS: '+' ;
MINUS: '-' ;
DIVISION: '/' ;
MULTIPLICATION: '*' ;
ROUNDING: '%' ;
EQUAL: '=' ;
OSTREAM: '<<' ;
ISTREAM: '>>' ;
XOR: '^' ;
AND: '&' ;
OR: '|' ;
NOR: '~' ;
COLON: ':' ;
DOUBLE_COLON: '::' ;


// 定义布尔值BOOLEAN
BOOLEANRegular: TRUE | FALSE ;
TRUE: 'true' | 'TRUE';
FALSE: 'false'| 'FALSE';

//定义辅助正则表达式
fragment LETTER: [a-zA-Z] ;
fragment DIGIT: [0-9] ;
fragment UNDERLINE: '_' ;

// 定义标识符ID
ID: LETTER (UNDERLINE | LETTER | DIGIT)* ;

// 定义整数INTEGER
fragment INTEGER_TYPE_SUFFIX : [1L];
INTEGER: ([0] | [1-9] [0-9]*) INTEGER_TYPE_SUFFIX?;


// 定义浮点数FLOATING_PT
fragment EXPONENT: [eE][+-]?[0-9]+;
fragment FLOAT_TYPE_SUFFIX:  [fF]|[dD];
FLOATING_PT: (DIGIT+ '.' DIGIT* EXPONENT? FLOAT_TYPE_SUFFIX? |
                '.' DIGIT+ EXPONENT? FLOAT_TYPE_SUFFIX? |
                DIGIT+ EXPONENT FLOAT_TYPE_SUFFIX?) ;

// 定义单字符CHAR
fragment ESCAPE_SEQUENCE: '\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\') ;
CHARRegular: '\'' (ESCAPE_SEQUENCE | ~('\\' | '\'')) '\'' ;

// 定义字符串STRING
STRINGRegular: '"' (ESCAPE_SEQUENCE | ~('\\' | '"'))* '"' ;

// 忽略空白字符
WS: [ \t\r\n]+ -> skip ;