package patterns;

public class StarDot {
    public static void main(String[] args){
        int n=10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minDist=Math.min(Math.min(i, j),Math.min(n-i-1, n-j-1));
                if(minDist%2==0){
                    System.out.print("* ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}