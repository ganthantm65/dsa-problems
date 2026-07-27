package zohosetthree;

import java.util.Arrays;

public class SortOddEven {
    static void sortOddEven(int[] arr){
        int[] odd=new int[(arr.length+1)/2];
        int[] evens=new int[arr.length/2];
        int k=0,j=0;
        for (int l = 0; l < arr.length; l++) {
            if (l%2==0) {
                odd[k++]=arr[l];
            }else{
                evens[j++]=arr[l];
            }
        }

        Arrays.sort(odd);
        Arrays.sort(evens);

        int first=0;
        int last=odd.length-1;

        for (int i = 0; i < arr.length; i++) {
            if (i%2==0) {
                arr[i]=odd[last--];
            }else{
                arr[i]=evens[first++];
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};

        sortOddEven(arr);

        System.out.println(Arrays.toString(arr));
    }
}
