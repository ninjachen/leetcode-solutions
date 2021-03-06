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
        Integer[] integerArray = parseLineToIntegerArray(line);
        int[] arr = new int[integerArray.length];
        for(int i = 0; i < integerArray.length; i++) {
            arr[i] = integerArray[i];
        }
        return arr;
    }

    // nullable return value
    public static Integer[] parseLineToIntegerArray(String line) {
        char[] inputChars = line.toCharArray();
        List<Integer> outputList = new ArrayList<>();
        if (inputChars[0] == '[' && inputChars[inputChars.length - 1] == ']') {
            int startIndex = 1;
            for (int i = 1; i < inputChars.length - 1; i++) {
                char curChar = inputChars[i];
                if (curChar == ',') {
                    String intString = new String(Arrays.copyOfRange(inputChars, startIndex, i));
                    Integer item = "null".equals(intString) ? null : Integer.valueOf(intString);
                    outputList.add(item);
                    startIndex = i + 1;
                }
            }
            // last character
            outputList.add(Integer.valueOf(new String(Arrays.copyOfRange(inputChars, startIndex, inputChars.length - 1))));
        }
        return outputList.toArray(new Integer[outputList.size()]);
    }

    /**
     * @param line such as "["1","2","3","4"]" string
     * @return
     */
    public static String[] parseLineToStringArray(String line) {
        List<String> list = parseLineToStringList(line);
        return list.stream().toArray(String[]::new);
    }

    /**
     * @param line such as "[1.2,2.1,3,4]" string
     * @return
     */
    public static double[] parseLineToDoubleArray(String line) {
        char[] inputChars = line.toCharArray();
        List<Double> outputList = new ArrayList<>();
        if (inputChars[0] == '[' && inputChars[inputChars.length - 1] == ']') {
            int startIndex = 1;
            for (int i = 1; i < inputChars.length - 1; i++) {
                char curChar = inputChars[i];
                if (curChar == ',') {
                    Double item = Double.valueOf(new String(Arrays.copyOfRange(inputChars, startIndex, i)));
                    outputList.add(item);
                    startIndex = i + 1;
                }
            }
            outputList.add(Double.valueOf(new String(Arrays.copyOfRange(inputChars, startIndex, inputChars.length - 1))));
        }
        return outputList.stream().mapToDouble(d -> d).toArray();
    }

//    public static int[] parseLineToIntArray(String line) {
//        char[] inputChars = line.toCharArray();
//        List<Integer> outputList = new ArrayList<>();
//        if (inputChars[0] == '[' && inputChars[inputChars.length - 1] == ']') {
//            int i = 1, startIndex = 1;
//            for (; i < inputChars.length - 1; i++) {
//                char curChar = inputChars[i];
//                if (curChar == ',') {
//                    Integer item = Integer.valueOf(new String(Arrays.copyOfRange(inputChars, startIndex, i)));
//                    outputList.add(item);
//                    startIndex = i + 1;
//                }
//            }
//            Integer item = Integer.valueOf(new String(Arrays.copyOfRange(inputChars, startIndex, inputChars.length - 1)));
//            outputList.add(item);
//        }
//        int[] output = new int[outputList.size()];
//        for (int i = 0; i < outputList.size(); i++) {
//            output[i] = outputList.get(i);
//        }
//        return output;
//    }

    /**
     * @param line such as "["hot","dot","dog","lot","log","cog"]" string
     * @return
     */
    public static List<String> parseLineToStringList(String line) {
        char[] inputChars = line.toCharArray();
        List<String> outputList = new ArrayList<>();
        if (inputChars[0] == '[' && inputChars[inputChars.length - 1] == ']') {
            int i = 1, startIndex = 1;
            for (; i < inputChars.length - 1; i++) {
                char curChar = inputChars[i];
                if (curChar == ',') {
                    // Exclude the ""
                    String item = new String(Arrays.copyOfRange(inputChars, startIndex + 1, i - 1));
                    outputList.add(item);
                    startIndex = i + 1;
                }
            }
            String item = new String(Arrays.copyOfRange(inputChars, startIndex + 1, inputChars.length - 2));
            outputList.add(item);
        }
        return outputList;
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

    /**
     *
     * @param str [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * @return
     */
    public static char[][] parseLineToCharArray(String str) {
        str = str.replace("[", "");//replacing all [ to ""
        str = str.substring(0, str.length() - 2);//ignoring last two ]]
        String rowStrs[] = str.split("],");//separating all by "],"

        char matrix[][] = new char[rowStrs.length][rowStrs[0].split(",").length];//declaring two dimensional matrix for input

        for (int i = 0; i < rowStrs.length; i++) {
            rowStrs[i] = rowStrs[i].trim();//ignoring all extra space if the string s1[i] has
            String singleIntStr[] = rowStrs[i].split(",");//separating integers by ", "

            for (int j = 0; j < singleIntStr.length; j++) {
                char item = singleIntStr[j].toCharArray()[1];
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

    @SuppressWarnings("Duplicates")
    public static <T> String printList(List<T> ans) {
        StringBuilder sb = new StringBuilder();
        Iterator<T> innIt = ans.iterator();
        if (!innIt.hasNext()) {
            sb.append("[]");
            return sb.toString();
        } else {
            sb.append("[");
            for (; ; ) {
                T s = innIt.next();
                sb.append('"');
                sb.append(s);
                sb.append('"');
                if (!innIt.hasNext()) {
                    sb.append("]");
                    break;
                } else {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public static String print2dList(List<List<String>> ans) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<List<String>> it = ans.iterator();
        if (!it.hasNext())
            return "[]";

        for (; ; ) {
            List<String> e = it.next();
            Iterator<String> innIt = e.iterator();
            if (!innIt.hasNext()) {
                sb.append("[]");
                return sb.toString();
            } else {
                sb.append("[");
                for (; ; ) {
                    String s = innIt.next();
                    sb.append('"');
                    sb.append(s);
                    sb.append('"');
                    if (!innIt.hasNext()) {
                        sb.append("]");
                        break;
                    } else {
                        sb.append(',');
                    }
                }
                if (!it.hasNext())
                    return sb.append(']').toString();
                sb.append(',');
            }
        }
    }

    /**
     * Input "s"
     * Output s
     *
     * @param str
     * @return
     */
    public static String parseString(String str) {
        if (str.charAt(0) == '"' && str.charAt(str.length() - 1) == '"') {
            str = str.substring(1, str.length() -1);
        }
        return str;
    }

    public static String printArray(int[] ints) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0;i < ints.length; i++) {
            sb.append(ints[i]);
            if (i == ints.length -1) {
                sb.append("]");
            } else {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public static int[] toArray(List<Integer> list) {
        return list.stream().mapToInt(i->i).toArray();
    }

    public static TreeNode parseTreeNode(String s) {
        Integer[] intArray = parseLineToIntegerArray(s);
        TreeNode root = new TreeNode(intArray[0]);
        appendNode(intArray, root, 0);
        return root;
    }
    private static void appendNode(Integer[] arr, TreeNode node, int index) {
        int leftChildIndex = 2*index+1;
        int rightChildIndex = 2*index+2;
        if (leftChildIndex < arr.length && arr[leftChildIndex] != null) {
            TreeNode left = new TreeNode(arr[leftChildIndex]);
            node.left = left;
            appendNode(arr, node.left, leftChildIndex);
        }
        if (rightChildIndex < arr.length && arr[rightChildIndex] != null) {
            TreeNode right = new TreeNode(arr[rightChildIndex]);
            node.right = right;
            appendNode(arr, node.right, rightChildIndex);
        }
    }
}
