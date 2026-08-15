package 재귀;

// 배열이 오름차순인지 검사

public class practice10 {
  static int [] arr = {1,3,5,7,9,13,17};
  static int [] arr2 = {1,3,5,7,13,10,4};

  public static void main(String[] args) {
    System.out.println(rec(0, arr));
    System.out.println(rec(0, arr2));
  }

  static boolean rec(int idx, int[] arr){
    if (idx == arr.length-1){
      return true;
    }

    if (arr[idx] >= arr[idx+1]){
      return false;
    }
    
    return rec(idx+1, arr);
  }
}
