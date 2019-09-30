package rocks.ninjachen.leet_code_contest._156;


import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int i : arr) {
            occurrenceMap.put(i, occurrenceMap.getOrDefault(i, 0) + 1 );
        }
        BitSet bitSet = new BitSet();
        for (int key : occurrenceMap.keySet()) {
            int occurNum = occurrenceMap.get(key);
            if(bitSet.get(occurNum)) {
                return false;
            }
            bitSet.set(occurNum);
        }
        return true;
    }
}
