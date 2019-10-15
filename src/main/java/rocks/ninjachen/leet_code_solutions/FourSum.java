package rocks.ninjachen.leet_code_solutions;

import java.util.*;

/**
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<String> hashSet = new HashSet<>();
        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> answer = new ArrayList<>();
                            answer.add(nums[i]);
                            answer.add(nums[j]);
                            answer.add(nums[k]);
                            answer.add(nums[l]);
                            Collections.sort(answer);
                            String hash = String.format("%s_%s_%s_%s", answer.get(0), answer.get(1), answer.get(2), answer.get(3));
                            if (!hashSet.contains(hash)) {
                                hashSet.add(hash);
                                answers.add(answer);
                            }
                        }
                    }
                }
            }
        }
        return answers;
    }
}
