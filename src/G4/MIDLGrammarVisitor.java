// Generated from C:/Code/IdeaProjects/ComplierForMIDL/src/G4/MIDLGrammar.g4 by ANTLR 4.13.1
package G4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MIDLGrammar}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MIDLGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecification(MIDLGrammar.SpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(MIDLGrammar.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(MIDLGrammar.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#type_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_decl(MIDLGrammar.Type_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#struct_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_type(MIDLGrammar.Struct_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#member_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_list(MIDLGrammar.Member_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_spec(MIDLGrammar.Type_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#scoped_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScoped_name(MIDLGrammar.Scoped_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase_type_spec(MIDLGrammar.Base_type_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#floating_pt_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloating_pt_type(MIDLGrammar.Floating_pt_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#integer_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_type(MIDLGrammar.Integer_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#signed_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned_int(MIDLGrammar.Signed_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#unsigned_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsigned_int(MIDLGrammar.Unsigned_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#declarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarators(MIDLGrammar.DeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(MIDLGrammar.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#simple_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_declarator(MIDLGrammar.Simple_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#array_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_declarator(MIDLGrammar.Array_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#exp_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_list(MIDLGrammar.Exp_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expr(MIDLGrammar.Or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#xor_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor_expr(MIDLGrammar.Xor_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(MIDLGrammar.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expr(MIDLGrammar.Shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#add_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_expr(MIDLGrammar.Add_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#mult_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult_expr(MIDLGrammar.Mult_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#unary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(MIDLGrammar.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLGrammar#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MIDLGrammar.LiteralContext ctx);
}