package 프로그래머스.Lv1.개인정보수집유효기간;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> ans = new ArrayList<>();

        // term map 만들기 A:6 B:12 이런 느낌
        Map<String, Integer> termmap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            termmap.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        // privacies 하나씩 확인하기
        for (int i = 0; i < privacies.length; i++) {

            String[] tmp = privacies[i].split(" ");
            String[] date = tmp[0].split("\\.");

            int d = termmap.get(tmp[1]);

            int totalMonth = Integer.parseInt(date[1]) + d;

            if (totalMonth > 12) {
                int up = (totalMonth - 1) / 12;
                int temp = (totalMonth - 1) % 12 + 1;
                // 월을 항상 2자리로
                date[1] = String.format("%02d", temp);
                date[0] = String.valueOf(Integer.parseInt(date[0]) + up);
            } else {
                // 월을 항상 2자리로
                date[1] = String.format("%02d", totalMonth);
            }
            //문자열 합쳐서 숫자로 만들기
            StringBuilder todayy = new StringBuilder();
            StringBuilder pri = new StringBuilder();
            for (String s : date) {
                pri.append(s);
            }
            for (String s : today.split("\\.")) {
                todayy.append(s);
            }
            //ans에 유효기간보다 넘은 것 넣기
            if (Integer.parseInt(todayy.toString())>= Integer.parseInt(pri.toString())) {
                ans.add(i+1);
            }
        }
        //정답 배열
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}