package DynamicProgramming;

import java.util.*;

public class CutRod {
    /* Normal Recursive Cutting */
    public static int cutRod(int[] prices, int n) {
        if (n == 0) {
            return 0;
        }
        int q = -100000;
        for (int i = 0; i < n; i++) {
            q = Math.max(q, prices[i] + cutRod(prices, n - i));
        }
        return q;
    }

    /* Memoized Cutting */
    public static int memoizedCutRod(int[] prices, int n) {
        int[] dtable = new int[n];
        for (int i = 0; i < n; i++) {
            dtable[i] = -1;
        }
        return memoizedCutRodAux(prices, n, dtable);
    }

    /* Memoized version of cutrod */
    public static int memoizedCutRodAux(int[] prices, int n, int[] dtable) {
        int q = -100000;
        if (dtable[n] >= 0) {
            return dtable[n];
        }
        if (n == 0) {
            q = 0;
        } else {
            for (int i = 0; i < n; i++) {
                q = Math.max(q, prices[i] + memoizedCutRodAux(prices, n - i, dtable));
            }
        }
        dtable[n] = q;
        return q;
    }

    public static int bottomUpCutRod(int[] prices, int n) {
        int[] dtable = new int[n];
        dtable[0] = 0;
        for (int j = 0; j < n; j++) {
            int q = -1000000;
            for (int i = 0; i < j; i++) {
                q = Math.max(q, prices[i] + dtable[j - i]);
            }
            dtable[j] = q;
        }
        return dtable[n];
    }


}
