package may;

/**
 * @ClassName: FindClosest
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/27 22:13
 * @Version 1.0
 */
public class FindClosest {

    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            int len = words.length;
            int ans = len;
            int index1 = -1, index2 = -1;
            for (int i = 0; i < len; i++) {
                String word = words[i];
                if (word.equals(word1)) {
                    index1 = i;
                } else if (word2.equals(word)) {
                    index2 = i;
                }
                // 当下标都存在时，计算最小间距
                if (index1 >= 0 && index2 >= 0) {
                    ans = Math.min(ans, Math.abs(index1 - index2));
                }
            }
            return ans;
        }
    }

}
