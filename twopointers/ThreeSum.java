package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int num1=nums[i];
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=num1+nums[l]+nums[r];
                if(sum>0){
                    r--;
                }else if(sum<0){
                    l++;
                }else if(sum==0){
                    List<Integer> arr=new ArrayList<>();
                    arr.add(num1);
                    arr.add(nums[l]);
                    arr.add(nums[r]);
                    result.add(arr);
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }while(l<r && nums[r]==nums[r+1]){
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum obj=new ThreeSum();
        int[] arr={-1,0,1,2,-1,-4};
        List<List<Integer>> result=obj.threeSum(arr);
        System.out.println(result);
    }
}
