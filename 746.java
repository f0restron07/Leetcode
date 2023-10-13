class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        
        int n = cost.length;
        // Create an array to store the minimum cost to reach each step.
        int[] dp = new int[n + 1];
        
        // Base conditions: The cost to reach step 0 or 1 is the cost of that step.
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        // Loop from step 2 to the top of the staircase.
        for (int i = 2; i < n; i++) {
            // The cost to reach the current step is the cost of that step plus 
            // the minimum of the costs to reach the previous two steps.
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        // The minimum cost to reach the top is the minimum of the costs 
        // to reach the last two steps, because we can take one or two steps to reach the top.
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
