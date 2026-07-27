package graph.dijkstra;

public class MinimumDistanceToLastCell {
    static int findMinimumLastDist(int[][] cost){
        int n=cost.length;
        int m=cost[0].length;
        int[][] dp=new int[n][m];

        dp[0][0]=cost[0][0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=cost[i-1][0]+cost[i][0];
        }

        for (int i = 1; i < dp.length; i++) {
            dp[0][i]=cost[0][i-1]+cost[0][i];
        }

        for (int j = 1; j < dp.length; j++) {
            for (int j2 = 1; j2 < dp.length; j2++) {
                dp[j][j2]=cost[j][j2]+Math.min(dp[j-1][j2], 
                    Math.min(dp[j][j2-1],dp[j-1][j2-1])
                );
            }
        }

        return dp[n-1][m-1];
    }
    public static void main(String[] args) {
        int[][] cost={
            {1,2,3},
            {4,8,2},
            {1,5,3}
        };
        System.out.println(findMinimumLastDist(cost));
    }
}
