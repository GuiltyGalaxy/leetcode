package daily.L1704;

class Solution {

    public boolean halvesAreAlike(String s) {
        //從中間開始往兩邊找
        int L = s.length() / 2 - 1;
        int R = L + 1;
        int cntL = 0;
        int cntR = 0;
        while (L >= 0) {
            if (check(s.charAt(L--))) {
                cntL++;
            }
            if (check(s.charAt(R++))) {
                cntR++;
            }
        }
        //最後比對結果
        return cntL == cntR;
    }

    private boolean check(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
}