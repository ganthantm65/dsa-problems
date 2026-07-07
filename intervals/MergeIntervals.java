package intervals;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] res = mergeIntervals.merge(intervals);
        for(int i=0;i<res.length;i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }
    public int[][] merge(int[][] intervals) {
        sortIntervals(intervals);
        int[][] res=new int[intervals.length][2];
        int k=0;
        res[k++]=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=res[k-1][1]){
                res[k - 1][1] = Math.max(res[k - 1][1], intervals[i][1]);
            }else{
                res[k++]=intervals[i];
            }
        }
        return Arrays.copyOf(res,k);
    }
    public void sortIntervals(int[][] intervals){
        for(int i=0;i<intervals.length;i++){
            for(int j=i;j<intervals.length;j++){
                if(intervals[i][0]>intervals[j][0]){
                    int[] temp=intervals[i];
                    intervals[i]=intervals[j];
                    intervals[j]=temp;
                }
            }
        }
    }
}
