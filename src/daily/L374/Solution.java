package daily.L374;

public class Solution extends GuessGame {
    Solution(int n) {
        super(n);
    }

    /**
     * 猜數字遊戲，最快的猜法就是用2分法猜
     */
    public int guessNumber(int n) {
        int i = 1, j = n;
        while(i < j) {
            int mid = i + (j - i) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}