package 재귀;

//문자열이 palindrome인지

import java.io.*;

public class practice6 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String target = br.readLine().toString();
    System.out.println(rec(target, 0, target.length()-1));
  }
  
  static boolean rec (String str, int left, int right){
    if (left>right){
      return true;
    }
    if (str.charAt(left)!=str.charAt(right)){
      return false;
    }
    return rec(str, left+1, right-1);
  }
  
}
