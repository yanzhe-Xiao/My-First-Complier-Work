parser grammar MIDLGrammar;
options{tokenVocab = MIDLLexer;}
// 定义整个规范的开始符号
specification: (definition)+ ;

// 定义definition产生式
definition: type_decl SEMICOLON | module SEMICOLON;

// 定义module产生式
module: MODULE ID LBRACE_OPEN (definition)+ LBRACE_CLOSE;

// 定义type_decl产生式
type_decl: struct_type | STRUCT ID;

// 定义struct_type产生式
struct_type: STRUCT ID LBRACE_OPEN member_list LBRACE_CLOSE;

// 定义member_list产生式
member_list: (type_spec declarators SEMICOLON)*;

// 定义type_spec产生式
type_spec: scoped_name | base_type_spec | struct_type;

// 定义scoped_name产生式
scoped_name: (DOUBLE_COLON ID | ID ) (DOUBLE_COLON ID)*;

// 定义base_type_spec产生式
base_type_spec: floating_pt_type | integer_type | CHAR | STRING | BOOLEAN;

// 定义floating_pt_type产生式
floating_pt_type: FLOAT | DOUBLE | LONG DOUBLE;

// 定义integer_type产生式
integer_type: signed_int | unsigned_int;

// 定义signed_int产生式
signed_int: SHORT | INT16 | LONG | INT32 | LONG LONG | INT64 | INT8;

// 定义unsigned_int产生式
unsigned_int: UNSIGNED SHORT |UNSIGNED LONG |UNSIGNED LONG LONG |UINT8 | UINT16 | UINT32 | UINT64;

// 定义declarators产生式
declarators: declarator (COMMA declarator)*;

// 定义declarator产生式
declarator: simple_declarator | array_declarator;

// 定义simple_declarator产生式
simple_declarator: ID (EQUAL or_expr)?;

// 定义array_declarator产生式
array_declarator: ID BRACKET_OPEN or_expr BRACKET_CLOSE (EQUAL exp_list)?;

// 定义exp_list产生式
exp_list: BRACKET_OPEN or_expr (COMMA or_expr)* BRACKET_CLOSE;

// 定义or_expr产生式
or_expr: xor_expr (OR xor_expr)*;

// 定义xor_expr产生式
xor_expr: and_expr (XOR and_expr)*;

// 定义and_expr产生式
and_expr: shift_expr (AND shift_expr)*;

// 定义shift_expr产生式
shift_expr: add_expr ((OSTREAM | ISTREAM) add_expr)*;

// 定义add_expr产生式
add_expr: mult_expr ((PLUS | MINUS) mult_expr)*;

// 定义mult_expr产生式
mult_expr: unary_expr ((MULTIPLICATION | DIVISION | ROUNDING) unary_expr)*;

// 定义unary_expr产生式
unary_expr: (MINUS | PLUS | NOR)? literal;

// 定义literal产生式
literal: INTEGER | FLOATING_PT | CHARRegular| BOOLEANRegular | STRINGRegular   ;

