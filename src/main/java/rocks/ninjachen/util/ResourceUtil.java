package rocks.ninjachen.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ResourceUtil {

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

    /**
     * Parse 2d array
     * Reference: https://stackoverflow.com/questions/29546564/convert-string-into-a-two-dimensional-array
     *
     * @param str like "[[1,0,0],[0,0,0],[0,0,0]]"
     * @return java array
     */
    public static int[][] parse2dArray(String str) {
        str = str.replace("[", "");//replacing all [ to ""
        str = str.substring(0, str.length() - 2);//ignoring last two ]]
        String rowStrs[] = str.split("],");//separating all by "],"

        int matrix[][] = new int[rowStrs.length][rowStrs[0].split(",").length];//declaring two dimensional matrix for input

        for (int i = 0; i < rowStrs.length; i++) {
            rowStrs[i] = rowStrs[i].trim();//ignoring all extra space if the string s1[i] has
            String singleIntStr[] = rowStrs[i].split(",");//separating integers by ", "

            for (int j = 0; j < singleIntStr.length; j++) {
                int item = Integer.parseInt(singleIntStr[j]);
                matrix[i][j] = item;//adding single values
            }
        }
        return matrix;
    }

    public static List<List<Integer>> parse2dList(String str) {
        int[][] array = parse2dArray(str);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int[] ints = array[i];
            List<Integer> list = new ArrayList<>();
            Arrays.stream(ints).forEach(item -> list.add(item));
            lists.add(list);
        }
        return lists;
    }
}
