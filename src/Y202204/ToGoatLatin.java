package Y202204;

/**
 * @ClassName: ToGoatLatin
 * @Description: TODO
 * @Author sunsl
 * @Date 2022/4/21 19:03
 * @Version 1.0
 */
public class ToGoatLatin {
    class Solution {
        public String toGoatLatin(String sentence) {
            int len = sentence.length();
            int i = 0;
            String a = "a";
            StringBuilder sb = new StringBuilder();
            while (i < len) {
                int j = i;
                while (j < len && sentence.charAt(j) != ' ') {
                    j++;
                }
                // 跳出循环说明j指向了空格或者末尾
                if ("aeiou".indexOf(String.valueOf(sentence.charAt(i)).toLowerCase()) >= 0) {
                    sb.append(sentence.substring(i,j))
                            .append("ma");
                } else {
                    sb.append(sentence.substring(i+1, j))
                            .append(sentence.charAt(i))
                            .append("ma");
                }
                sb.append(a);
                a += "a";
                i = j + 1;//到下一个单词
                if (i < len) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
    }
}
