package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args){
        List<String> res= new ArrayList<>();
        int n=3;
        backtracking(0,0,res,new StringBuilder(),n);
        System.out.print(res.toString());
    }
    static void backtracking(int open,int close,List<String> res,StringBuilder str,int n){
        if(str.length()==2*n){
            res.add(str.toString());
            return;
        }
        if(open<n){
            str.append('(');
            backtracking(open+1,close,res,str,n);
            str.deleteCharAt(str.length()-1);
        }
        if(close<open){
            str.append(')');
            backtracking(open,close+1,res,str,n);
            str.deleteCharAt(str.length()-1);
        }
    }
}
