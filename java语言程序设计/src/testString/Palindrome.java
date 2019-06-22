package testString;

public class Palindrome {
    public static int getLongestPalindarome(String string, int n) {
        if (string == null) {
            return -1;
        }
        int length = 0;//记录最长的长度
        int startIndex = -1;
        /*
        1.使用动态规划方法
         */
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = 1;

            if (string.charAt(i) == string.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                length = 2;
                startIndex = i;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (string.charAt(i) == string.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    startIndex = i;
                    length = len;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int res = getLongestPalindarome("abba",4);
        System.out.println(res);
    }
}
