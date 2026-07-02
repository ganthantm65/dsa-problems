package recursion;

import java.util.*;
public class CombinationSumII{
   public static void main(String args[]){
   	int candidates[]={10,1,2,7,6,1,5};
   	int target=8;
   	List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,target,new ArrayList<>(),res,candidates);
        System.out.println(res.toString());
    }
    static void findCombinations(int ind,int target ,List<Integer> arr,List<List<Integer>>res,int[] cand){
        if(target==0){
            res.add(new ArrayList<>(arr));
            return;
        }
        
        for(int i=ind;i<cand.length;i++){
            if(ind<i && cand[i]==cand[i-1] ){
                continue;
            }
            if(cand[i]>target){
                break;
            }
            arr.add(cand[i]);
            findCombinations(i+1,target-cand[i],arr,res,cand);
            arr.remove(arr.size()-1);
        }
    }
}
