package twopointers;

public class MoveZeros {
    public void moveZeros(int[] nums){
        int l=0,r=0;
        while(r<nums.length){
            if(nums[r]!=0){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
            }
        }
    }
    public static void main(String[] args) {
        MoveZeros obj=new MoveZeros();
        int[] arr={0,1,0,3,12};
        obj.moveZeros(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
