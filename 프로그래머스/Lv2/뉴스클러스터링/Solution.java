package 프로그래머스.Lv2.뉴스클러스터링;

import java.util.*;

class Solution {

    static Map<String, Integer> map1 = new HashMap<>();
    static Map<String, Integer> map2 = new HashMap<>();
    static int union = 0;
    static int intersection = 0;

    public int solution(String str1, String str2) {
        double answer = 0;

        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        for (int i=0; i< str1.length()-1; i++){
            if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))){
                map1.put(str1.substring(i,i+2),map1.getOrDefault(str1.substring(i,i+2), 0)+1);
            }
        }

        for (int i=0; i< str2.length()-1; i++){
            if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1))){
                map2.put(str2.substring(i,i+2),map2.getOrDefault(str2.substring(i,i+2), 0)+1);
            }
        }

        for (String key : map1.keySet()){
            if (map2.containsKey(key)){
                intersection+=Math.min(map1.get(key), map2.get(key));
            }
        }

        for (String key : map1.keySet()){
            if (map2.containsKey(key)){
                union+=Math.max(map1.get(key), map2.get(key));
            } else {
                union+=map1.get(key);
            }
        }

        for (String key : map2.keySet()){
            if (!map1.containsKey(key)){
                union+=map2.get(key);
            }
        }

        if (union==0){
            answer = 1*65536;
        } else {
            answer = intersection*65536/union;
        }

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(union);
        System.out.println(intersection);

        return (int) answer;
    }
}
