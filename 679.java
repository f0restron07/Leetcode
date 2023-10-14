import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static final double EPSILON = 1e-6;
    
    public boolean judgePoint24(int[] nums) {
        List<Double> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add((double) num);
        }
        return dfs(numbers);
    }

    private boolean dfs(List<Double> numbers) {
        if (numbers.size() == 0) return false;
        if (numbers.size() == 1) return Math.abs(numbers.get(0) - 24) < EPSILON;

        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> newNumbers = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            newNumbers.add(numbers.get(k));
                        }
                    }
                    for (double result : computeResults(numbers.get(i), numbers.get(j))) {
                        newNumbers.add(result);
                        if (dfs(newNumbers)) return true;
                        newNumbers.remove(newNumbers.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    private List<Double> computeResults(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.addAll(Arrays.asList(a + b, a - b, b - a, a * b));
        if (b != 0) results.add(a / b);
        if (a != 0) results.add(b / a);
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(solution.judgePoint24(new int[]{1, 2, 1, 2}));
    }
}
