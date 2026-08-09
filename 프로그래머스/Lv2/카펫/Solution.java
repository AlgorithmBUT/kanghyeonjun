package 프로그래머스.Lv2.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i=1; i<=(int)Math.sqrt(yellow); i++){
            if (yellow%i==0){
                int y = i+2;
                int x = (yellow/i)+2;
                System.out.println(y*x);
                if (y*x == brown+yellow){
                    answer[0]=x;
                    answer[1]=y;
                    break;
                }
            }
        }
        return answer;
    }
}