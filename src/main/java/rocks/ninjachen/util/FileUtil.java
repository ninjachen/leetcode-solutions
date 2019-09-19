package rocks.ninjachen.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FileUtil {

    public static List<String> getResourceLines(ClassLoader classLoader, String name) {
        InputStream expectIn = classLoader.getResourceAsStream(name);
        HashMap<int[], String> testCases = new HashMap<>();
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader inputreader = new BufferedReader(new InputStreamReader(expectIn));
            /** Read test case file into map(named testCases), structure is <input, expect> **/
            if (inputreader != null) {
                String line;
                while ((line = inputreader.readLine()) != null) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                expectIn.close();
            } catch (Throwable ignore) {
            }
        }
        return lines;
    }

    /**
     * @param line such as "[1,2,3,4]" string
     * @return
     */
    public static int[] parseLineToIntArray(String line) {
        char[] inputChars = line.toCharArray();
        List<Integer> outputList = new ArrayList<>();
        if (inputChars[0] == '[' && inputChars[inputChars.length - 1] == ']') {
            for (int i = 1, startIndex = 1; i < inputChars.length - 1; i++) {
                char curChar = inputChars[i];
                if (curChar == ',') {
                    Integer item = Integer.valueOf(new String(Arrays.copyOfRange(inputChars, startIndex, i)));
                    outputList.add(item);
                    startIndex = i + 1;
                }
            }
        }
        int[] output = new int[outputList.size()];
        for (int i = 0; i < outputList.size(); i++) {
            output[i] = outputList.get(i);
        }
        return output;
    }
}
