package rocks.ninjachen.leet_code_contest._168;

import java.util.HashSet;
import java.util.Set;

public class MaxCandies {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candiesNum = 0;
        Set<Integer> ownedBoxes = new HashSet<>();
        Set<Integer> ownedKeys = new HashSet<>();
        Set<Integer> boxesToOpen = new HashSet<>();
        for (int i : initialBoxes) {
            boxesToOpen.add(i);
        }
        while (!boxesToOpen.isEmpty()) {
            for (int i : boxesToOpen) {
                if (status[i] == 0) {
                    ownedBoxes.add(i);
                } else {
                    candiesNum += candies[i];
                    //
                    int[] keysInside = keys[i];
                    for (int key : keysInside)
                        ownedKeys.add(key);
                    int[] containedBox = containedBoxes[i];
                    for (int box : containedBox) {
                        ownedBoxes.add(box);
                    }
                }
            }
            boxesToOpen.clear();
            for (int i : ownedBoxes) {
                if (status[i] == 1 || ownedKeys.contains(i)) {
                    ownedKeys.remove(i);
                    boxesToOpen.add(i);
                }
            }
            ownedBoxes.removeAll(boxesToOpen);
        }

        return candiesNum;
    }
}
