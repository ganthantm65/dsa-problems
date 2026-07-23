public class LongestSubarrayOf1 {
    public int longestSubarray(int[] nums){
        int l=0,r=0;
        int zeroCount=0;
        int maxLength=0;
        while(r<nums.length){
            if(nums[r]==0){
                zeroCount++;
            }
            while(zeroCount>1){
                if(nums[l]==0){
                    zeroCount--;
                }
                l++;
            }
            maxLength=Math.max(maxLength,r-l);
            r++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubarrayOf1 obj=new LongestSubarrayOf1();
        int[] arr={1,0,1,0,1,1};
        int result=obj.longestSubarray(arr);
        System.out.println(result);
    }
}
