package twopointers;

public class TrappingRainWater {
    public int trap(int[] arr){
        int left=0,right=arr.length-1;
        int leftMax=0,rightMax=0;
        int water=0;
        while(left<right){
            if(arr[left]<arr[right]){
                if(arr[left]>=leftMax){
                    leftMax=arr[left];
                }else{
                    water+=leftMax-arr[left];
                }
                left++;
            }else{
                if(rightMax<=arr[right]){
                    rightMax=arr[right];
                }else{
                    water+=rightMax-arr[right];
                }
            }
        }
        return water;
    }
}
