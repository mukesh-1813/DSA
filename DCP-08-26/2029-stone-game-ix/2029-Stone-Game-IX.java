class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] cnt = new int[3];

        for (int x : stones) {
            cnt[x % 3]++;
        }

        return check(cnt.clone()) || check(new int[]{cnt[0], cnt[2], cnt[1]});
    }

    private boolean check(int[] cnt) {

        // Alice must start with a remainder-1 stone
        if (--cnt[1] < 0) {
            return false;
        }

        int moves = 1 + Math.min(cnt[1], cnt[2]) * 2;

        if (cnt[1] > cnt[2]) {
            cnt[1]--;
            moves++;
        }

        // Remainder-0 stones add extra turns
        moves += cnt[0];

        return moves % 2 == 1
                && cnt[1] != cnt[2];
    }
}