package may;

import java.util.Arrays;

/**
 * @ClassName: FindSubstringInWraproundString
 * @Description: 467. 环绕字符串中唯一的子字符串
 * @Author sunsl
 * @Date 2022/5/25 22:22
 * @Version 1.0
 */
public class FindSubstringInWraproundString {
    class Solution {
        public int findSubstringInWraproundString(String p) {
            //p 中以字符 c 结尾且在 s 中的子串有 dp[c] 个。
            // 例如 dp[‘d’]=3 表示子串 “bcd”、“cd” 和 “d”。
            int[] dp = new int[26];
            int k = 0;
            for (int i = 0; i < p.length(); i++) {
                if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {// 循环字符串相邻的字符
                    k++;
                } else {
                    k = 1;
                }

                dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);//更新最大值

            }
            return Arrays.stream(dp).sum();

        }
    }
}
