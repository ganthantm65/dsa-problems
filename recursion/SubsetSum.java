package recursion;

import java.util.*;

public class SubsetSum{
    public static void main(String[] args){
    	int arr[]={3,1,2};
    	List<Integer> res=new ArrayList<>();
    	findSum(0,0,res,arr);
    	System.out.println(res.toString());
    }
    static void findSum(int ind,int sum,List<Integer> res,int[] arr){
    	if(ind==arr.length){
    	    res.add(sum);
    	    return;
    	}
    	findSum(ind+1,sum+arr[ind],res,arr);
    	findSum(ind+1,sum,res,arr);
    }
}
