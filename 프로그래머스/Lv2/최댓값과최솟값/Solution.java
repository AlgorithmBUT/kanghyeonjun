package 프로그래머스.Lv2.최댓값과최솟값;

class Solution {
    public String solution(String s) {
        String [] tmp = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String str : tmp){
            int t = Integer.parseInt(str);
            max=Math.max(max,t);
            min=Math.min(min,t);
        }
    return String.valueOf(min) + " " + String.valueOf(max);
    }
}
