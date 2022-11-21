package daily.L1926;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        //BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1], 0});

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] p = q.poll();
                int y = p[0];
                int x = p[1];
                int ans = p[2];
                //沒路就不找了
                if (maze[y][x] == '+') {
                    continue;
                }
                //起點不能當作出口
                boolean isStart = entrance[0] == y && entrance[1] == x;
                boolean isEdge = y == 0 || x == 0 || y == maze.length - 1 || x == maze[0].length - 1;
                if (isEdge && !isStart) {
                    return ans;
                }
                ans++;
                //走過的地方設成牆壁
                maze[y][x] = '+';
                //把下一輪能走的點add queue
                if (y < maze.length - 1 && maze[y + 1][x] == '.') {
                    q.add(new int[]{y + 1, x, ans});
                }
                if (y > 0 && maze[y - 1][x] == '.') {
                    q.add(new int[]{y - 1, x, ans});
                }
                if (x < maze[0].length - 1 && maze[y][x + 1] == '.') {
                    q.add(new int[]{y, x + 1, ans});
                }
                if (x > 0 && maze[y][x - 1] == '.') {
                    q.add(new int[]{y, x - 1, ans});
                }
            }
        }

        return -1;
    }


}