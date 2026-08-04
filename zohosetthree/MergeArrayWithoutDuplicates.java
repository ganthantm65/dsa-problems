package zohosetthree;

import java.util.Arrays;

public class MergeArrayWithoutDuplicates {

    static int[] mergeArrays(int[] arr1, int[] arr2) {

        int[] res = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                if (k == 0 || res[k - 1] != arr1[i])
                    res[k++] = arr1[i];
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                if (k == 0 || res[k - 1] != arr2[j])
                    res[k++] = arr2[j];
                j++;
            }
            else {
                if (k == 0 || res[k - 1] != arr1[i])
                    res[k++] = arr1[i];
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            if (k == 0 || res[k - 1] != arr1[i])
                res[k++] = arr1[i];
            i++;
        }

        while (j < arr2.length) {
            if (k == 0 || res[k - 1] != arr2[j])
                res[k++] = arr2[j];
            j++;
        }

        return Arrays.copyOf(res, k);
    }

    

    public static void main(String[] args) {
        int[] arr1 = {2,3,4,5,6,7,8};
        int[] arr2 = {1,2,4,5,8,9};

        System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
    }
}