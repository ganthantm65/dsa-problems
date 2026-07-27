package intervals;

public class NonOverlapping {
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        NonOverlapping nonOverlapping=new NonOverlapping();
        int res = nonOverlapping.countOverlap(intervals);
        System.out.print(res);        
    }
    public int countOverlap(int[][] intervals){
        int count=0;
        sortIntervals(intervals);
        int  end=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(end>intervals[i][0]){
                count++;
            }else{
                end=intervals[i][1];
            }
        }
        return count;
    }
    public void sortIntervals(int[][] intervals){
        for(int i=0;i<intervals.length;i++){
            for(int j=i;j<intervals.length;j++){
                if(intervals[i][1]>intervals[j][1]){
                    int[] temp=intervals[i];
                    intervals[i]=intervals[j];
                    intervals[j]=temp;
                }
            }
        }
    }
}
