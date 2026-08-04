package zohoprep;

import java.util.Arrays;

public class SortElementBasedOnFreq {

    static int[] findMax(int[] arr) {
        int max = arr[0];
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return new int[]{max, maxIndex};
    }

    static int[] sortElements(int[] arr) {

        int[] res = new int[arr.length];

        int maxElement = findMax(arr)[0];

        int[] freq = new int[maxElement + 1];

        int maxFreq = 0;
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
            if (freq[arr[i]] > maxFreq) {
                maxFreq = freq[arr[i]];
                maxIndex = arr[i];
            }
        }

        int k = 0;

        while (k < arr.length && maxFreq != 0) {

            for (int i = 0; i < maxFreq; i++) {
                res[k++] = maxIndex;
            }

            freq[maxIndex] = 0;

            int[] temp = findMax(freq);
            maxFreq = temp[0];
            maxIndex = temp[1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};

        System.out.println(Arrays.toString(sortElements(arr)));
    }
}