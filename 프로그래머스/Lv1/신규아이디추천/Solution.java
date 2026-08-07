package 프로그래머스.Lv1.신규아이디추천;

class Solution {
    public String solution(String new_id) {

        // 1단계
        StringBuilder one = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            one.append(Character.toLowerCase(new_id.charAt(i)));
        }
        // 2단계
        StringBuilder two = new StringBuilder();
        for (int i = 0; i < one.length(); i++) {
            char c = one.charAt(i);
            if (Character.isDigit(c)
                    || Character.isAlphabetic(c)
                    || c == '-'
                    || c == '_'
                    || c == '.') {
                two.append(c);
            }
        }
        // 3단계
        StringBuilder three = new StringBuilder();
        for (int i = 0; i < two.length(); i++) {
            if (two.charAt(i) == '.'
                    && three.length() > 0
                    && two.charAt(i - 1) == '.') {
                continue;
            }
            three.append(two.charAt(i));
        }
        // 4단계
        if (three.length() > 0 && three.charAt(0) == '.') {
            three.deleteCharAt(0);
        }
        if (three.length() > 0
                && three.charAt(three.length() - 1) == '.') {
            three.deleteCharAt(three.length() - 1);
        }
        // 5단계
        if (three.length() == 0) {
            three.append('a');
        }
        // 6단계
        if (three.length() >= 16) {
            three.setLength(15);
        }
        if (three.charAt(three.length() - 1) == '.') {
            three.deleteCharAt(three.length() - 1);
        }
        // 7단계
        if (three.length() <= 2) {
            while (three.length() != 3) {
                three.append(three.charAt(three.length() - 1));
            }
        }
        return three.toString();
    }
}