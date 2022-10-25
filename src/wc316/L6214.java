package wc316;

public class L6214 {
    L6214() {
        haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"});
    }

    public static void main(String[] args) {
        new L6214();
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        int e1s = Integer.parseInt(event1[0].replace(":", ""));
        int e1e = Integer.parseInt(event1[1].replace(":", ""));
        int e2s = Integer.parseInt(event2[0].replace(":", ""));
        int e2e = Integer.parseInt(event2[1].replace(":", ""));

        if (e1s >= e2s && e1s <= e2e) {
            return true;
        }

        if (e1e >= e2s && e1e <= e2e) {
            return true;
        }

        if (e1s <= e2s && e1e >= e2e) {
            return true;
        }

        if (e2s <= e1s && e2e >= e1e) {
            return true;
        }

        return false;

    }

    public boolean haveConflict2(String[] e1, String[] e2) {
        //如果兩個範圍重複
        //必定有一個x會符合
        //e1[0] <= x <= e1[1] && e2[0] <= x <= e2[1]
        //簡化
        //max(e1[0],e2[0]) <= x <= min(e1[1],e2[1])
        //簡化
        //e1[0] <= e2[1] && e2[0] <= e1[1]
        //因時間字串符合lexicographically，所以使用compareTo比大小
        return e1[0].compareTo(e2[1]) <= 0 && e2[0].compareTo(e1[1]) <= 0;
    }
}
