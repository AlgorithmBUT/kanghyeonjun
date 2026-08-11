package 프로그래머스.Lv2.예상대진표;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while (true){
          a=change(a);
          b=change(b);
          answer++;
          if (a==b){
            break;
          }
        }
        return answer;
    }

    int change (int num){
      if (num%2==1){
        num+=1;
      }
      return num/2;
    }
}