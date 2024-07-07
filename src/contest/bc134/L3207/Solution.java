package contest.bc134.L3207;


class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {

        long total = currentEnergy;
        long min = Integer.MAX_VALUE;
        // 先計算總共可獲得多少能量(把所有敵人都mark)
        // 同時找出最弱的敵人
        for (int e : enemyEnergies) {
            total += e;
            min = Math.min(min, e);
        }

        // 當前能量連最弱都打不贏則0分
        if(currentEnergy < min){
            return 0;
        }

        // 最弱的不可被標記，所以移除
        total -= min;

        // 把可獲得的能量都拿去打最弱分數就是最高
        return total / min;
    }
}