package 프로그래머스.Lv2.타겟넘버;

class Solution {
  
    static int answer = 0;

    public int solution(int[] numbers, int target) {

      dfs(0, target, 0, numbers);

      return answer;
    }

    
    static void dfs (int d, int target, int sum, int[] numbers){
      if (d==numbers.length){
        if (sum == target){
          answer+=1;
        }
        return;
      }
      
      dfs(d+1, target, sum+numbers[d], numbers);
      dfs(d+1, target, sum-numbers[d], numbers);
      
    }
}
