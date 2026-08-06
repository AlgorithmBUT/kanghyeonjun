package 프로그래머스.Lv1.다트게임;

class Solution {
    public int solution(String dartResult) {
        
      //점수
        int [] score = new int[3];
        int index = -1;             

        //조건에 맞게 score 넣기
        for (int i=0; i<dartResult.length(); i++){
          char c = dartResult.charAt(i);
          if (Character.isDigit(c)){
            index ++;
            // 숫자가 10인 경우
            if (c=='1' && i+1<dartResult.length() && dartResult.charAt(i+1)=='0'){
              score[index]=10;
              i++;
            } else{
              score[index]=c-'0';
            }
          } else {
            if (c=='S') continue;
            else if (c=='D') score[index]=(int) Math.pow(score[index],2);
            else if (c=='T') score[index]=(int) Math.pow(score[index],3);
            else if (c=='#') score[index]=-score[index];
            else if (c=='*'){
              if (index==0){
                score[index]*=2;
              } else {
                score[index-1]*=2;
                score[index]*=2;
              }
            }
          }
        }
        // score 더하기
        int ans =0;
        for (int sc : score){
          ans+=sc;
        }
        return ans;
    }
}