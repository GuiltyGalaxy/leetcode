package contest.wc410.L3248;


import java.util.List;

class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for (String cmd : commands) {
            switch (cmd) {
                case "UP" -> x -= 1;
                case "DOWN" -> x += 1;
                case "RIGHT" -> y += 1;
                case "LEFT" -> y -= 1;
            }
        }

        return x * n + y;
    }
}
