// Generated from C:/Code/IdeaProjects/ComplierForMIDL/src/G4/MIDLGrammar.g4 by ANTLR 4.13.1
package G4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MIDLGrammar}.
 */
public interface MIDLGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#specification}.
	 * @param ctx the parse tree
	 */
	void enterSpecification(MIDLGrammar.SpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#specification}.
	 * @param ctx the parse tree
	 */
	void exitSpecification(MIDLGrammar.SpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(MIDLGrammar.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(MIDLGrammar.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(MIDLGrammar.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(MIDLGrammar.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#type_decl}.
	 * @param ctx the parse tree
	 */
	void enterType_decl(MIDLGrammar.Type_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#type_decl}.
	 * @param ctx the parse tree
	 */
	void exitType_decl(MIDLGrammar.Type_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#struct_type}.
	 * @param ctx the parse tree
	 */
	void enterStruct_type(MIDLGrammar.Struct_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#struct_type}.
	 * @param ctx the parse tree
	 */
	void exitStruct_type(MIDLGrammar.Struct_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#member_list}.
	 * @param ctx the parse tree
	 */
	void enterMember_list(MIDLGrammar.Member_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#member_list}.
	 * @param ctx the parse tree
	 */
	void exitMember_list(MIDLGrammar.Member_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#type_spec}.
	 * @param ctx the parse tree
	 */
	void enterType_spec(MIDLGrammar.Type_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#type_spec}.
	 * @param ctx the parse tree
	 */
	void exitType_spec(MIDLGrammar.Type_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#scoped_name}.
	 * @param ctx the parse tree
	 */
	void enterScoped_name(MIDLGrammar.Scoped_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#scoped_name}.
	 * @param ctx the parse tree
	 */
	void exitScoped_name(MIDLGrammar.Scoped_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void enterBase_type_spec(MIDLGrammar.Base_type_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void exitBase_type_spec(MIDLGrammar.Base_type_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#floating_pt_type}.
	 * @param ctx the parse tree
	 */
	void enterFloating_pt_type(MIDLGrammar.Floating_pt_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#floating_pt_type}.
	 * @param ctx the parse tree
	 */
	void exitFloating_pt_type(MIDLGrammar.Floating_pt_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#integer_type}.
	 * @param ctx the parse tree
	 */
	void enterInteger_type(MIDLGrammar.Integer_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#integer_type}.
	 * @param ctx the parse tree
	 */
	void exitInteger_type(MIDLGrammar.Integer_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#signed_int}.
	 * @param ctx the parse tree
	 */
	void enterSigned_int(MIDLGrammar.Signed_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#signed_int}.
	 * @param ctx the parse tree
	 */
	void exitSigned_int(MIDLGrammar.Signed_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_int(MIDLGrammar.Unsigned_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_int(MIDLGrammar.Unsigned_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#declarators}.
	 * @param ctx the parse tree
	 */
	void enterDeclarators(MIDLGrammar.DeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#declarators}.
	 * @param ctx the parse tree
	 */
	void exitDeclarators(MIDLGrammar.DeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(MIDLGrammar.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(MIDLGrammar.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#simple_declarator}.
	 * @param ctx the parse tree
	 */
	void enterSimple_declarator(MIDLGrammar.Simple_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#simple_declarator}.
	 * @param ctx the parse tree
	 */
	void exitSimple_declarator(MIDLGrammar.Simple_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#array_declarator}.
	 * @param ctx the parse tree
	 */
	void enterArray_declarator(MIDLGrammar.Array_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#array_declarator}.
	 * @param ctx the parse tree
	 */
	void exitArray_declarator(MIDLGrammar.Array_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#exp_list}.
	 * @param ctx the parse tree
	 */
	void enterExp_list(MIDLGrammar.Exp_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#exp_list}.
	 * @param ctx the parse tree
	 */
	void exitExp_list(MIDLGrammar.Exp_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#or_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_expr(MIDLGrammar.Or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#or_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_expr(MIDLGrammar.Or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#xor_expr}.
	 * @param ctx the parse tree
	 */
	void enterXor_expr(MIDLGrammar.Xor_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#xor_expr}.
	 * @param ctx the parse tree
	 */
	void exitXor_expr(MIDLGrammar.Xor_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(MIDLGrammar.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(MIDLGrammar.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#shift_expr}.
	 * @param ctx the parse tree
	 */
	void enterShift_expr(MIDLGrammar.Shift_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#shift_expr}.
	 * @param ctx the parse tree
	 */
	void exitShift_expr(MIDLGrammar.Shift_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#add_expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd_expr(MIDLGrammar.Add_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#add_expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd_expr(MIDLGrammar.Add_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#mult_expr}.
	 * @param ctx the parse tree
	 */
	void enterMult_expr(MIDLGrammar.Mult_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#mult_expr}.
	 * @param ctx the parse tree
	 */
	void exitMult_expr(MIDLGrammar.Mult_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(MIDLGrammar.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(MIDLGrammar.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLGrammar#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MIDLGrammar.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLGrammar#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MIDLGrammar.LiteralContext ctx);
}