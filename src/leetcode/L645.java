package leetcode;

public class L645 {

    L645() {
    }

    public static void main(String[] args) {
        new L645();
    }

    public int[] findErrorNums(int[] nums) {

        int[] ans = new int[2];
        //計算每個數出現的次數
        int[] map = new int[nums.length];
        for (int i : nums) {
            map[i - 1]++;
        }

        for (int i = 0; i < map.length; i++) {
            //出現兩次代表重複
            if (map[i] == 2) {
                ans[0] = i + 1;
            }
            //都沒出現就是缺少的那個數
            if (map[i] == 0) {
                ans[1] = i + 1;
            }
        }

        return ans;
    }
}
