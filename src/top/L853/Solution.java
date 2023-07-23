package top.L853;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        if (position.length == 1) {
            return position.length;
        }

        // 計算每個位子要到目的地的時間
        float[] time = new float[target];
        int count = 0;
        for(int i = 0; i < position.length; i++) {
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }

        // 從最靠近的位子開始統計會有幾個車隊
        float prev_time = 0;
        for(int i = time.length-1; i >= 0; i--) {
            // 有個觀念是後面的車不管多快
            // 都會被前面的車擋住形成同個車隊
            // 所以我們可以利用prev_time紀錄前面車隊的抵達時間
            // prev_time > time[i]代表後面的車比較快，就自動被前面合併所以不列入
            if (prev_time < time[i]) {
                // 紀錄該車抵達所花時間
                prev_time = time[i];
                count++;
            }
        }
        return count;
    }
}