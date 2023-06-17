package leetcode;

public class SolutionDP {

    // DynamicProgramming

    // https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/569/
    public static int climbStairs(int n) {
        int dp[] = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 3; i <= 45; i++)
            dp[i] = dp[i - 2] + dp[i - 1];
        return dp[n];
    }
    
}
