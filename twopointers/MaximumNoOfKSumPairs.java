package twopointers;

import java.util.Arrays;

public class MaximumNoOfKSumPairs {
    public int findMaxKSumPairs(int[] nums,int k){
        Arrays.sort(nums);
        int l=0,r=nums.length-1;
        int count=0;
        while(l<r){
            int sum=nums[l]+nums[r];
            if(sum==k){
                count++;
                l++;
                r--;
            }else if(sum>k){
                r--;
            }else{
                l++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        MaximumNoOfKSumPairs obj=new MaximumNoOfKSumPairs();
        int[] arr={3,1,3,4,3};
        int k=5;
        int result=obj.findMaxKSumPairs(arr,k);
        System.out.println(result);
    }
}
