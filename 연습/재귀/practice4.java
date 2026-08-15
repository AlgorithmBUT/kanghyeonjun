package 재귀;

//크기가 n인 int[] arr에서 최대값 찾기

public class practice4 {
  public static void main(String[] args) {
    int n = 10;
    int[] arr = {11,45,32,81,93,6,5,27,72,56};

    System.out.println(rec(0, arr, 0, n));
  }

  static int rec (int start, int[] arr, int max, int target){
    if (start==target){
      return max;
    }
    max=Math.max(max,arr[start]);
    return rec(start+1, arr, max, target);
  }
}
