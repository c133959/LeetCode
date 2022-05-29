package may;

/**
 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 F(0) = 0, F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class Fib {
    class Solution {
        public int fib(int n) {
            final int MOD = 1000000007;
            int f0 = 0, f1 = 0, res = 1;
            if (n < 2) {
                return n;
            }

            for (int i = 2; i <= n; i++) {
                f0 = f1;
                f1 = res;
                res = (f0 + f1) % MOD;
            }
            return res;
        }
    }
}
