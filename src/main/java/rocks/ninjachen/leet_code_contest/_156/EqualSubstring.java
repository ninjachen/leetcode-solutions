package rocks.ninjachen.leet_code_contest._156;

public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        // l and r of slide window
        int l = 0, r = 0;
        int cost = 0;
        for (; r < len; r++) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));
            if(cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
        }
        return r - l;
    }
}
