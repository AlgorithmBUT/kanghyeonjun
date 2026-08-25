package 프로그래머스.Lv3.외벽점검;

import java.util.*;

class Solution {

    static boolean[] check;                 // 각 위치가 이미 점검되었는지 여부
    static int[] weakPoint;                 // 취약 지점 위치 목록
    static int[] distAmount;                // 친구별 점검 가능 거리
    static int N;                           // 외벽 전체 길이
    static int ans = Integer.MAX_VALUE;     // 필요한 최소 친구 수
    static Set<Integer> remain;             // 아직 점검되지 않은 취약 지점 집합

    public int solution(int n, int[] weak, int[] dist) {

        N=n;
        weakPoint=weak;
        check = new boolean[n];
        remain = new HashSet<>();

        // 실제 취약 지점은 false
        Arrays.fill(check, true);
        for (int w : weak){
            check[w]=false;
            remain.add(w);
        }

        // 거리가 큰 것부터 사용
        int[] sortDist = Arrays.stream(dist)
                                .boxed()
                                .sorted(Comparator.reverseOrder())
                                .mapToInt(Integer::intValue)
                                .toArray();

        distAmount = sortDist;

        dfs(0);

        return ans==Integer.MAX_VALUE? -1:ans;
    }

    static void dfs (int cnt){

        // 이미 구한 최소 친구 수 이상 사용했다면 더 탐색할 필요 없음
        if (cnt>=ans){
            return;
        }

        // 모든 취약 지점을 점검한 경우
        if (remain.size()==0){
            ans=cnt;
            return;
        }

        // 사용할 수 있는 친구를 모두 사용했는데 아직 취약 지점이 남아 있는 경우
        if (cnt==distAmount.length){
            return;
        }

        // 현재 친구를 시작시킬 취약 지점을 하나씩 탐색
        for (int w : weakPoint){

            // 아직 점검되지 않은 취약 지점만 시작점 후보로 사용
            if (!check[w]){

                // 현재 친구가 점검한 위치 기록 및 DFS 종료 후 상태 복구를 위해 사용
                List<Integer> blank = new ArrayList<>();

                // 현재 시작점 w부터 현재 친구의 점검 가능 거리만큼 시계 방향으로 이동
                for (int k = w; k<=w+distAmount[cnt]; k++){

                    // 원형 외벽이므로 N을 넘어가면 다시 0부터 시작
                    int circleK = k%N;

                    // 아직 점검하지 않은 취약 지점인 경우
                    if (!check[circleK]){
                        check[circleK]=true;
                        remain.remove(circleK);
                        blank.add(circleK);
                    }
                }

                // 다음 친구
                dfs (cnt+1);

                // 백트래킹: 현재 친구가 점검했던 취약 지점을 다시 원상 복구
                for (int b : blank){
                    check[b]=false;
                    remain.add(b);
                }
            }
        }
    }
}