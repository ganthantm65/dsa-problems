package zohosettwo;

import java.util.Stack;

public class ValidateExpression {
    static boolean isOperand(char c){
        return Character.isLetterOrDigit(c);
    }
    static boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/';
    }
    static boolean validateExpression(String exp){
        Stack<Character> stack=new Stack<>();
        boolean hasOperand=false;
        for (int i = 0; i < exp.length(); i++) {
            if(exp.charAt(i)=='('){
                stack.push(exp.charAt(i));
            }else if(exp.charAt(i)==')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }else if(isOperator(exp.charAt(i))){
                if(i==0 || i==exp.length()-1){
                    return false;
                }
                char left=exp.charAt(i-1);
                char right=exp.charAt(i+1);
                if (!(isOperand(left) || left == ')')) {
                    return false;
                }
                if (!(isOperand(right) || right == ')')) {
                    return false;
                }
            }else if(isOperand(exp.charAt(i))){
                hasOperand=true;
            }
        }
        return stack.isEmpty() && hasOperand;
    }
    public static void main(String[] args) {
        System.out.print(validateExpression("((()))"));
    }
}
