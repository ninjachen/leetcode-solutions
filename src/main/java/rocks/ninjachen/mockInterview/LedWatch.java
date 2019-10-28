package rocks.ninjachen.mockInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Should visit all the minutes and hours, and then determine is equals bit set num
 */
public class LedWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                if (Integer.bitCount(hour) + Integer.bitCount(min) == num) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(hour);
                    sb.append(":");
                    if (min < 10)
                        sb.append("0");
                    sb.append(min);
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }
}
