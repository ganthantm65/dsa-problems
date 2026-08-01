package zohoprep;

public class FindPivotIndex {
    static int findPivotIndex(int[] arr){
        int total_sum=0;
        for (int i = 0; i < arr.length; i++) {
            total_sum+=arr[i];
        }
        int left_sum=0;
        for (int i = 0; i < arr.length; i++) {
            int right_sum=total_sum-left_sum-arr[i];
            if(right_sum==left_sum){
                return i;
            }
            left_sum+=arr[i];
        }

        return -1;
    }
    public static void main(String[] args){
        int[] arr={1,7,3,6,5,6};
        System.out.print(findPivotIndex(arr));
    }
}
