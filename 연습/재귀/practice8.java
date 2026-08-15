package 재귀;

// 배열의 합을 반으로 나눠 계산

public class practice8 {

  static int[] arr = {1,2,3,4,5,6,7,8};
  public static void main(String[] args) {
    System.out.println(rec(0, arr.length-1));
  }

  static int rec (int start, int end){
    if (start==end){
      return arr[start];
    }

    int mid = (start+end)/2;
    
    int left = rec(start, mid);
    int right = rec(mid+1, end);

    return left+right;
  }
}
