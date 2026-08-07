package 프로그래머스.Lv1.바탕화면정리;

class Solution {
    public int[] solution(String[] wallpaper) {
      int minx = wallpaper.length;
      int maxx = 0;
      int miny = wallpaper[0].length();
      int maxy = 0;
      for (int i=0; i<wallpaper.length; i++){
        for (int j=0; j<wallpaper[i].length(); j++){
          if (wallpaper[i].charAt(j)=='#'){
            minx=Math.min(minx,i);
            miny=Math.min(miny,j);
            maxx=Math.max(maxx,i);
            maxy=Math.max(maxy,j);
          }
        }
      }

      int[] ans = new int[4];
      ans[0]=minx;
      ans[1]=miny;
      ans[2]=maxx+1;
      ans[3]=maxy+1;

    return ans;
    }
}