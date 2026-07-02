package recursion;

import java.util.*;

public class Permutation{
   public static void main(String[] args){
   	int nums[]={1,2,3};
   	List<List<Integer>> res=new ArrayList<>();
        int[] map=new int[nums.length];
        iterate(new ArrayList<>(),map,nums,res);
        System.out.println(res.toString());
   }
   static void iterate(List<Integer> ds,int[] map,
    int[] nums,List<List<Integer>> res){
        if(ds.size()==nums.length){
            res.add(new ArrayList(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(map[i]!=1){
                ds.add(nums[i]);
                map[i]=1;
                iterate(ds,map,nums,res);
                ds.remove(ds.size()-1);
                map[i]=0;
            }
        }
    }
}
