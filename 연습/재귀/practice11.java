package 재귀;

// 숫자에 특정 숫자가 몇 번 등장?

public class practice11 {
  public static void main(String[] args) {
    int n = 987523941;
    int target = 9;
    System.out.println(rec(0, String.valueOf(n), target, 0));
  }

  static int rec (int idx, String str, int target, int sum){
    if (idx==str.length()){
      return sum;
    }

    if (str.charAt(idx)-'0'==target){
      sum+=1;
    }

    return rec (idx+1, str, target, sum);
  }
}
