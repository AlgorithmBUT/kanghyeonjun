package 프로그래머스.Lv2.다음큰숫자;

class Solution {
    public int solution(int n) {

        int original = count(n);
        while(true){
            n++;
            if (original==count(n)) break;
        }
        return n;
    }

    int count (int num){
        String original = Integer.toBinaryString(num);
        int res=0;
        for (char c : original.toCharArray()){
            if (c=='1'){
                res++;
            }
        }
        return res;
    }
}