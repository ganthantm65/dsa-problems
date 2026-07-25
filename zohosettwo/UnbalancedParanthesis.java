package zohosettwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class UnbalancedParanthesis {
    static String filterUnbalancedParanthesis(String str){
        Stack<Integer> stack=new Stack<>();
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push(i);
            }else if(str.charAt(i)==')'){
                if (!stack.isEmpty()) {
                    stack.pop();
                }else{
                    set.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }
        StringBuilder res=new StringBuilder();
        for (int i=0;i<str.length();i++) {
            if(!set.contains(i)){
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(filterUnbalancedParanthesis("((abc)((de))"));
    }
}
