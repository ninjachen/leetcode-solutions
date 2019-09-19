package rocks.ninjachen.leet_code_contest._154;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/weekly-contest-154/problems/maximum-number-of-balloons/
 */
public class MaxNumbersOfBallons {
    public static void main(String[] arg){
        MaxNumbersOfBallons maxNumbersOfBallons = new MaxNumbersOfBallons();
        System.out.println(maxNumbersOfBallons.maxNumberOfBalloons("nlaebolko"));
    }

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> ballonsMap = new HashMap<>();
        for (Character c : "balloon".toCharArray()) {
            Integer num = ballonsMap.getOrDefault(c, 0);
            ballonsMap.put(c, ++num);
        }

        Map<Character, Integer> textMap = new HashMap<>();
        for (Character c : text.toCharArray()) {
            Integer num = textMap.getOrDefault(c, 0);
            textMap.put(c, ++num);
        }

        int minMultiple = -1;
        for (Character c : ballonsMap.keySet()) {
            int numInBallon = ballonsMap.get(c);
            int numInText = textMap.getOrDefault(c, 0);
            int multiple = numInText / numInBallon;
            if(minMultiple == -1 || minMultiple > multiple){
                minMultiple = multiple;
            }
        }
        if(minMultiple == -1){
            minMultiple = 0;
        }
        return minMultiple;
    }
}
