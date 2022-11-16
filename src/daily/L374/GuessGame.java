package daily.L374;

public class GuessGame {

    private int n;

    GuessGame(int n) {
        this.n = n;
    }

    /**
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number <p>
     *			      1 if num is lower than the picked number <p>
     *               otherwise return 0 <p>
     */
    protected int guess(int num) {
        return Integer.compare(n, num);
    }

}
