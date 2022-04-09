package Y202204;

public class ReachingPoints {

    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (tx > sx && ty > sy && tx != ty) {
                if (tx > ty) {
                    /**
                     * 推理：(3,5)->(3,x+3)->x=2->(3,2)
                     * (3, 100)-> (3,97)? no -> (3, 100%3=1)->(3,1)
                     */

                    tx %= ty;
                } else {
                    ty %= tx;
                }
            }
            // 跳出循环
            if (tx == sx && ty == sy) {
                return true;
            } else if (tx == sx) {
                return ty > sy && (ty - sy) % tx == 0;
            } else if (ty == sy) {
                return tx > sx && (tx - sx) % ty == 0;
            } else {
                return false;
            }
        }
    }
}
