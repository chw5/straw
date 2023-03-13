package leetcode;

/**
 * @Author : wzq
 * @Date : 2023/3/10
 * @Version : 1.0
 * @Description : 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/?favorite=2cktkvj
 **/
public class T5 {

    public static void main(String[] args) {
        String palindrome = T5.longestPalindrome2("bb");
        System.out.println(palindrome);
    }

    /**
     * 动态规划求解：把问题拆成子问题，保留求解子问题的结果
     * i为回文串左指标，j为回文串右游标
     */
    public static String longestPalindrome(String s) {

        int length = s.length();

        //长度小于2的字符串为回文串
        if (length < 2){
            return s;
        }
        //dp[][]表示是否是回文串
        boolean[][] dp = new boolean[length][length];

        //初始化长度为1的串是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int max = 1;//一个字符的是回文串
        int begin = 0;//结果字串的开始位置
        for (int L = 2; L <= length; L++) {

            for (int i = 0; i < length; i++) {
                int j = L + i - 1;

                if (j >= length) {
                    break;
                }

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {//两个字符的是回文串
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = Math.max(max, j - i + 1);
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }


    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s){
        if (s == null || s.length() < 1) return "";
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {

            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start,end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
