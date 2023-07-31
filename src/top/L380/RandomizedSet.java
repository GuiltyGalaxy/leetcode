package top.L380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    private final Random rand = new Random();
    private final HashMap<Integer, Integer> map = new HashMap<>();
    private final ArrayList<Integer> list = new ArrayList<>();

    /**
     * 單純使用HashSet的話
     * getRandom會不是O(1)
     */
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        //紀錄該val的index
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * ArrayList直接移除不會是O(1)
     * 只有在移除的目標為最後時才會
     * 所以要替換掉要移除的數字到list的最後面
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        //取得該val的index
        int i = map.get(val);

        //如果不是最後的數需調換
        if (i < list.size() - 1) {
            //取最後的值
            int lost_val = list.get(list.size() - 1);
            //取代掉要移除的
            list.set(i, lost_val);
            //更新lost_val的index
            map.put(lost_val, i);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}