class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        
        while (low < high) {
            int mid = (low + high) / 2;
            
            if (countLessEqual(mid, m, n) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return high;
    }
    
    // Helper function to count the numbers less than or equal to val in the multiplication table
    private int countLessEqual(int val, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(val / i, n); // count the numbers in the i-th row that are <= val
        }
        return count;
    }
}
