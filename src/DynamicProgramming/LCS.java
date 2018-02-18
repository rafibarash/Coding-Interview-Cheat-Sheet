package DynamicProgramming;

// Given two strings, find the Longest Common Subsequence
public class LCS {
    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] A = new int[m + 1][n + 1];

        // Build matrix A in bottom up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    A[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    A[i][j] = A[i - 1][j - 1] + 1;
                } else {
                    A[i][j] = Math.max(A[i - 1][j], A[i][j - 1]);
                }
            }
        }

        return A[m][n]; // Longest common subsequence
    }
}
