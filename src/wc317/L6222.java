package wc317;


public class L6222 {
    L6222() {
        makeIntegerBeautiful(846, 1);
    }

    public static void main(String[] args) {
        new L6222();
    }

    public long makeIntegerBeautiful(long n, int target) {

        long tmp = n;
        long cnt = 1;
        //要符合總數加起來小於target
        //每次的最佳解就是將最小位數轉換成0
        //ex. n = 123456 , target = 4
        //123456 => 123460
        //123460 => 123500
        //123500 => 124000
        //124000 => 130000 (1+3 <= 4達成)
        //asn = 130000 - 123456 = 6544
        while (sum(tmp) > target) {
            long base = pow(10, cnt);
            long dif = base - tmp % base;
            tmp += dif;
            cnt++;
        }

        return tmp - n;
    }

    public int sum(long ln) {
        String s = String.valueOf(ln);
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }

    public long pow(long a, long b) {
        for (long i = 1; i < b; i++) {
            a *= 10;
        }
        return a;
    }

}
