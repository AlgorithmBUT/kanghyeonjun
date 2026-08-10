package 프로그래머스.Lv2.N개의최소공배수;

class Solution {
    public int solution(int[] arr) {
      
        int l = arr[0];
        for (int i=1; i<arr.length; i++){
          l = lcm(l,arr[i]);
        }
        return l;
    }

    int gcd (int a, int b){
      if(b==0){
        return a;
      }
      return gcd (b, a%b);
    }

    int lcm (int a, int b){
      return a*b/gcd(a,b);
    }
}