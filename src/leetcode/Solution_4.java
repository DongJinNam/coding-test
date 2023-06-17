package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_4 {
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++)
            list.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            list.add(nums2[i]);

        Collections.sort(list);
        if (list.size() % 2 == 0) {
            double num1 = list.get(list.size() / 2 - 1);
            double num2 = list.get(list.size() / 2);
            return (num1 + num2) / 2;
        }
        return (double) list.get(list.size() / 2);

    }
}
