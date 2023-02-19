package contest.wc333.L2570;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        //題目有限定nums1與nums2個別不會出現重複ID，且是有排序了
        //依順序比較去add到list中
        while (i < m && j < n) {
            if (nums1[i][0] == nums2[j][0]) {
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        //把剩下的加上
        while (i < m) {
            list.add(nums1[i]);
            i++;
        }
        while (j < n) {
            list.add(nums2[j]);
            j++;
        }

        int[][] res = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}