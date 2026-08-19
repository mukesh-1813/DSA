import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }

        int ans = 0;

        // Rows without any reservation can always have 2 families
        ans += (n - map.size()) * 2;

        // Check only rows having reserved seats
        for (HashSet<Integer> set : map.values()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // 2 3 4 5
            for (int j = 2; j <= 5; j++) {
                if (set.contains(j)) {
                    left = false;
                    break;
                }
            }

            // 4 5 6 7
            for (int j = 4; j <= 7; j++) {
                if (set.contains(j)) {
                    middle = false;
                    break;
                }
            }

            // 6 7 8 9
            for (int j = 6; j <= 9; j++) {
                if (set.contains(j)) {
                    right = false;
                    break;
                }
            }

            // Left and right don't overlap
            if (left) {
                ans++;
            }

            if (right) {
                ans++;
            }
            // Middle can be used only when left and right
            // are not available
            else if (!left && middle) {
                ans++;
            }
        }

        return ans;
    }
}