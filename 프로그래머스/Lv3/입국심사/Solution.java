package 프로그래머스.Lv3.입국심사;

class Solution {
    public long solution(int n, int[] times) {

        long left = 0;

        // 최대 시간 구하기
        long maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }

        long right = maxTime * n;

        while (left<=right){
            long mid=(left+right)/2;

            long people=0;

            for (long time : times){
                people+=mid/time;
            }

            if (people>=n){
                right=mid-1;    // 가능하니까 시간 감소
            }

            if (people<n){
                left=mid+1;     // 불가능하므로 시간 증가
            }
        }

        return left;
    }
}
