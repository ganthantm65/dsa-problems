
public class MinimumSumSubarray {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int sum=0;
        int minLength=Integer.MAX_VALUE;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>=target){
                minLength=Math.min(minLength,r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
    public static void main(String[] args) {
        MinimumSumSubarray obj=new MinimumSumSubarray();
        int[] arr={2,3,1,2,4,3};
        int target=7;
        int result=obj.minSubArrayLen(target,arr);
        System.out.println(result);
    }
}