public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4,5};

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int res = removeDuplicates.removeDuplicates(nums);
        System.out.println(res);

        for(int i=0;i<res;i++){
            System.out.print(nums[i]+" ");
        }
    }
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[index]!=nums[i]){
                nums[++index]=nums[i];
            }
        }
        return index+1;
    }
}
