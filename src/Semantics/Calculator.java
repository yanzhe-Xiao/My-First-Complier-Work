package Semantics;
import java.util.ArrayList;

/**
 * 计算字符串算式子(右端开始计算)
 *
 * @author Spring
 * @version 1.0.1
 * @classname Semantics.Calculator
 * @date 2024/06/02
 */
public class Calculator {
    public static ArrayList<String> exps= new ArrayList<String>();;
    public static ArrayList<String> nums= new ArrayList<String>();;


    /**
     * 单位运算符计算
     *
     * @param input 输入
     * @param exp   exp
     * @param type  类型
     * @return {@link String }
     */
    public static String caluatorAns(String input,String exp,String type){
        if(!type.equals("INTEGER")){
            return "TYPE_ERROR";
        }
        int a = Integer.parseInt(input);
        switch (exp){
            case "+": return Integer.toString(a);
            case "-": return Integer.toString(-a);
            case "~": return Integer.toString(~a);
            default:return "TYPE_ERROR";
        }
    }

    /**
     * 双位运算符计算
     *
     * @param input1 input1
     * @param input2 input2
     * @param exp    exp
     * @param type   类型
     * @param pos1   位置1
     * @param pos2   pos2
     * @return {@link String }
     */
    public static String caluatorAns(String input1, String input2, String exp, ArrayList<String> type,int pos1,int pos2){
        String temp;
        boolean isFloat = false;
        int a = 0,b = 0;
        float c = 0,d = 0;
        if(type.get(pos1).equals("INTEGER")){
            a = Integer.parseInt(input1);
        }
        else if(type.get(pos1).equals("FLOAT_PT")){
            c = Float.parseFloat(input1);
            isFloat = true;
        }
        else{
            temp = "TYPE_ERROR";
            return temp;
        }
        if(type.get(pos2).equals("INTEGER") ){
            b = Integer.parseInt(input2);
        }
        else if(type.get(pos2).equals("FLOAT_PT")){
            d = Float.parseFloat(input2);
            isFloat = true;
        }
        else{
            temp = "TYPE_ERROR";
            return temp;
        }
        if(isFloat){
            type.set(pos1,"FLOAT_PT");
            type.set(pos2,"FLOAT_PT");
            c = Float.parseFloat(input1);
            d = Float.parseFloat(input2);
            switch (exp){
                case "+":
                    return Float.toString(c+d);
                case "-":
                    return Float.toString(c-d);
                case "*":
                    return Float.toString(c*d);
                case "/":
                    return Float.toString(c/d);
                default: return "TYPE_ERROR";
            }
        }
        else {
            switch (exp) {
                case "+":
                    return Integer.toString(a + b);
                case "-":
                    return Integer.toString(a - b);
                case "*":
                    return Integer.toString(a * b);
                case "/":
                    return Integer.toString(a / b);
                case "<<":
                    return Integer.toString(a << b);
                case ">>":
                    return Integer.toString(a >> b);
                case "|":
                    return Integer.toString(a | b);
                case "^":
                    return Integer.toString(a ^ b);
                case "%":
                    return Integer.toString(a % b);
                case "&":
                    return Integer.toString(a & b);
                default:
                    return "TYPE_ERROR";
            }
        }

    }

}


