package DynamicProgramming;

public class MatrixChainMult {
    public static void matrixChainOrder(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n][n];
        int[][] s = new int[n - 1][n - 1];
        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }
        for (int l = 1; l < n; l++) {    // l is the chain length
            for (int i = 0; i < (n - l + 1); i++) {
                int j = i + l - 1;
                m[i][j] = 1000000000;
                for (int k = i; k < (j - 1); k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        // return m and s
    }

    public static void printOptimalParens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A");
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
