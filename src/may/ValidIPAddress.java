package may;

import org.junit.Test;

/**
 468. 验证IP地址
 */
public class ValidIPAddress {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }

    class Solution {
        public String validIPAddress(String queryIP) {
            return isIPv4(queryIP) ? "IPv4" : isIPv6(queryIP) ? "IPv6" : "Neither";
        }


        /**
         * 判断是否为合法的IPv4地址
         * @param queryIP 待确认IP地址
         * @return 是否合法 合法-true，不合法-false
         */
        public boolean isIPv4(String queryIP) {
            String[] splits = queryIP.split("\\.");
            // 格式不符合
            if (splits.length != 4) {
                return false;
            }

            for (String part : splits) {
                // 长度不合规范
                if (part.length() == 0 || part.length() > 3) {
                    return false;
                }
                // 前置0不合法
                if (part.length() > 1 && part.charAt(0) == '0') {
                    return false;
                }
                // 地址范围不合法&非法字符
                int sum = 0;
                for (int i = 0; i < part.length(); i++) {
                    if (!Character.isDigit(part.charAt(i))) {
                        return false;
                    }
                    sum = sum * 10 + (part.charAt(i) - '0');
                    if (sum > 255) {
                        return false;
                    }
                }
            }
            return true;
        }


        /**
         * 判断是否为合法的IPv6地址
         * @param queryIP 待确认IP地址
         * @return 是否合法 合法-true，不合法-false
         */
        public boolean isIPv6(String queryIP) {
            String[] splits = queryIP.split(":", -1);//不丢弃最后一个空白字符
            // 格式不符合
            if (splits.length != 8) {
                return false;
            }

            for (String part : splits) {
                // 长度不合规范
                if (part.length() == 0 || part.length() > 4) {
                    return false;
                }

                // 非法字符
                for (int i = 0; i < part.length(); i++) {
                    part = part.toLowerCase();
                    if (!Character.isDigit(part.charAt(i)) &&
                            !(part.charAt(i) >= 'a' && part.charAt(i) <= 'f')) {
                        return false;
                    }
                }
            }
            return true;
        }

    }

}
