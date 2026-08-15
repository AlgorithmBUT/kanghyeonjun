package 재귀;

//10진수의 각 자리수의 합

import java.io.*;

public class practice2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(sum(str, 0));
  }
  
  static int sum (String n, int len){
    if (len==n.length()-1){
      return (int) (n.charAt(n.length()-1)-'0');
    }
    return (int) (n.charAt(len)-'0')+sum(n, len+1);
  }
}