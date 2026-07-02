package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public static void main(String[] args){
        List<List<String>> res=new ArrayList<>();
        partitionPalindrome(0, new ArrayList<String>(), res, "aab");
        System.out.println(res.toString());
    }

    static void partitionPalindrome(int i,List<String> arr,List<List<String>> res,String str){
        if(i==str.length()){
            res.add(new ArrayList<>(arr));
        }
        for(int j=i;j<str.length();j++){
            if(isPalindrome(i,j, str)){
                arr.add(str.substring(i,j+1));
                partitionPalindrome(j+1, arr, res, str);
                arr.remove(arr.size()-1);
            }
        }
    }
    static boolean isPalindrome(int i,int j,String str){
        while (i<=j) {
            if (str.charAt(i)!=str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
