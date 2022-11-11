package top.L207;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //進入點次數
        int[] incomingEdges = new int[numCourses];
        //方向紀錄
        List<Integer>[] goCourses = new List[numCourses];
        for (int i = 0; i < goCourses.length; i++) {
            goCourses[i] = new LinkedList<>();
        }
        //建立拓譜排序
        //依賴關系為
        //[1,0] => 0->1
        for (int[] pair : prerequisites) {
            incomingEdges[pair[0]]++;
            //List是為了可記錄多點方向
            //[1,0],[2,0] => 0->1
            //                └>2
            goCourses[pair[1]].add(pair[0]);
        }

        //從incomingEdges==0開始做移除
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < incomingEdges.length; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        //edgeCnt紀錄所移除的邊
        int edgeCnt = prerequisites.length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            //將該點所有的邊移除
            for (int goCrs : goCourses[cur]) {
                edgeCnt--;
                //移除的過程中如果該點也變頂點
                //則加入下一個移除循環
                if (--incomingEdges[goCrs] == 0) {
                    queue.add(goCrs);
                }
            }
        }
        //邊都可以完全移除代表拓譜排序成立
        return edgeCnt == 0;
    }
}