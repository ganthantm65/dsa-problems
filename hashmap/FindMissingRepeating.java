package hashmap;

import java.util.Arrays;

public class FindMissingRepeating {
    static int[] findMissingRepeatingChars(int[] arr){
        int[] freq=new int[arr.length+1];
        int[] res=new int[2];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        for (int i = 1; i <= arr.length; i++) {
            if(freq[i]==0){
                res[0]=i;
            }
            if(freq[i]>1){
                res[1]=i;
            }
        }
        return res;
    }
    static int findMax(int[] arr){
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={2,2};
        System.out.println(Arrays.toString(findMissingRepeatingChars(arr)));
    }
}
