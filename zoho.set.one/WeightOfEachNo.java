public class WeightOfEachNo {
    static void findWeights(int[] weights,int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (isPerfectSquare(nums[i])) {
                weights[nums[i]] += 5;
            }

            if (nums[i] % 4 == 0 && nums[i] % 6 == 0) {
                weights[nums[i]] += 4;
            }

            if (nums[i] % 2 == 0) {
                weights[nums[i]] += 3;
            }
        }
    }
    static boolean isPerfectSquare(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }
    static int finMaxInArray(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr={10,36,54,89,12};

        int n=finMaxInArray(arr);

        int[] weights=new int[n+1];

        findWeights(weights, arr);

        for (int i : arr) {
            System.out.println("Weight of "+i+" is "+weights[i]);
        } 
    }
}
