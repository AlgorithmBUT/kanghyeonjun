package 프로그래머스.Lv2.이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] ans = new int[2];
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        while(!sb.toString().equals("1")){
            StringBuilder tmp = new StringBuilder();
            for (char c : sb.toString().toCharArray()){
                if (c=='0'){
                    ans[1]+=1;
                } else{
                    tmp.append(c);
                }
            }
            sb.setLength(0);
            sb.append(change(tmp.length()));
            ans[0]+=1;
        }
        return ans;
    }
        
    //2진법으로 변환
    String change (int num){
        StringBuilder res = new StringBuilder();
        while (num>0){
            res.append(num%2);
            num/=2;
        }
        return res.reverse().toString();
    }
}