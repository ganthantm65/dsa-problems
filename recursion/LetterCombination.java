package recursion;

import java.util.*;

public class LetterCombination{
   private static Map<Character,String> phoneMap=new HashMap<>();
   public static void main(String args[]){
   	String digits="287";
   	List<String> res=new ArrayList<>();
   	
   	phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(0,"",digits,res);

       System.out.println(res.toString());
   }
   static void backtrack(int ind,String curr,String digits,List<String> res){
   	if(curr.length()==digits.length()){
   	     res.add(curr);
   	     return;
   	}
   	for(char c:phoneMap.get(digits.charAt(ind)).toCharArray()){
   	     backtrack(ind+1,curr+c,digits,res);
   	}
   }
}
   	
