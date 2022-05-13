package may;

/**
 * @ClassName: OneEditAway
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/5/13 21:30
 * @Version 1.0
 */
public class OneEditAway {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int first_len = first.length();
            int second_len = second.length();
            if (Math.abs(first_len - second_len) > 1) {
                return false;
            }

            int len = first_len - second_len;//1- first长 -1 second长 0- 一样长

            int i = 0 , j = 0 , count = 0;
            while (i < first_len && j < second_len) {
                if (first.charAt(i) != second.charAt(j)) {

                    if (len == 1) {
                        j--;
                    } else if (len == -1) {
                        i--;
                    }
                    count++;
                }
                i++;
                j++;
                if (count > 1) {
                    return false;
                }
            }
            return true;
        }
    }}
