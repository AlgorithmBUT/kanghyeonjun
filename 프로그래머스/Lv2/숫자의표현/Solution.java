package 프로그래머스.Lv2.숫자의표현;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int start=1; start<=n; start++){
            int tmp=0;
            for (int i=start; i<=n; i++){
                tmp+=i;
                if(tmp==n){
                    answer++;
                    break;
                }
                if (tmp>n){
                    break;
                }
            }
        }
        return answer;
    }
}
