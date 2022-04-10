package Y202204;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseRepresentations {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            // 定义一个Map，存储字符和摩斯码的对应关系
            Map<Character, String> MORSE = new HashMap<>();
            Set<String> ret = new HashSet<>();
            MORSE.put('a', ".-");
            MORSE.put('b', "-...");
            MORSE.put('c', "-.-.");
            MORSE.put('d', "-..");
            MORSE.put('e', ".");
            MORSE.put('f', "..-.");
            MORSE.put('g', "--.");
            MORSE.put('h', "....");
            MORSE.put('i', "..");
            MORSE.put('j', ".---");
            MORSE.put('k', "-.-");
            MORSE.put('l', ".-..");
            MORSE.put('m', "--");
            MORSE.put('n', "-.");
            MORSE.put('o', "---");
            MORSE.put('p', ".--.");
            MORSE.put('q', "--.-");
            MORSE.put('r', ".-.");
            MORSE.put('s', "...");
            MORSE.put('t', "-");
            MORSE.put('u', "..-");
            MORSE.put('v', "...-");
            MORSE.put('w', ".--");
            MORSE.put('x', "-..-");
            MORSE.put('y', "-.--");
            MORSE.put('z', "--..");

            for (String str : words) {
                int len = str.length();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len; i++){
                    char c = str.charAt(i);
                    sb.append(MORSE.get(c));
                }
                ret.add(sb.toString());
            }
            return ret.size();
        }
    }
}
