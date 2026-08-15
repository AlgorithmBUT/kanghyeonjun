package 재귀;

//구구단

public class practice15 {
  public static void main(String[] args) {
    System.out.println(rec(1,1));
  }

  static StringBuilder sb = new StringBuilder();
  static String rec(int start, int end){
    if (end==10){
      return sb.toString();
    }

    if (start==10){
      sb.append("\n");
      return rec(1,end+1);
    }

    sb.append(start*end).append(" ");

    return rec(start+1, end);
  }
}
