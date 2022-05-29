package Index;

/**
 5. 最长回文子串
 */
public class LongestPalindrome {
    class Solution {
        public String longestPalindrome(String s) {

            int len = s.length();
            if (len <= 1) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            boolean dp[][] = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;//因为i->i为单个字符，肯定为回文字符串
            }

            char[] chars = s.toCharArray();
            //枚举子串长度
            for (int L = 2; L <= len; L++) {
                // 左边界i
                for (int i = 0; i < len; i++) {
                    int j = L + i - 1;
                    if (j >= len) {
                        break;
                    }

                    if (chars[i] == chars[j]) {
                        // 如果子串长度为1,2,3，则必定为回文字符串
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];//由其子串决定
                        }
                    } else {
                        dp[i][j] = false;
                    }

                    // 记录最长子串相关参数
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;//长度
                        begin = i;//起始坐标
                    }
                }
            }
            return s.substring(begin, begin + maxLen);//左闭右开
        }
    }
}
