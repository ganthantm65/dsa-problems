package zohosetfour;

import java.util.Arrays;

public class ArrangeEvensOdds {
    static void arrangeEvenOdds(int[] arr){
        int l=0;
        for (int r = 0; r < arr.length; r++) {
            if(arr[r]%2==0){
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
            }
        }
    }

    static void usingTwoPointer(int[] arr){
        int l=0,r=arr.length-1;

        while (l<r) {
            while (l<r && arr[l]%2==0) {
                l++;
            }
            while (l<r && arr[r]%2!=0) {
                r--;
            }
            if(l<r){
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
                r--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,15,6};
        usingTwoPointer(arr);
        System.out.print(Arrays.toString(arr));
    }
}
