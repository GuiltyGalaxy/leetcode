package wc317;

public class L6220 {
    L6220() {

    }

    public static void main(String[] args) {
        new L6220();
    }

    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for (int i : nums) {
            //紀錄符合條件的
            if (i % 3 == 0 && i % 2 == 0) {
                sum += i;
                cnt++;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }

}
