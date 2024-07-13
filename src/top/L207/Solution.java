package top.L207;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /**
     * 檢測是否為拓譜排序
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 紀錄每個課前面有多少課
        int[] inCourses = new int[numCourses];
        // 紀錄每個課下面有多少課
        List<Integer>[] outCourses = new List[numCourses];
        for (int i = 0; i < outCourses.length; i++) {
            outCourses[i] = new LinkedList<>();
        }
        // 建立拓譜排序
        // 依賴關系為
        // [1,0] => 0->1
        for (int[] pair : prerequisites) {
            inCourses[pair[0]]++;
            // List是為了可記錄多點方向
            // [1,0],[2,0] => 0->1
            //                 └>2
            outCourses[pair[1]].add(pair[0]);
        }

        // 從前面沒有課的課開始計算
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inCourses.length; i++) {
            if (inCourses[i] == 0) {
                queue.add(i);
            }
        }
        // 記錄所有的邊有多少
        int edgeCnt = prerequisites.length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 移除該課程
            // 並更新相關紀錄
            for (int nextCourse : outCourses[cur]) {
                edgeCnt--;
                // 移除的過程中如果該課也變起始
                // 則加入下一個計算循環
                if (--inCourses[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        // 邊都可以完全移除代表拓譜排序成立
        return edgeCnt == 0;
    }

    /**
     * 利用紀錄課程的狀態解題
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        int n = prerequisites.length;
        // 紀錄每個課出現幾次
        int[] coursesCnt = new int[numCourses];
        // 紀錄該關聯是否已被計算過
        boolean[] isDone = new boolean[n];

        // 先把每個前置課都記錄下來
        for (int[] c : prerequisites) {
            coursesCnt[c[1]]++;
        }

        boolean needContinue = true;
        while (needContinue) {
            needContinue = false;
            for (int i = 0; i < n; i++) {
                // 該關聯如果尚未完成
                // 且課程也尚未上過
                // 則更新該課對應前置課程並繼續計算
                if (!isDone[i] && coursesCnt[prerequisites[i][0]] == 0) {
                    isDone[i] = true;
                    coursesCnt[prerequisites[i][1]]--;
                    // 本次計算還有找到isDone的則要繼續往下計算
                    needContinue = true;
                }
            }
        }

        // 檢查是否所有課程計數都為0
        // 拓譜排序成立的情況下會達成該條件
        for (int i = 0; i < numCourses; i++) {
            if (coursesCnt[i] != 0) {
                return false;
            }
        }

        return true;
    }
}