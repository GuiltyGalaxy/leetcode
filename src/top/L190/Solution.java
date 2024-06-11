package top.L190;

class Solution {
    public int reverseBits(int n) {
        // 解題概念為字串反轉遞規
        // 不斷取中間位數對稱反轉
        // 12345678
        // 56781234
        // 78563412
        // 87654321

        // 使用>>>無符號位移
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        // 0xc = 1100,0x3 = 0011
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        // 0xa = 1010,0x5 = 0101
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);

        return n;
    }

    public int reverseBits2(int n) {

        if (n == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            // 有值則為1
            if ((n & 1) == 1) {
                result++;
            }
            // 將原始資料右移
            n >>>= 1;
        }

        return result;
    }
}