package MIDL_AST;

import G4.MIDLGrammar;
import G4.MIDLGrammarBaseVisitor;

import java.util.List;

public class Format_AST extends MIDLGrammarBaseVisitor<String> {
    public Format_AST() {
        super();
    }
    // 用StringBuilder存储AST
    private StringBuilder ast = new StringBuilder();
    // 由于继承了BaseVisitor，覆写函数的时候不能自己加形参，所以设置一个level来记录层数，便于格式化输出
    private int level = 0;

    /**
     * 获取当前层级的缩进字符串
     * @return 缩进字符串
     */
    private String getIndentation() {
        return " ".repeat(level); // Java 11及以上版本支持repeat方法
    }

    public String getAST() {
        return ast.toString();
    }

    /**
     * specification -> definition { definition }
     */
    @Override
    public String visitSpecification(MIDLGrammar.SpecificationContext ctx) {
        // 开始构建 specification 节点
        ast.append("specification {\n");
        // 遍历所有的 definition 节点
        for (MIDLGrammar.DefinitionContext definition : ctx.definition()) {
            // 访问每个 definition 节点，并将结果添加到 AST 中
            visitDefinition(definition);
        }

        // 结束 specification 节点
        ast.append("}\n");
        return ast.toString();
    }
    /**
     * definiton -> type_decl“;”| module “;”
     */
    @Override
    public String visitDefinition(MIDLGrammar.DefinitionContext ctx){
        level++;
        // 根据子节点的数量判断是 type_decl 还是 module
        if (ctx.type_decl() != null) {
            // 如果是类型声明，递归调用 visitType_decl 方法
            visitType_decl(ctx.type_decl());
            level--;
            return null; // 类型声明后添加分号和换行
        } else if (ctx.module() != null) {
            // 如果是模块定义，递归调用 visitModule 方法
            visitModule(ctx.module());
            level--;
            return null; // 模块定义后添加分号和换行
        } else {
            // 如果既不类型声明也不是模块定义，抛出错误
            throw new IllegalStateException("Unknown definition context");
        }

    }

    /**
     * 实现module产生式
     * module -> “module”ID “{” definition { definition } “}”
     */
    @Override
    public String visitModule(MIDLGrammar.ModuleContext ctx) {
        // 增加缩进
        level++;
        // 添加模块开始
        ast.append(getIndentation()).append("module ")
                .append(ctx.ID().getText()).append(" {\n");

        // 遍历所有的 definition 节点
        for (MIDLGrammar.DefinitionContext definition : ctx.definition()) {
            // 访问每个 definition 节点，并将结果添加到 AST 中
            visitDefinition(definition);
        }

        // 减少缩进
        level--;
        // 添加模块结束
        ast.append(getIndentation()).append("}\n");
        return "";
    }
    /**
     * type_decl -> struct_type | “struct” ID
     *
     */
    @Override public String visitType_decl(MIDLGrammar.Type_declContext ctx) {
        level++;
//        ast.append(getIndentation());
        // 如果是 struct_type，递归调用 visitStruct_type 方法
        if (ctx.struct_type() != null) {
            visitStruct_type(ctx.struct_type());
        } else  {
            // 如果是 struct ID，直接添加到 AST 中
            ast.append("struct ")
                    .append(ctx.ID().getText()).append(";\n");
        }
        level--;
        return "";
    }
    /**
     * struct_type->“struct” ID “{”   member_list “}”
     *
     */
    @Override public String visitStruct_type(MIDLGrammar.Struct_typeContext ctx) {
        // 增加缩进
        level++;
        // 添加结构体开始
        ast.append(getIndentation()).append("struct ").append(ctx.ID().getText()).append(" {\n");

        // 遍历所有的 member_list 节点
        //并将结果添加到 AST 中
        visitMember_list(ctx.member_list());

        // 添加结构体结束
        ast.append(getIndentation()).append("}\n");

        // 减少缩进
        level--;
        return "";
    }
    /**
     * member_list-> { type_spec declarators “;” }
     *
     */
    @Override public String visitMember_list(MIDLGrammar.Member_listContext ctx) {
        // 增加缩进
        level++;
        // 遍历所有的 type_spec 节点
        List<MIDLGrammar.Type_specContext> typeSpecs = ctx.type_spec();
        List<MIDLGrammar.DeclaratorsContext> declarators = ctx.declarators();
        for (int i = 0; i < typeSpecs.size(); i++) {
            // 添加 type_spec 节点
            visitType_spec(typeSpecs.get(i));
            // 添加 declarators 节点
            visitDeclarators(declarators.get(i));
            // 添加分号
            ast.append(";\n");
        }
        // 减少缩进
        level--;
        return "";
    }
    /**
     * type_spec -> scoped_name | base_type_spec | struct_type
     *
     */
    @Override public String visitType_spec(MIDLGrammar.Type_specContext ctx) {
        level++;
        // 如果是 scoped_name，递归调用 visitScoped_name 方法
        if (ctx.scoped_name() != null) {
            visitScoped_name(ctx.scoped_name());
        } else if (ctx.base_type_spec() != null) {
            // 如果是 base_type_spec，递归调用 visitBase_type_spec 方法
            visitBase_type_spec(ctx.base_type_spec());
        } else if (ctx.struct_type() != null) {
            // 如果是 struct_type，递归调用 visitStruct_type 方法
            visitStruct_type(ctx.struct_type());
        } else {
            // 如果既不是 scoped_name 也不是 base_type_spec 也不是 struct_type，抛出错误
            throw new IllegalStateException("Unknown type_spec context");
        }
        level--;
        return "";
    }
    /**
     * scoped_name -> [“::”] ID {“::” ID }
     *
     */
    @Override public String visitScoped_name(MIDLGrammar.Scoped_nameContext ctx) {
        level++;
        ast.append(getIndentation());
        // 如果有 ::，则添加到 AST 中
        if (ctx.DOUBLE_COLON() != null) {
            ast.append("::");
        }
        // 添加 ID
        ast.append(ctx.ID(0).getText());
        // 遍历所有的 ID 节点
        for (int i = 1; i < ctx.ID().size(); i++) {
            // 添加 :: 和 ID
            ast.append("::").append(ctx.ID(i).getText());
        }
        level--;
        return "";
    }
    /**
     * base_type_spec->floating_pt_type|integer_type|“char”|“string”|“boolean”
     *
     */
    @Override public String visitBase_type_spec(MIDLGrammar.Base_type_specContext ctx) {
        level++;

        // 如果是 floating_pt_type，递归调用 visitFloating_pt_type 方法
        if (ctx.floating_pt_type() != null) {
            visitFloating_pt_type(ctx.floating_pt_type());
        } else if (ctx.integer_type() != null) {
            // 如果是 integer_type，递归调用 visitInteger_type 方法
            visitInteger_type(ctx.integer_type());
        } else if(ctx.CHAR() != null || ctx.STRING()!=null || ctx.BOOLEAN()!=null) {
            ast.append(getIndentation());
            // 如果是 char、string 或 boolean，直接添加到 AST 中
            ast.append(ctx.getText());
        }else {
            // 如果既不是 floating_pt_type 也不是 integer_type，抛出错误
            throw new IllegalStateException("Unknown base_type_spec context");
        }
        level--;
        return "";
    }
    /**
     * floating_pt_type -> “float” | “double” | “long double”
     *
     */
    @Override public String visitFloating_pt_type(MIDLGrammar.Floating_pt_typeContext ctx) {
        level++;
        ast.append(getIndentation());
        if(ctx.FLOAT() != null || ctx.DOUBLE() != null){
        // 直接添加到 AST 中
        ast.append(ctx.getText());
        level--;
        return "";
    }
    // 如果是 long double，直接添加到 AST 中
        else if(ctx.LONG() != null){
            ast.append(ctx.getText());
            level--;
            return "";
        }
        else {
            // 如果既不是 float 也不是 double 也不是 long double，抛出错误
            throw new IllegalStateException("Unknown floating_pt_type context");
        }
    }
    /**
     * integer_type -> signed_int | unsigned_int
     *
     */
    @Override public String visitInteger_type(MIDLGrammar.Integer_typeContext ctx) {
        level++;
        // 如果是 signed_int，递归调用 visitSigned_int 方法
        if (ctx.signed_int() != null) {
            visitSigned_int(ctx.signed_int());
        } else if (ctx.unsigned_int() != null) {
            // 如果是 unsigned_int，递归调用 visitUnsigned_int 方法
            visitUnsigned_int(ctx.unsigned_int());
        } else {
            // 如果既不是 signed_int 也不是 unsigned_int，抛出错误
            throw new IllegalStateException("Unknown integer_type context");
        }
        level--;
        return "";
    }
    /**
     *signed_int->(“short”|“int16”)
     * |(“long”|“int32”)
     * |(“long” “long”|“int64”)
     * |“int8”
     */
    @Override public String visitSigned_int(MIDLGrammar.Signed_intContext ctx) {
        level++;
        ast.append(getIndentation());
        if(ctx.SHORT() != null || ctx.INT16() != null || ctx.INT8() != null){
            ast.append(ctx.getText());
        }
        else if(ctx.LONG() != null || ctx.INT32() != null){
            ast.append(ctx.getText());
        }
        else if(ctx.LONG().size() == 2 || ctx.INT64() != null){
            ast.append(ctx.getText());
        }
        else {
            // 如果既不是 short 也不是 int16 也不是 long 也不是 int32 也不是 long long 也不是 int64，抛出错误
            throw new IllegalStateException("Unknown signed_int context");
        }
        level--;
        return "";
    }
    /**
     * unsigned_int -> (“unsigned”“short”| “uint16”)
     *    | (“unsigned”“long”| “uint32”)
     *    | (“unsigned” “long” “long” | “uint64”)
     *    | “uint8”
     */
    @Override public String visitUnsigned_int(MIDLGrammar.Unsigned_intContext ctx) {
        level++;
        ast.append(getIndentation());
        if(ctx.UNSIGNED() != null && ctx.SHORT() != null || ctx.UINT16() != null || ctx.UINT8() != null){
            ast.append(ctx.getText());
        }
        else if(ctx.UNSIGNED() != null && ctx.LONG() != null || ctx.UINT32() != null){
            ast.append(ctx.getText());
        }
        else if(ctx.UNSIGNED() != null && ctx.LONG().size() == 2 || ctx.UINT64() != null){
            ast.append(ctx.getText());
        }
        else {
            // 如果既不是 unsigned short 也不是 uint16 也不是 unsigned long 也不是 uint32 也不是 unsigned long long 也不是 uint64，抛出错误
            throw new IllegalStateException("Unknown unsigned_int context");
        }
        level--;
        return "";
    }
    /**
     * declarators -> declarator {“,” declarator }
     *
     */
    @Override public String visitDeclarators(MIDLGrammar.DeclaratorsContext ctx) {
        // 增加缩进
        level++;
        // 遍历所有的 declarator 节点
        List<MIDLGrammar.DeclaratorContext> declarators = ctx.declarator();
        for (int i = 0; i < declarators.size(); i++) {
            // 添加 declarator 节点
            visitDeclarator(declarators.get(i));
            // 如果不是最后一个 declarator，添加逗号
            if (i < declarators.size() - 1) {
                ast.append(", ");
            }
        }
        // 减少缩进
        level--;
        return "";
    }
    /**
     * declarator -> simple_declarator | array_declarator
     *
     */
    @Override public String visitDeclarator(MIDLGrammar.DeclaratorContext ctx) {
        level++;
        // 如果是 simple_declarator，递归调用 visitSimple_declarator 方法
        if (ctx.simple_declarator() != null) {
            visitSimple_declarator(ctx.simple_declarator());
        } else if (ctx.array_declarator() != null) {
            // 如果是 array_declarator，递归调用 visitArray_declarator 方法
            visitArray_declarator(ctx.array_declarator());
        } else {
            // 如果既不是 simple_declarator 也不是 array_declarator，抛出错误
            throw new IllegalStateException("Unknown declarator context");
        }
        level--;
        return "";
    }
    /**
     * simple_declarator -> ID [“=” or_expr]
     *
     */
    @Override public String visitSimple_declarator(MIDLGrammar.Simple_declaratorContext ctx) {
        level++;
        // 添加 ID
        ast.append(getIndentation());
        ast.append(ctx.ID().getText());
        // 如果有 =，添加 = 和 or_expr
        if (ctx.EQUAL() != null) {
            ast.append(" = ");
            visitOr_expr(ctx.or_expr());
        }
        level--;
        return "";
    }
    /**
     * array_declarator -> ID “[” or_expr “]” [“=” exp_list ]
     *
     */
    @Override public String visitArray_declarator(MIDLGrammar.Array_declaratorContext ctx) {
        level++;
        ast.append(getIndentation());
        // 添加 ID 和 [
        ast.append(ctx.ID().getText()).append(" [");
        // 添加 or_expr
        visitOr_expr(ctx.or_expr());
        // 添加 ]
        ast.append("]");
        // 如果有 =，添加 = 和 exp_list
        if (ctx.EQUAL() != null) {
            ast.append(" = ");
            visitExp_list(ctx.exp_list());
        }
        level--;
        return "";
    }
    /**
     * exp_list -> “[” or_expr { “,”or_expr } “]”
     *
     */
    @Override public String visitExp_list(MIDLGrammar.Exp_listContext ctx) {
        level++;
        ast.append(getIndentation());
        // 添加 [
        ast.append("[");
        // 遍历所有的 or_expr 节点
        List<MIDLGrammar.Or_exprContext> orExprs = ctx.or_expr();
        for (int i = 0; i < orExprs.size(); i++) {
            // 添加 or_expr 节点
            visitOr_expr(orExprs.get(i));
            // 如果不是最后一个 or_expr，添加逗号
            if (i < orExprs.size() - 1) {
                ast.append(", ");
            }
        }
        // 添加 ]
        ast.append("]");
        level--;
        return "";
    }
    /**
     * or_expr -> xor_expr {“|” xor_expr }
     *
     */
    @Override public String visitOr_expr(MIDLGrammar.Or_exprContext ctx) {
        level++;
        ast.append(getIndentation());
        // 遍历所有的 xor_expr 节点
        List<MIDLGrammar.Xor_exprContext> xorExprs = ctx.xor_expr();
        for (int i = 0; i < xorExprs.size(); i++) {
            // 添加 xor_expr 节点
            visitXor_expr(xorExprs.get(i));
            // 如果不是最后一个 xor_expr，添加 |
            if (i < xorExprs.size() - 1) {
                ast.append(" | ");
            }
        }
        level--;
        return "";
    }
    /**
     * xor_expr -> and_expr {“^” and_expr }
     *
     */
    @Override public String visitXor_expr(MIDLGrammar.Xor_exprContext ctx) {
        level++;
        ast.append(getIndentation());
        // 遍历所有的 xor_expr 节点
        for(MIDLGrammar.And_exprContext and_expr : ctx.and_expr()){
            // 添加 and_expr 节点
            visitAnd_expr(and_expr);
            // 如果不是最后一个 and_expr，添加 ^
            if(and_expr != ctx.and_expr(ctx.and_expr().size()-1)){
                ast.append(" ^ ");
            }
        }
        level--;
        return "";
    }
    /**
     * and_expr -> shift_expr {“&”shift_expr }
     *
     */
    @Override public String visitAnd_expr(MIDLGrammar.And_exprContext ctx) {
        level++;
        ast.append(getIndentation());
        // 遍历所有的 shift_expr 节点
        for(MIDLGrammar.Shift_exprContext shift_expr : ctx.shift_expr()){
            // 添加 shift_expr 节点
            visitShift_expr(shift_expr);
            // 如果不是最后一个 shift_expr，添加 &
            if(shift_expr != ctx.shift_expr(ctx.shift_expr().size()-1)){
                ast.append(" & ");
            }
        }
        level--;
        return "";
    }
    /**
     * shift_expr -> add_expr { ( “<<” | “>>” ) add_expr }
     */
    @Override public String visitShift_expr(MIDLGrammar.Shift_exprContext ctx) {
        level++;
        ast.append(getIndentation());
        // 遍历所有的 add_expr 节点
        for(MIDLGrammar.Add_exprContext add_expr : ctx.add_expr()){
            // 添加 add_expr 节点
            visitAdd_expr(add_expr);
            // 如果不是最后一个 add_expr，添加 << 或 >>
            if(add_expr != ctx.add_expr(ctx.add_expr().size()-1)){
                if(ctx.OSTREAM() != null){
                    ast.append(" << ");
                }
                else if(ctx.ISTREAM() != null){
                    ast.append(" >> ");
                }
            }
        }
        level--;
        return "";
    }
    /**
     * add_expr -> mult_expr { (“+” | “-”) mult_expr }
     *
     */
    @Override public String visitAdd_expr(MIDLGrammar.Add_exprContext ctx) {
        level++;
        ast.append(getIndentation());
        // 遍历所有的 mult_expr 节点
        for(MIDLGrammar.Mult_exprContext mult_expr : ctx.mult_expr()){
            // 添加 mult_expr 节点
            visitMult_expr(mult_expr);
            // 如果不是最后一个 mult_expr，添加 + 或 -
            if(mult_expr != ctx.mult_expr(ctx.mult_expr().size()-1)){
                if(ctx.PLUS() != null){
                    ast.append(" + ");
                }
                else if(ctx.MINUS() != null){
                    ast.append(" - ");
                }
            }
        }
        level--;
        return "";
    }
    /**
     * mult_expr -> unary_expr { (“*” |“/”|“%”) unary_expr }
     *
     */
    @Override public String visitMult_expr(MIDLGrammar.Mult_exprContext ctx) {
        level++;
        ast.append(getIndentation());
        // 遍历所有的 unary_expr 节点
        for(MIDLGrammar.Unary_exprContext unary_expr : ctx.unary_expr()){
            // 添加 unary_expr 节点
            visitUnary_expr(unary_expr);
            // 如果不是最后一个 unary_expr，添加 * 或 / 或 %
            if(unary_expr != ctx.unary_expr(ctx.unary_expr().size()-1)){
                if(ctx.MULTIPLICATION() != null){
                    ast.append(" * ");
                }
                else if(ctx.DIVISION() != null){
                    ast.append(" / ");
                }
                else if(ctx.ROUNDING() != null){
                    ast.append(" % ");
                }
            }
        }
        level--;
        return "";
    }
    /**
     * unary_expr -> [“-”| “+” | “~”] literal
     *
     */
    @Override public String visitUnary_expr(MIDLGrammar.Unary_exprContext ctx) {
        level++;
        ast.append(getIndentation());
        // 如果有 - 或 + 或 ~，添加到 AST 中
        if (ctx.MINUS() != null) {
            ast.append("-");
        } else if (ctx.PLUS() != null) {
            ast.append("+");
        } else if (ctx.NOR() != null) {
            ast.append("~");
        }
        // 添加 literal 节点
        visitLiteral(ctx.literal());
        level--;
        return "";
    }
    /**
     * literal -> INTEGER | FLOATING_PT | CHAR | STRING | BOOLEAN
     *
     */
    @Override public String visitLiteral(MIDLGrammar.LiteralContext ctx) {
        level++;
        // 如果是 INTEGER，直接添加到 AST 中
        if (ctx.INTEGER() != null) {
            ast.append(ctx.INTEGER().getText());
        } else if (ctx.FLOATING_PT() != null) {
            // 如果是 FLOATING_PT，直接添加到 AST 中
            ast.append(ctx.FLOATING_PT().getText());
        } else if (ctx.CHARRegular() != null) {
            // 如果是 CHAR，直接添加到 AST 中
            ast.append(ctx.CHARRegular().getText());
        } else if (ctx.STRINGRegular() != null) {
            // 如果是 STRING，直接添加到 AST 中
            ast.append(ctx.STRINGRegular().getText());
        } else if (ctx.BOOLEANRegular() != null) {
            // 如果是 BOOLEAN，直接添加到 AST 中
            ast.append(ctx.BOOLEANRegular().getText());
        } else {
            // 如果既不是 INTEGER 也不是 FLOATING_PT 也不是 CHAR 也不是 STRING 也不是 BOOLEAN，抛出错误
            throw new IllegalStateException("Unknown literal context");
        }
        level--;
        return "";
    }

}
