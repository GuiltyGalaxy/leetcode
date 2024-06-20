package top.L621;

import java.util.Arrays;

class Solution {

    public int leastInterval(char[] tasks, int n) {
        // 計算最每個任務的次數
        int[] frequency = new int[26];
        for (char task : tasks) {
            frequency[task - 'A']++;
        }
        Arrays.sort(frequency);

        int maxFrequency = frequency[25];
        int maxCount = 0;
        // 取得有多少任務為最大頻率
        for (int f : frequency) {
            if (f == maxFrequency) {
                maxCount++;
            }
        }

        // 解釋(maxFrequency - 1) * (n + 1) + maxCount公式
        // 出現最多次的任務一定會組在一起，那剩餘任務就可以填充於各個任務之間
        // 至於填充的量剛好為n+1
        // 所以不用去計較除了最大處合的任務之外的剩餘任務，因為一定可利用中間的時間填滿
        // 比如說AAAABBBEEFFGG 3
        // 將A先排出來
        // A---A---A---A
        // 這時我們可以先忽略最後個A
        // 發現被切隔成maxFrequency - 1 = 4 - 1 = 3區塊
        // A---A---A---
        // 每塊的長度為 n + 1 = 3 + 1 = 4
        // 這樣就可證明最少時間一定為(maxFrequency - 1) * (n + 1)
        // 這時我們把原先忽略的A補上來
        // 所以需要maxCount來補正(因最大頻率相同的任務會被當作切割元素一定會補在最後)
        // 如果任務都沒重複tasks.length可能一次做完所以要比較最小可能
        return Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxCount);
    }
}