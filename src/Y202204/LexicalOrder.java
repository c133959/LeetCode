package Y202204;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> ret = new ArrayList<>();
            int number = 1;
            for (int i = 1; i <= n; i++) {
                ret.add(number);//字典序开头最小
                // 寻找后序
                if (number * 10 <= n) {
                    // 如果不越界，添0
                    number *= 10;
                } else {
                    while (number + 1 > n || number % 10 == 9) {
                        // 回退到前一位，找下一个数的后续
                        number /= 10;
                    }
                    //回退到前一位
                    number++;
                }
            }
            return ret;
        }
    }
}
