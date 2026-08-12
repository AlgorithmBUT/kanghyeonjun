package 프로그래머스.Lv2.n2배열자르기;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int l = (int) left;
        int r = (int) right;
        
        int [] ans = new int[r-l+1];
        int idx = 0;
        for (int i =l; i<=r; i++){
          ans[idx++]=(Math.max(i%n, i/n)+1);
        }
      return ans;
    }
}
