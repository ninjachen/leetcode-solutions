package rocks.ninjachen.leet_code_contest.bi_11;

import java.util.*;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        //Maybe sort first
         slots1 = sort(slots1);
         slots2 = sort(slots2);
        int index1 = 0, index2 = 0;
        while (true) {
            int[] slot1 = slots1[index1];
            int[] slot2 = slots2[index2];
            if (slot1[0] > slot2[1]) {
                index2++;
            } else if (slot1[1] < slot2[0]) {
                index1++;
            } else {
                if (slot1[0] <= slot2[0] && slot2[0] <= slot1[1] && slot1[1] <= slot2[1]) {
                    //[slot1[0], slot2[0], slot1[1], slot2[1]]
                    int curDurtaion = slot1[1] - slot2[0];
                    if (curDurtaion >= duration) {
                        return Arrays.asList(slot2[0], slot2[0] + duration);
                    } else {
                        index1++;
                    }
                } else if (slot1[0] <= slot2[0] && slot2[0] <= slot2[1] && slot2[1] <= slot1[1]) {
                    //[slot1[0], slot2[0], slot2[1], slot1[1]], slot1 contains slot2
                    int curDurtaion = slot2[1] - slot2[0];
                    if (curDurtaion >= duration) {
                        return Arrays.asList(slot2[0], slot2[0] + duration);
                    } else {
                        index2++;
                    }
                } else if (slot2[0] <= slot1[0] && slot1[0] <= slot2[1] && slot2[1] <= slot1[1]) {
                    //[slot2[0], slot1[0], slot2[1], slot1[1]]
                    int curDurtaion = slot2[1] - slot1[0];
                    if (curDurtaion >= duration) {
                        return Arrays.asList(slot1[0], slot1[0] + duration);
                    } else {
                        index2++;
                    }
                } else if (slot2[0] <= slot1[0] && slot1[0] <= slot1[1] && slot1[1] <= slot2[1]) {
                    //[slot2[0], slot1[0], slot1[1], slot2[1]], slot2 contains slot1
                    int curDurtaion = slot1[1] - slot1[0];
                    if (curDurtaion >= duration) {
                        return Arrays.asList(slot1[0], slot1[0] + duration);
                    } else {
                        index1++;
                    }
                }
            }
            // Scan finished.
            if (index1 >= slots1.length || index2 >= slots2.length) {
                return new ArrayList<>();
            }
        }
    }

    private int[][] sort(int[][] slots) {
        Map<Integer, int[]> sortMap = new HashMap<>();
        for (int[] slot : slots) {
            sortMap.put(slot[0], slot);
        }
        List<Integer> keys = new ArrayList<>(sortMap.keySet());
        Collections.sort(keys);
        slots = new int[slots.length][slots[0].length];
        for (int i = 0; i < keys.size(); i++) {
            slots[i] = sortMap.get(keys.get(i));
        }
        return slots;
    }
}
