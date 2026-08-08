package 프로그래머스.Lv2.JadenCase문자열만들기;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean first = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append(c);
                first = true;
            } else {
                if (first) {
                    sb.append(Character.toUpperCase(c));
                    first = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }
}