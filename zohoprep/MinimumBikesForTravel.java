package zohoprep;

import java.util.Arrays;

public class MinimumBikesForTravel {
    static int countMinimumBikes(int[] weights,int threshold){
        int count=0;
        Arrays.sort(weights);
        int l=0,r=weights.length-1;
        while (l<=r) {
            count++;
            if(weights[l]+weights[r]<=threshold){
                l++;
                r--;
            }else {
                r--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.print(countMinimumBikes(new int[]{90,20,30,40,50}, 100));
    }
}
