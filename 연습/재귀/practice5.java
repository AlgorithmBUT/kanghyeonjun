package 재귀;

//크기가 n인 int[] arr에서 최대값 찾기

public class practice5 {
  static int max, target;
  static int[] arr;
  
  public static void main(String[] args) {

    arr = new int[] {11,45,32,81,93,6,5,27,72,56};

    System.out.println(rec(0));
  }

  static int rec (int start){
    if (start==target){
      return max;
    }
    max=Math.max(max,arr[start]);
    return rec(start+1);
  }
}
