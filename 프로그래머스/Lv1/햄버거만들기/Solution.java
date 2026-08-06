package 프로그래머스.Lv1.햄버거만들기;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        int[] ingre = new int[ingredient.length];
        
        int point = 0;
        for (int num : ingredient){
          ingre[point++]=num;

          if (point>=4){
            if (ingre[point-4]==1 && 
                ingre[point-3]==2 && 
                ingre[point-2]==3 && 
                ingre[point-1]==1){
              answer++;
              point-=4;
            } 
          }
        }
        return answer;
    }
}

